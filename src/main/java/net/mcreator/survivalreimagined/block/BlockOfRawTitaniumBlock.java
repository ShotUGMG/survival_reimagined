package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BlockOfRawTitaniumBlock extends Block {
	public BlockOfRawTitaniumBlock() {
		super(BlockBehaviour.Properties.of().strength(5f, 6f).requiresCorrectToolForDrops());
	}
}