package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class PolishedShaleBlock extends Block {
	public PolishedShaleBlock() {
		super(BlockBehaviour.Properties.of().strength(1.5f, 6f).requiresCorrectToolForDrops());
	}
}