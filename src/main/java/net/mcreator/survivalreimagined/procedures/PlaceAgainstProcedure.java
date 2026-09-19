package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class PlaceAgainstProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		if (direction == Direction.NORTH) {
			world.setBlock(BlockPos.containing(x, y, z - 1), (blockStateWithEnum(SurvivalReimaginedModBlocks.CRUDE_WALL_TORCH.get().defaultBlockState(), "facing", "north")), 3);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
			});
		} else if (direction == Direction.SOUTH) {
			world.setBlock(BlockPos.containing(x, y, z + 1), (blockStateWithEnum(SurvivalReimaginedModBlocks.CRUDE_WALL_TORCH.get().defaultBlockState(), "facing", "south")), 3);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
			});
		} else if (direction == Direction.WEST) {
			world.setBlock(BlockPos.containing(x - 1, y, z), (blockStateWithEnum(SurvivalReimaginedModBlocks.CRUDE_WALL_TORCH.get().defaultBlockState(), "facing", "west")), 3);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
			});
		} else if (direction == Direction.EAST) {
			world.setBlock(BlockPos.containing(x + 1, y, z), (blockStateWithEnum(SurvivalReimaginedModBlocks.CRUDE_WALL_TORCH.get().defaultBlockState(), "facing", "east")), 3);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
			});
		} else if (direction == Direction.UP) {
			world.setBlock(BlockPos.containing(x, y + 1, z), SurvivalReimaginedModBlocks.CRUDE_TORCH.get().defaultBlockState(), 3);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
			});
		}
		if ((getEntityGameType(entity) == GameType.SURVIVAL) == true) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.CRUDE_TORCH_ITEM.get()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.CRUDE_TORCH_ITEM.get()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			}
		}
	}

	private static BlockState blockStateWithEnum(BlockState blockState, String property, String newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof EnumProperty ep && ep.getValue(newValue).isPresent() ? blockState.setValue(ep, (Enum) ep.getValue(newValue).get()) : blockState;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}