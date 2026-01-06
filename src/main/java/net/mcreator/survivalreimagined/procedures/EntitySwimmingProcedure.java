package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntitySwimmingProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.HUNGER_VANILLA.get() == false) {
			if (getEntityGameType(entity) == GameType.SURVIVAL) {
				if (entity.isSwimming() || !((entity.getVehicle()) instanceof Boat) && (world.getBlockState(BlockPos.containing(x, y - 0.1, z))).getBlock() == Blocks.AIR) {
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.HungerSwimming = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).HungerSwimming + 1;
						_vars.markSyncDirty();
					}
					if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).HungerSwimming == 75) {
						if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) > 0) {
							if (entity instanceof Player _player)
								_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 1));
						} else {
							if (entity instanceof Player _player)
								_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1);
						}
						{
							SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
							_vars.HungerSwimming = 0;
							_vars.markSyncDirty();
						}
					}
				} else {
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.HungerSwimming = 0;
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