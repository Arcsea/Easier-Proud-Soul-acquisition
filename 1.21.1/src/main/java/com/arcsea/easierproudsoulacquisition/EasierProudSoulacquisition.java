package com.arcsea.easierproudsoulacquisition;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import com.arcsea.easierproudsoulacquisition.block.ModBlocks;
import com.arcsea.easierproudsoulacquisition.item.ModItems;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EasierProudSoulacquisition.MODID)
public class EasierProudSoulacquisition {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "easierproudsoulacquisition";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public EasierProudSoulacquisition(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register our items and blocks
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("Easier Proud Soul Acquisition loaded.");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the natural blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.PROUDSOUL_SEED);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    
    @SubscribeEvent
    public void onLootTableLoad(net.neoforged.neoforge.event.LootTableLoadEvent event) {
        ResourceLocation grass = BuiltInRegistries.BLOCK.getKey(Blocks.SHORT_GRASS);
        ResourceLocation tallGrass = BuiltInRegistries.BLOCK.getKey(Blocks.TALL_GRASS);
        ResourceLocation fern = BuiltInRegistries.BLOCK.getKey(Blocks.FERN);
        
        if (event.getName().equals(grass.withPrefix("blocks/")) ||
            event.getName().equals(tallGrass.withPrefix("blocks/")) ||
            event.getName().equals(fern.withPrefix("blocks/"))) {

            event.getTable().addPool(
                net.minecraft.world.level.storage.loot.LootPool.lootPool()
                    .add(net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem(ModItems.PROUDSOUL_SEED.get())
                        .when(net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition.randomChance(Config.GRASS_SEED_CHANCE.get().floatValue())))
                    .build()
            );
            LOGGER.info("Added proudsoul seed to grass loot table: {}", event.getName());
        }
    }
}
