package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoodSpoilProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		SurvivalReimaginedModVariables.WorldVariables.get(world).SpoilTimer = SurvivalReimaginedModVariables.WorldVariables.get(world).SpoilTimer + 1;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).SpoilTimer == 1600) {
			SurvivalReimaginedModVariables.WorldVariables.get(world).SpoilTimer = 0;
			SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
