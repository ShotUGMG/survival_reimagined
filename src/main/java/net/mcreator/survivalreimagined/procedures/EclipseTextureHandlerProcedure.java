package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EclipseTextureHandlerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.isClientSide()) {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan == 1) {
				if (world.isClientSide()) {
					Minecraft.getInstance().getTextureManager().bindForSetup(ResourceLocation.parse("survival_reimagined:textures/environment/solar_eclipse_sun.png"));
					Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse("minecraft:textures/environment/sun.png"),
							Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse("survival_reimagined:textures/environment/solar_eclipse_sun.png")));
				}
			} else if (SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan == 0) {
				if (world.isClientSide()) {
					Minecraft.getInstance().getTextureManager().release(ResourceLocation.parse("minecraft:textures/environment/sun.png"));
				}
			}
		}
	}
}
