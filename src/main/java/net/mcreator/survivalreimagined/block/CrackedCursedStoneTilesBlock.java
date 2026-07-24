package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CrackedCursedStoneTilesBlock extends Block {
	public CrackedCursedStoneTilesBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}