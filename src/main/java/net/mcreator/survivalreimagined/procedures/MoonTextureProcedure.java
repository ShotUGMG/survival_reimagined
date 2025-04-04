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
import net.minecraft.core.BlockPos;
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
			execute(event, level, entity);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon == true) {
			if (world.isClientSide()) {
				Minecraft.getInstance().getTextureManager().bindForSetup(ResourceLocation.parse("survival_reborn:textures/environment/blood_moon.png"));
				Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse("minecraft:textures/environment/moon_phases.png"),
						Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse("survival_reborn:textures/environment/blood_moon.png")));
			}
		} else if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 5) {
			if (world.isClientSide()) {
				Minecraft.getInstance().getTextureManager().release(ResourceLocation.parse("minecraft:textures/environment/moon_phases.png"));
			}
		}
	}
}
