package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class KimberliteLapisOreBlock extends Block {
	public KimberliteLapisOreBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 7f).requiresCorrectToolForDrops());
	}
}