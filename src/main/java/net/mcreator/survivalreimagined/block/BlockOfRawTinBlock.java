package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BlockOfRawTinBlock extends Block {
	public BlockOfRawTinBlock() {
		super(BlockBehaviour.Properties.of().strength(5f, 4f).requiresCorrectToolForDrops());
	}
}