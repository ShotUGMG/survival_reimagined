package net.mcreator.survivalreimagined.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class WildSpeltBlock extends Block {
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public WildSpeltBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.CROP).instabreak().noCollission().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(AGE) == 1) {
				return box(0, 0, 0, 16, 4, 16);
			} else if (state.getValue(AGE) == 2) {
				return box(0, 0, 0, 16, 6, 16);
			} else if (state.getValue(AGE) == 3) {
				return box(0, 0, 0, 16, 10, 16);
			} else if (state.getValue(AGE) == 4) {
				return box(0, 0, 0, 16, 12, 16);
			} else if (state.getValue(AGE) == 5) {
				return box(0, 0, 0, 16, 14, 16);
			} else if (state.getValue(AGE) == 6) {
				return box(0, 0, 0, 16, 15.99, 16);
			}
			return box(0, 0, 0, 16, 2, 16);
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
		builder.add(AGE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(AGE, 0);
	}
}