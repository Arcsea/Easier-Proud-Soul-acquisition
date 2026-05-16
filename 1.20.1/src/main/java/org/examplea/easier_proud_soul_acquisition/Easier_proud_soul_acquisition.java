package org.examplea.easier_proud_soul_acquisition;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.examplea.easier_proud_soul_acquisition.block.ModBlocks;
import org.examplea.easier_proud_soul_acquisition.block.custom.ProudSoulCropBlock;
import org.examplea.easier_proud_soul_acquisition.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Easier_proud_soul_acquisition.MODID)
public class Easier_proud_soul_acquisition {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "easier_proud_soul_acquisition";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Easier_proud_soul_acquisition() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register our items and blocks
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        // Register for creative tab events
        modEventBus.addListener(this::onBuildCreativeModeTabContents);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Easier Proud Soul Acquisition loaded.");
    }

    // Server starting event - registered on Forge event bus
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public void onLootTableLoad(net.minecraftforge.event.LootTableLoadEvent event) {
        if (event.getName().equals(Blocks.GRASS.getLootTable()) ||
            event.getName().equals(Blocks.TALL_GRASS.getLootTable()) ||
            event.getName().equals(Blocks.FERN.getLootTable())) {

            event.getTable().addPool(
                net.minecraft.world.level.storage.loot.LootPool.lootPool()
                    .add(net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem(ModItems.PROUDSOUL_SEED.get())
                        .when(net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition.randomChance((float)Config.grassSeedChance())))
                    .build()
            );
        }
    }

    public void onBuildCreativeModeTabContents(net.minecraftforge.event.BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.PROUDSOUL_SEED);
        }
        // Also try the ingredients tab as backup
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.PROUDSOUL_SEED);
        }
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
