package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.LeavesDropConditionProcedure;

public class MandarinLeavesBlock extends LeavesBlock {
	public MandarinLeavesBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.AZALEA_LEAVES).strength(0.2f).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false).ignitedByLava().isSuffocating((bs, br, bp) -> false)
				.isViewBlocking((bs, br, bp) -> false));
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		return super.canHarvestBlock(state, world, pos, player) && LeavesDropConditionProcedure.execute(player.level(), pos.getX(), pos.getY(), pos.getZ(), player);
	}
}