package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class PyrolusiteBlockBlock extends Block {
	public PyrolusiteBlockBlock() {
		super(BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops());
	}
}