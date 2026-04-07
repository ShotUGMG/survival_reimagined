package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FruitTreeClockProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		SurvivalReimaginedModVariables.WorldVariables.get(world).FruitTree = SurvivalReimaginedModVariables.WorldVariables.get(world).FruitTree + 1;
		SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).FruitTree == 300) {
			SurvivalReimaginedModVariables.WorldVariables.get(world).FruitTree = 0;
			SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
		}
	}
}