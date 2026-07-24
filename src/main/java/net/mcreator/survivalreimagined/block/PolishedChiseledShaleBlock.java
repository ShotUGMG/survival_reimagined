package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class PolishedChiseledShaleBlock extends Block {
	public PolishedChiseledShaleBlock() {
		super(BlockBehaviour.Properties.of().strength(1.5f, 6f).requiresCorrectToolForDrops());
	}
}