package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class PigCarcassBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (getEntityGameType(entity) == GameType.SURVIVAL) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip2 ? blockstate.getValue(_getip2) : -1) == 3) {
				for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 4, 8); index0++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), 2, 4); index1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8 ? blockstate.getValue(_getip8) : -1) == 0) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SurvivalReimaginedModBlocks.PIG_CARCASS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else {
				for (int index2 = 0; index2 < (int) Mth.nextDouble(RandomSource.create(), 1, 3); index2++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
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