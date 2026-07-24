package net.mcreator.survivalreimagined.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.UraniumRodOnRandomClientDisplayTickProcedure;
import net.mcreator.survivalreimagined.procedures.UraniumRodNeighbourBlockChangesProcedure;
import net.mcreator.survivalreimagined.procedures.UraniumRodBlockDestroyedByPlayerProcedure;

import com.google.common.collect.ImmutableMap;

public class UraniumRodBlock extends Block {
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public UraniumRodBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place"))))
				.strength(3f).lightLevel(blockstate -> 10).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return Shapes.or(box(4, 0, 4, 12, 1, 12), box(6, 1, 6, 10, 16, 10), box(5, 1, 5, 11, 16, 11));
			} else if (state.getValue(BLOCKSTATE) == 2) {
				return Shapes.or(box(4, 15, 4, 12, 16, 12), box(6, 0, 6, 10, 15, 10), box(5, 0, 5, 11, 15, 11));
			} else if (state.getValue(BLOCKSTATE) == 3) {
				return Shapes.or(box(6, 0, 6, 10, 16, 10), box(5, 0, 5, 11, 16, 11));
			}
			return Shapes.or(box(4, 15, 4, 12, 16, 12), box(4, 0, 4, 12, 1, 12), box(6, 1, 6, 10, 15, 10), box(5, 1, 5, 11, 15, 11));
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(LIT, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(LIT, true).setValue(BLOCKSTATE, 0);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		UraniumRodNeighbourBlockChangesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
		super.animateTick(blockstate, world, pos, random);
		UraniumRodOnRandomClientDisplayTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		UraniumRodBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}