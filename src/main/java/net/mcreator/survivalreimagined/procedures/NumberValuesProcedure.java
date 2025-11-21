package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class NumberValuesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Blood Moon Chance Ran: " + SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan)), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Meat Spoil Timer" + entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).SpoilTimer)), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("EmeraldInfuse Timer: " + Math.round(entity.getPersistentData().getDouble("HeroVillageTick")))), false);
	}
}
