
package net.mcreator.survivalreimagined.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.PigCarcassOnBlockRightClickedProcedure;
import net.mcreator.survivalreimagined.procedures.PigCarcassBlockDestroyedByPlayerProcedure;

public class PigCarcassBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);

	public PigCarcassBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			return Shapes.or(box(-0.64286, 1.35714, -2, 7.35714, 9.35714, 6), box(3.35714, 3.35714, -3, 6.35714, 7.35714, -2), box(1.35714, 0.35714, 4, 9.35714, 10.35714, 20));
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return box(1.35714, 0.35714, 4, 9.35714, 10.35714, 20);
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return box(1.35714, 0.35714, 4, 9.35714, 10.35714, 20);
		}
		return Shapes.or(box(9.35714, 0.35714, 5, 15.35714, 4.35714, 9), box(9.35714, 6.35714, 5, 15.35714, 10.35714, 9), box(9.35714, 0.35714, 17, 15.35714, 4.35714, 21), box(9.35714, 6.35714, 17, 15.35714, 10.35714, 21),
				box(-0.64286, 1.35714, -2, 7.35714, 9.35714, 6), box(3.35714, 3.35714, -3, 6.35714, 7.35714, -2), box(1.35714, 0.35714, 4, 9.35714, 10.35714, 20));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BLOCKSTATE);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		PigCarcassBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
		return retval;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		InteractionResult result = PigCarcassOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate, entity);
		return result;
	}
}
