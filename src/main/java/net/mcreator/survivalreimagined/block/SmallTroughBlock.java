package net.mcreator.survivalreimagined.block;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.procedures.SmallTroughSpecialInformationProcedure;
import net.mcreator.survivalreimagined.procedures.SmallTroughOnTickUpdateProcedure;
import net.mcreator.survivalreimagined.procedures.SmallTroughOnBlockRightclickedProcedure;
import net.mcreator.survivalreimagined.block.entity.SmallTroughBlockEntity;

import java.util.List;

import com.google.common.collect.ImmutableMap;

public class SmallTroughBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty PORTIONS = IntegerProperty.create("portions", 0, 4);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public SmallTroughBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f, 3f).jumpFactor(0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(PORTIONS, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(PORTIONS) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 5.5, 11.5, 2.5, 6.5), box(4.5, 0.5, 9.5, 11.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5));
					case EAST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(9.5, 0.5, 4.5, 10.5, 2.5, 11.5), box(5.5, 0.5, 4.5, 6.5, 3.5, 11.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5));
					case WEST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(5.5, 0.5, 4.5, 6.5, 2.5, 11.5), box(9.5, 0.5, 4.5, 10.5, 3.5, 11.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5));
					default -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 9.5, 11.5, 2.5, 10.5), box(4.5, 0.5, 5.5, 11.5, 3.5, 6.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5));
				};
			} else if (state.getValue(PORTIONS) == 2) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 5.5, 11.5, 2.5, 6.5), box(4.5, 0.5, 9.5, 11.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5));
					case EAST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(9.5, 0.5, 4.5, 10.5, 2.5, 11.5), box(5.5, 0.5, 4.5, 6.5, 3.5, 11.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5));
					case WEST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(5.5, 0.5, 4.5, 6.5, 2.5, 11.5), box(9.5, 0.5, 4.5, 10.5, 3.5, 11.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5));
					default -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 9.5, 11.5, 2.5, 10.5), box(4.5, 0.5, 5.5, 11.5, 3.5, 6.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5));
				};
			} else if (state.getValue(PORTIONS) == 3) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 5.5, 11.5, 2.5, 6.5), box(4.5, 0.5, 9.5, 11.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5));
					case EAST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(9.5, 0.5, 4.5, 10.5, 2.5, 11.5), box(5.5, 0.5, 4.5, 6.5, 3.5, 11.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5));
					case WEST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(5.5, 0.5, 4.5, 6.5, 2.5, 11.5), box(9.5, 0.5, 4.5, 10.5, 3.5, 11.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5));
					default -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 9.5, 11.5, 2.5, 10.5), box(4.5, 0.5, 5.5, 11.5, 3.5, 6.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5));
				};
			} else if (state.getValue(PORTIONS) == 4) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 5.5, 11.5, 2.5, 6.5), box(4.5, 0.5, 9.5, 11.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5), box(4.5, 2, 7, 11.5, 3, 10));
					case EAST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(9.5, 0.5, 4.5, 10.5, 2.5, 11.5), box(5.5, 0.5, 4.5, 6.5, 3.5, 11.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5), box(6, 2, 4.5, 9, 3, 11.5));
					case WEST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(5.5, 0.5, 4.5, 6.5, 2.5, 11.5), box(9.5, 0.5, 4.5, 10.5, 3.5, 11.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5), box(7, 2, 4.5, 10, 3, 11.5));
					default -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 9.5, 11.5, 2.5, 10.5), box(4.5, 0.5, 5.5, 11.5, 3.5, 6.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5), box(4.5, 2, 6, 11.5, 3, 9));
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 5.5, 11.5, 2.5, 6.5), box(4.5, 0.5, 9.5, 11.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5));
				case EAST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(9.5, 0.5, 4.5, 10.5, 2.5, 11.5), box(5.5, 0.5, 4.5, 6.5, 3.5, 11.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5));
				case WEST -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(5.5, 0.5, 4.5, 6.5, 2.5, 11.5), box(9.5, 0.5, 4.5, 10.5, 3.5, 11.5), box(5.5, 0.5, 3.5, 10.5, 3.5, 4.5), box(5.5, 0.5, 11.5, 10.5, 3.5, 12.5));
				default -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(4.5, 0.5, 9.5, 11.5, 2.5, 10.5), box(4.5, 0.5, 5.5, 11.5, 3.5, 6.5), box(3.5, 0.5, 5.5, 4.5, 3.5, 10.5), box(11.5, 0.5, 5.5, 12.5, 3.5, 10.5));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = SmallTroughSpecialInformationProcedure.execute();
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, PORTIONS);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(PORTIONS, 0);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.WALKABLE;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		SmallTroughOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 1);
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
		InteractionResult result = SmallTroughOnBlockRightclickedProcedure.execute(world, x, y, z, entity);
		return result;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SmallTroughBlockEntity(pos, state);
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
			if (blockEntity instanceof SmallTroughBlockEntity be) {
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
		if (tileentity instanceof SmallTroughBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}