package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BrittleObsidianBlock extends Block {
	public BrittleObsidianBlock() {
		super(BlockBehaviour.Properties.of().strength(2f, 4f).lightLevel(blockstate -> 5).requiresCorrectToolForDrops());
	}
}