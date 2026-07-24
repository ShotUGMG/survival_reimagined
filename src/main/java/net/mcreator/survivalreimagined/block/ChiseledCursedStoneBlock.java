package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.ChiseledCursedStoneOnTickUpdateProcedure;

public class ChiseledCursedStoneBlock extends Block {
	public static final IntegerProperty STATE = IntegerProperty.create("state", 0, 3);

	public ChiseledCursedStoneBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
		this.registerDefaultState(this.stateDefinition.any().setValue(STATE, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(STATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(STATE, 0);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		ChiseledCursedStoneOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}