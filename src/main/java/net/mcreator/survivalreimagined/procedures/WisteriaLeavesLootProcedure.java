package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WisteriaLeavesLootProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WISTERIA_LEAVES.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.FLOWING_WISTERIA_LEAVES.get()) {
				if (Math.random() < 0.3) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModBlocks.WISTERIA_SAPLING.get()));
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