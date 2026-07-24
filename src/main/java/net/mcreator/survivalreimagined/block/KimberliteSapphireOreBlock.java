package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class KimberliteSapphireOreBlock extends Block {
	public KimberliteSapphireOreBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 7f).requiresCorrectToolForDrops());
	}
}