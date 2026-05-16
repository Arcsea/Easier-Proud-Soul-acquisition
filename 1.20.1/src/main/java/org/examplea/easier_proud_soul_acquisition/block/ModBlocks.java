package org.examplea.easier_proud_soul_acquisition.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.examplea.easier_proud_soul_acquisition.Easier_proud_soul_acquisition;
import org.examplea.easier_proud_soul_acquisition.block.custom.ProudSoulCropBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Easier_proud_soul_acquisition.MODID);

    public static final RegistryObject<Block> PROUDSOUL_CROP = BLOCKS.register("proudsoul_crop",
            () -> new ProudSoulCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

