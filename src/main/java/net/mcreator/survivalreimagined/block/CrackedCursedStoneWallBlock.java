package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CrackedCursedStoneWallBlock extends Block {
	public CrackedCursedStoneWallBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}