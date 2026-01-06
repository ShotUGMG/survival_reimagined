package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntitySprintingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.HUNGER_VANILLA.get() == false) {
			if (getEntityGameType(entity) == GameType.SURVIVAL) {
				if (entity.isSprinting()) {
					if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).HungerSprinting == 95) {
						if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) > 0) {
							if (entity instanceof Player _player)
								_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 1));
						} else if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 0) {
							if (entity instanceof Player _player)
								_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1);
						}
						{
							SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
							_vars.HungerSprinting = 0;
							_vars.markSyncDirty();
						}
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.HungerSprinting = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).HungerSprinting + 1;
						_vars.markSyncDirty();
					}
				} else {
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.HungerSprinting = 0;
						_vars.markSyncDirty();
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