package net.mcreator.survivalreimagined.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.block.entity.GoatCarcassBlockEntity;

import com.google.common.collect.ImmutableMap;

public class GoatCarcassBlock extends Block implements EntityBlock {
	public static final IntegerProperty CARCASS_STATE = IntegerProperty.create("carcass_state", 0, 4);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public GoatCarcassBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(CARCASS_STATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(CARCASS_STATE) == 1) {
				return Shapes.or(box(2, 0, -1, 13, 9, 15), box(13, 1, 10, 19, 4, 13), box(13, 5, 10, 19, 8, 13), box(9, 5, 0, 19, 8, 3), box(-9, 5, -2, -2, 7, 0), box(-9, 2, -2, -2, 4, 0), box(9, 1, 0, 19, 4, 3), box(-2, 2, -10, 5, 7, 0));
			} else if (state.getValue(CARCASS_STATE) == 2) {
				return Shapes.or(box(2, 0, -1, 13, 9, 15), box(-9, 5, -2, -2, 7, 0), box(-9, 2, -2, -2, 4, 0), box(-2, 2, -10, 5, 7, 0));
			} else if (state.getValue(CARCASS_STATE) == 3) {
				return box(2, 0, -1, 13, 9, 15);
			} else if (state.getValue(CARCASS_STATE) == 4) {
				return box(2, 0, -1, 13, 9, 15);
			}
			return Shapes.or(box(2, 0, -1, 13, 9, 15), box(1, -1, -2, 15, 10, 9), box(13, 1, 10, 19, 4, 13), box(13, 5, 10, 19, 8, 13), box(9, 5, 0, 19, 8, 3), box(-1, -1, -3, 1, 2, -2), box(-1, 7, -3, 1, 10, -2), box(-9, 5, -2, -2, 7, 0),
					box(-9, 2, -2, -2, 4, 0), box(9, 1, 0, 19, 4, 3), box(-2, 2, -10, 5, 7, 0));
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(CARCASS_STATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(CARCASS_STATE, 0);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new GoatCarcassBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof GoatCarcassBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof GoatCarcassBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}