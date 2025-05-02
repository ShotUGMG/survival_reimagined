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
public class HeartTextureProcedure {
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
		if (!Minecraft.getInstance().isPaused()) {
			if (SurvivalReimaginedModVariables.MapVariables.get(world).sculk_hearts == true) {
				if (world.isClientSide()) {
					Minecraft.getInstance().getTextureManager().bindForSetup(ResourceLocation.parse("minecraft:textures/atlas/gui_sculk.png"));
					Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse("minecraft:textures/atlas/gui.png"),
							Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse("minecraft:textures/atlas/gui_sculk.png")));
				}
			}
			if (SurvivalReimaginedModVariables.MapVariables.get(world).sculk_hearts == false) {
				if (world.isClientSide()) {
					Minecraft.getInstance().getTextureManager().bindForSetup(ResourceLocation.parse("minecraft:textures/atlas/gui_new.png"));
					Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse("minecraft:textures/atlas/gui.png"),
							Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse("minecraft:textures/atlas/gui_new.png")));
				}
			}
		}
	}
}
