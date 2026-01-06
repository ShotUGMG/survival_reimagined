package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class PolishedShaleStairsBlock extends StairBlock {
	public PolishedShaleStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().strength(1.5f, 6f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 6f;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}