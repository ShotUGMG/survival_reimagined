package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber(value = Dist.CLIENT)
public class MoonTextureProcedure {
	@SubscribeEvent
	public static void updateWorldTick(ClientTickEvent.Pre event) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 pos = entity.getPosition(minecraft.getTimer().getGameTimeDeltaPartialTick(false));
			execute(event, level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon == true) {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).TextureLoaded == false) {
				if (world.isClientSide()) {
					Minecraft.getInstance().getTextureManager().bindForSetup(ResourceLocation.parse("survival_reimagined:textures/environment/blood_moon.png"));
					Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse("minecraft:textures/environment/moon_phases.png"),
							Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse("survival_reimagined:textures/environment/blood_moon.png")));
				}
				SurvivalReimaginedModVariables.WorldVariables.get(world).TextureLoaded = true;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
			}
		} else if (SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon == false) {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).TextureLoaded == true) {
				if (world.isClientSide()) {
					Minecraft.getInstance().getTextureManager().release(ResourceLocation.parse("minecraft:textures/environment/moon_phases.png"));
				}
				SurvivalReimaginedModVariables.WorldVariables.get(world).TextureLoaded = false;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
			}
		}
	}
}
