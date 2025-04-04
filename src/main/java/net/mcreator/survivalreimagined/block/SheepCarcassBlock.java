
package net.mcreator.survivalreimagined.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.SheepCarcassOnBlockRightClickedProcedure;
import net.mcreator.survivalreimagined.procedures.SheepCarcassBlockDestroyedByPlayerProcedure;

public class SheepCarcassBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SheepCarcassBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
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
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(-1.66667, 5.66667, 12, 10.33333, 9.66667, 16), box(-1.66667, -0.33333, 12, 10.33333, 3.66667, 16), box(-1.66667, 5.66667, 0, 10.33333, 9.66667, 4), box(-1.66667, -0.33333, 0, 10.33333, 3.66667, 4),
						box(14.33333, 1.66667, 15, 20.33333, 7.66667, 23), box(8.83333, 0.33334, 0.83333, 14.83333, 8.33334, 16.83333));
				case NORTH -> Shapes.or(box(5.66667, 5.66667, 0, 17.66667, 9.66667, 4), box(5.66667, -0.33333, 0, 17.66667, 3.66667, 4), box(5.66667, 5.66667, 12, 17.66667, 9.66667, 16), box(5.66667, -0.33333, 12, 17.66667, 3.66667, 16),
						box(-4.33333, 1.66667, -7, 1.66667, 7.66667, 1), box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667));
				case EAST -> Shapes.or(box(12, 5.66667, 5.66667, 16, 9.66667, 17.66667), box(12, -0.33333, 5.66667, 16, 3.66667, 17.66667), box(0, 5.66667, 5.66667, 4, 9.66667, 17.66667), box(0, -0.33333, 5.66667, 4, 3.66667, 17.66667),
						box(15, 1.66667, -4.33333, 23, 7.66667, 1.66667), box(0.83333, 0.33334, 1.16667, 16.83333, 8.33334, 7.16667));
				case WEST -> Shapes.or(box(0, 5.66667, -1.66667, 4, 9.66667, 10.33333), box(0, -0.33333, -1.66667, 4, 3.66667, 10.33333), box(12, 5.66667, -1.66667, 16, 9.66667, 10.33333), box(12, -0.33333, -1.66667, 16, 3.66667, 10.33333),
						box(-7, 1.66667, 14.33333, 1, 7.66667, 20.33333), box(-0.83333, 0.33334, 8.83333, 15.16667, 8.33334, 14.83333));
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(14.33333, 1.66667, 15, 20.33333, 7.66667, 23), box(8.83333, 0.33334, 0.83333, 14.83333, 8.33334, 16.83333));
				case NORTH -> Shapes.or(box(-4.33333, 1.66667, -7, 1.66667, 7.66667, 1), box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667));
				case EAST -> Shapes.or(box(15, 1.66667, -4.33333, 23, 7.66667, 1.66667), box(0.83333, 0.33334, 1.16667, 16.83333, 8.33334, 7.16667));
				case WEST -> Shapes.or(box(-7, 1.66667, 14.33333, 1, 7.66667, 20.33333), box(-0.83333, 0.33334, 8.83333, 15.16667, 8.33334, 14.83333));
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> box(8.83333, 0.33334, 0.83333, 14.83333, 8.33334, 16.83333);
				case NORTH -> box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667);
				case EAST -> box(0.83333, 0.33334, 1.16667, 16.83333, 8.33334, 7.16667);
				case WEST -> box(-0.83333, 0.33334, 8.83333, 15.16667, 8.33334, 14.83333);
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> box(8.83333, 0.33334, 0.83333, 14.83333, 8.33334, 16.83333);
				case NORTH -> box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667);
				case EAST -> box(0.83333, 0.33334, 1.16667, 16.83333, 8.33334, 7.16667);
				case WEST -> box(-0.83333, 0.33334, 8.83333, 15.16667, 8.33334, 14.83333);
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(-1.66667, 5.66667, 12, 10.33333, 9.66667, 16), box(-1.66667, -0.33333, 12, 10.33333, 3.66667, 16), box(-1.66667, 5.66667, 0, 10.33333, 9.66667, 4), box(-1.66667, -0.33333, 0, 10.33333, 3.66667, 4),
					box(14.33333, 1.66667, 15, 20.33333, 7.66667, 23), box(8.83333, 0.33334, 0.83333, 14.83333, 8.33334, 16.83333));
			case NORTH -> Shapes.or(box(5.66667, 5.66667, 0, 17.66667, 9.66667, 4), box(5.66667, -0.33333, 0, 17.66667, 3.66667, 4), box(5.66667, 5.66667, 12, 17.66667, 9.66667, 16), box(5.66667, -0.33333, 12, 17.66667, 3.66667, 16),
					box(-4.33333, 1.66667, -7, 1.66667, 7.66667, 1), box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667));
			case EAST -> Shapes.or(box(12, 5.66667, 5.66667, 16, 9.66667, 17.66667), box(12, -0.33333, 5.66667, 16, 3.66667, 17.66667), box(0, 5.66667, 5.66667, 4, 9.66667, 17.66667), box(0, -0.33333, 5.66667, 4, 3.66667, 17.66667),
					box(15, 1.66667, -4.33333, 23, 7.66667, 1.66667), box(0.83333, 0.33334, 1.16667, 16.83333, 8.33334, 7.16667));
			case WEST -> Shapes.or(box(0, 5.66667, -1.66667, 4, 9.66667, 10.33333), box(0, -0.33333, -1.66667, 4, 3.66667, 10.33333), box(12, 5.66667, -1.66667, 16, 9.66667, 10.33333), box(12, -0.33333, -1.66667, 16, 3.66667, 10.33333),
					box(-7, 1.66667, 14.33333, 1, 7.66667, 20.33333), box(-0.83333, 0.33334, 8.83333, 15.16667, 8.33334, 14.83333));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		SheepCarcassBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
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
		InteractionResult result = SheepCarcassOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate, entity);
		return result;
	}
}
