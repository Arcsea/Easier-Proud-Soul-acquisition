package com.arcsea.easierproudsoulacquisition.block;

import com.arcsea.easierproudsoulacquisition.EasierProudSoulacquisition;
import com.arcsea.easierproudsoulacquisition.block.custom.ProudSoulCropBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EasierProudSoulacquisition.MODID);

    public static final DeferredBlock<Block> PROUDSOUL_CROP = BLOCKS.register("proudsoul_crop",
            () -> new ProudSoulCropBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .noOcclusion()));
}
