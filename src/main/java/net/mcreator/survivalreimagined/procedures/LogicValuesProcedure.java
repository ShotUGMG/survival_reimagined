package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class LogicValuesProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Blood Moon Value: " + SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon)), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Solar Eclipse Value: " + SurvivalReimaginedModVariables.WorldVariables.get(world).isSolarEclipse)), false);
	}
}
