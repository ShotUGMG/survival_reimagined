package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HeartsResetProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (world.isClientSide()) {
				Minecraft.getInstance().getTextureManager().bindForSetup(ResourceLocation.parse("minecraft:textures/atlas/gui_new.png"));
				Minecraft.getInstance().getTextureManager().register(ResourceLocation.parse("minecraft:textures/atlas/gui.png"), Minecraft.getInstance().getTextureManager().getTexture(ResourceLocation.parse("minecraft:textures/atlas/gui_new.png")));
			}
		}
	}
}
