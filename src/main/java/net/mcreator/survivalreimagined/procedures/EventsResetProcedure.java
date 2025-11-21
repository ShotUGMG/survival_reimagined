package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class EventsResetProcedure {
	public static void execute(LevelAccessor world) {
		SurvivalReimaginedModVariables.WorldVariables.get(world).isSolarEclipse = false;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan = 0;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		if (world.isClientSide()) {
			Minecraft.getInstance().getTextureManager().release(ResourceLocation.parse("minecraft:textures/environment/sun.png"));
		}
		SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = false;
		SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan = 0;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		if (world.isClientSide()) {
			Minecraft.getInstance().getTextureManager().release(ResourceLocation.parse("minecraft:textures/environment/moon_phases.png"));
		}
	}
}
