package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoodSpoilProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.SPOIL_FOOD.get() == true) {
			if (entity instanceof Player) {
				{
					SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
					_vars.SpoilTimer = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).SpoilTimer + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).SpoilTimer == 1600) {
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.SpoilTimer = 0;
						_vars.syncPlayerVariables(entity);
					}
					MeatSpoiledProcedure.execute(world, entity);
				}
			}
		}
	}
}
