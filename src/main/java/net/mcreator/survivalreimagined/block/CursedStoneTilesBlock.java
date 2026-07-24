package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CursedStoneTilesBlock extends Block {
	public CursedStoneTilesBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}