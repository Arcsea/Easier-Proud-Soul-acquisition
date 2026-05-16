package com.arcsea.easierproudsoulacquisition.item;

import com.arcsea.easierproudsoulacquisition.EasierProudSoulacquisition;
import com.arcsea.easierproudsoulacquisition.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EasierProudSoulacquisition.MODID);

    public static final DeferredItem<BlockItem> PROUDSOUL_SEED = ITEMS.registerSimpleBlockItem("proudsoul_seed", ModBlocks.PROUDSOUL_CROP);
}
