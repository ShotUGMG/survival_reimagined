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

import net.mcreator.survivalreimagined.block.entity.SheepCarcassBlockEntity;

import com.google.common.collect.ImmutableMap;

public class SheepCarcassBlock extends Block implements EntityBlock {
	public static final IntegerProperty CARCASS_STATE = IntegerProperty.create("carcass_state", 0, 4);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public SheepCarcassBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(CARCASS_STATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(CARCASS_STATE) == 1) {
				return Shapes.or(box(5.66667, 5.66667, 0, 17.66667, 9.66667, 4), box(5.66667, -0.33333, 0, 17.66667, 3.66667, 4), box(5.66667, 5.66667, 12, 17.66667, 9.66667, 16), box(5.66667, -0.33333, 12, 17.66667, 3.66667, 16),
						box(-4.33333, 1.66667, -7, 1.66667, 7.66667, 1), box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667));
			} else if (state.getValue(CARCASS_STATE) == 2) {
				return Shapes.or(box(-4.33333, 1.66667, -7, 1.66667, 7.66667, 1), box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667));
			} else if (state.getValue(CARCASS_STATE) == 3) {
				return box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667);
			} else if (state.getValue(CARCASS_STATE) == 4) {
				return box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667);
			}
			return Shapes.or(box(5.66667, 5.66667, 0, 17.66667, 9.66667, 4), box(5.66667, -0.33333, 0, 17.66667, 3.66667, 4), box(5.66667, 5.66667, 12, 17.66667, 9.66667, 16), box(5.66667, -0.33333, 12, 17.66667, 3.66667, 16),
					box(-4.33333, 1.66667, -7, 1.66667, 7.66667, 1), box(1.16667, 0.33334, -0.83333, 7.16667, 8.33334, 15.16667));
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
		return new SheepCarcassBlockEntity(pos, state);
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
			if (blockEntity instanceof SheepCarcassBlockEntity be) {
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
		if (tileentity instanceof SheepCarcassBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}