package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class NumberValuesProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList()
					.broadcastSystemMessage(Component.literal(
							("Blood Moon Chance Ran: " + Math.round(SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoonChanceRan) + "Blood Moon Number" + Math.round(SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoon))),
							false);
		}
	}
}