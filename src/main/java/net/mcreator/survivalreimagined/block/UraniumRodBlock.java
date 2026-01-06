package net.mcreator.survivalreimagined.block;

import org.checkerframework.checker.units.qual.s;

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

public class UraniumRodBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	private static final VoxelShape SHAPE_1 = Shapes.or(box(4, 0, 4, 12, 1, 12), box(6, 1, 6, 10, 16, 10), box(5, 1, 5, 11, 16, 11));
	private static final VoxelShape SHAPE_2 = Shapes.or(box(4, 15, 4, 12, 16, 12), box(6, 0, 6, 10, 15, 10), box(5, 0, 5, 11, 15, 11));
	private static final VoxelShape SHAPE_3 = Shapes.or(box(6, 0, 6, 10, 16, 10), box(5, 0, 5, 11, 16, 11));
	private static final VoxelShape SHAPE = Shapes.or(box(4, 15, 4, 12, 16, 12), box(4, 0, 4, 12, 1, 12), box(6, 1, 6, 10, 15, 10), box(5, 1, 5, 11, 15, 11));

	public UraniumRodBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place"))))
				.strength(3f).lightLevel(s -> (new Object() {
					public int getLightLevel() {
						if (s.getValue(BLOCKSTATE) == 1)
							return 10;
						if (s.getValue(BLOCKSTATE) == 2)
							return 10;
						if (s.getValue(BLOCKSTATE) == 3)
							return 10;
						return 10;
					}
				}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true));
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
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
			return (SHAPE_1);
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return (SHAPE_2);
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return (SHAPE_3);
		}
		return (SHAPE);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(LIT, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(LIT, true);
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