package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class IlmeniteBlockBlock extends Block {
	public IlmeniteBlockBlock() {
		super(BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops());
	}
}