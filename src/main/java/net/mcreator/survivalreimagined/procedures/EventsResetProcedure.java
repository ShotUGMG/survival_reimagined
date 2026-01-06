package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class EventsResetProcedure {
	public static void execute(LevelAccessor world) {
		SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = false;
		SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoonChanceRan = 0;
		SurvivalReimaginedModVariables.MapVariables.get(world).markSyncDirty();
		if (world.isClientSide()) {
			Minecraft.getInstance().getTextureManager().release(ResourceLocation.parse("minecraft:textures/environment/moon_phases.png"));
		}
	}
}