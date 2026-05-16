package org.examplea.easier_proud_soul_acquisition.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.examplea.easier_proud_soul_acquisition.Easier_proud_soul_acquisition;
import org.examplea.easier_proud_soul_acquisition.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Easier_proud_soul_acquisition.MODID);

    public static final RegistryObject<Item> PROUDSOUL_SEED = ITEMS.register("proudsoul_seed",
            () -> new ItemNameBlockItem(ModBlocks.PROUDSOUL_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

