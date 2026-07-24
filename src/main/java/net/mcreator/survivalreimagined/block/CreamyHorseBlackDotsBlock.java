package net.mcreator.survivalreimagined.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.block.entity.CreamyHorseBlackDotsBlockEntity;

public class CreamyHorseBlackDotsBlock extends Block implements EntityBlock {
	private static final VoxelShape SHAPE = Shapes.or(box(3, 0, -3, 13, 10, 19), box(13, 0, -3, 24, 4, 1), box(13, 6, -3, 24, 10, 1), box(13, 0, 15, 24, 4, 19), box(13, 6, 15, 24, 10, 19), box(3, 2.5, 19, 19, 6.5, 24), box(-3, 3, -2.95, 9, 7, 4.05),
			box(-8, 2, -2.95, -3, 8, 4.05), box(-7, 3, -8, -3, 7, -3), box(-11, 2, 2.5, -8, 4, 3.5), box(-11, 6, 2.5, -8, 8, 3.5), box(-8, 4, 4, 8, 6, 6), box(3, 0, -3, 13, 10, 19), box(13, 0, -3, 24, 4, 1), box(13, 6, -3, 24, 10, 1),
			box(13, 0, 15, 24, 4, 19), box(13, 6, 15, 24, 10, 19), box(-3, 3, -2.95, 9, 7, 4.05));

	public CreamyHorseBlackDotsBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
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
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CreamyHorseBlackDotsBlockEntity(pos, state);
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
			if (blockEntity instanceof CreamyHorseBlackDotsBlockEntity be) {
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
		if (tileentity instanceof CreamyHorseBlackDotsBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}