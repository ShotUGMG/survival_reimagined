package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class RawAzuriteBlockBlock extends Block {
	public RawAzuriteBlockBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 5f).requiresCorrectToolForDrops());
	}
}