
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

import net.mcreator.survivalreimagined.procedures.CowCarcassOnBlockRightClickedProcedure;
import net.mcreator.survivalreimagined.procedures.CowCarcassBlockDestroyedByPlayerProcedure;

public class CowCarcassBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CowCarcassBlock() {
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
				default -> Shapes.or(box(15, 2, 17, 23, 10, 23), box(0, 8, -1, 12, 12, 3), box(0, 0, -1, 12, 4, 3), box(0, 8, 13, 12, 12, 17), box(0, 0, 13, 12, 4, 17), box(12, 0, -1, 22, 12, 17));
				case NORTH -> Shapes.or(box(-7, 2, -7, 1, 10, -1), box(4, 8, 13, 16, 12, 17), box(4, 0, 13, 16, 4, 17), box(4, 8, -1, 16, 12, 3), box(4, 0, -1, 16, 4, 3), box(-6, 0, -1, 4, 12, 17));
				case EAST -> Shapes.or(box(17, 2, -7, 23, 10, 1), box(-1, 8, 4, 3, 12, 16), box(-1, 0, 4, 3, 4, 16), box(13, 8, 4, 17, 12, 16), box(13, 0, 4, 17, 4, 16), box(-1, 0, -6, 17, 12, 4));
				case WEST -> Shapes.or(box(-7, 2, 15, -1, 10, 23), box(13, 8, 0, 17, 12, 12), box(13, 0, 0, 17, 4, 12), box(-1, 8, 0, 3, 12, 12), box(-1, 0, 0, 3, 4, 12), box(-1, 0, 12, 17, 12, 22));
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(15, 2, 17, 23, 10, 23), box(12, 0, -1, 22, 12, 17));
				case NORTH -> Shapes.or(box(-7, 2, -7, 1, 10, -1), box(-6, 0, -1, 4, 12, 17));
				case EAST -> Shapes.or(box(17, 2, -7, 23, 10, 1), box(-1, 0, -6, 17, 12, 4));
				case WEST -> Shapes.or(box(-7, 2, 15, -1, 10, 23), box(-1, 0, 12, 17, 12, 22));
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> box(12, 0, -1, 22, 12, 17);
				case NORTH -> box(-6, 0, -1, 4, 12, 17);
				case EAST -> box(-1, 0, -6, 17, 12, 4);
				case WEST -> box(-1, 0, 12, 17, 12, 22);
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> box(12, 0, -1, 22, 12, 17);
				case NORTH -> box(-6, 0, -1, 4, 12, 17);
				case EAST -> box(-1, 0, -6, 17, 12, 4);
				case WEST -> box(-1, 0, 12, 17, 12, 22);
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(15, 2, 17, 23, 10, 23), box(21, 10, 20, 24, 11, 21), box(21, 1, 20, 24, 2, 21), box(0, 8, -1, 12, 12, 3), box(0, 0, -1, 12, 4, 3), box(0, 8, 13, 12, 12, 17), box(0, 0, 13, 12, 4, 17), box(12, 0, -1, 22, 12, 17));
			case NORTH -> Shapes.or(box(-7, 2, -7, 1, 10, -1), box(-8, 10, -5, -5, 11, -4), box(-8, 1, -5, -5, 2, -4), box(4, 8, 13, 16, 12, 17), box(4, 0, 13, 16, 4, 17), box(4, 8, -1, 16, 12, 3), box(4, 0, -1, 16, 4, 3), box(-6, 0, -1, 4, 12, 17));
			case EAST -> Shapes.or(box(17, 2, -7, 23, 10, 1), box(20, 10, -8, 21, 11, -5), box(20, 1, -8, 21, 2, -5), box(-1, 8, 4, 3, 12, 16), box(-1, 0, 4, 3, 4, 16), box(13, 8, 4, 17, 12, 16), box(13, 0, 4, 17, 4, 16), box(-1, 0, -6, 17, 12, 4));
			case WEST ->
				Shapes.or(box(-7, 2, 15, -1, 10, 23), box(-5, 10, 21, -4, 11, 24), box(-5, 1, 21, -4, 2, 24), box(13, 8, 0, 17, 12, 12), box(13, 0, 0, 17, 4, 12), box(-1, 8, 0, 3, 12, 12), box(-1, 0, 0, 3, 4, 12), box(-1, 0, 12, 17, 12, 22));
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
		CowCarcassBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
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
		InteractionResult result = CowCarcassOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate, entity);
		return result;
	}
}
