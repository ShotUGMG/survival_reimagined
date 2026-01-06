package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class LogicValuesProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Blood Moon Value: " + SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon)), false);
		}
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("isDay Value: " + SurvivalReimaginedModVariables.MapVariables.get(world).isDay)), false);
		}
	}
}