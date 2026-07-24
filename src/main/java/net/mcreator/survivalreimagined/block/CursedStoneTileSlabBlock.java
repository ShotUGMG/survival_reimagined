package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class CursedStoneTileSlabBlock extends SlabBlock {
	public CursedStoneTileSlabBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}