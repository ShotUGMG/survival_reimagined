package net.mcreator.survivalreimagined.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.PalmCrownOnTickUpdateProcedure;

public class PalmCrownBlock extends Block {
	private static final VoxelShape SHAPE = box(4, 0, 4, 12, 16, 12);

	public PalmCrownBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f).noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false).ignitedByLava());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		PalmCrownOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}