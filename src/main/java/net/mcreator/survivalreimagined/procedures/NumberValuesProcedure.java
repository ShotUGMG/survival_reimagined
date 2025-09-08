package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class NumberValuesProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Blood Moon Chance Ran: " + SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan)), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Solar Eclipse Chance Ran: " + SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan)), false);
	}
}
