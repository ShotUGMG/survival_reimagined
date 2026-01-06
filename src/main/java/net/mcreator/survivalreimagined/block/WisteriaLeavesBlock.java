package net.mcreator.survivalreimagined.block;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.WisteriaLeavesOnRandomClientDisplayTickProcedure;

public class WisteriaLeavesBlock extends LeavesBlock {
	public WisteriaLeavesBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.CHERRY_LEAVES).strength(0.2f).noOcclusion().isSuffocating((bs, br, bp) -> false).isViewBlocking((bs, br, bp) -> false));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
		super.animateTick(blockstate, world, pos, random);
		WisteriaLeavesOnRandomClientDisplayTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}