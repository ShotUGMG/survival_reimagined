package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class CursedStoneWallSlabBlock extends SlabBlock {
	public CursedStoneWallSlabBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}