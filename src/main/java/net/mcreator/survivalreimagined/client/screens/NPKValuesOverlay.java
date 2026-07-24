package net.mcreator.survivalreimagined.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.procedures.NPKValuesProceduresProcedure;
import net.mcreator.survivalreimagined.procedures.NPKDisplayProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class NPKValuesOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (NPKDisplayProcedure.execute(world, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						NPKValuesProceduresProcedure.execute(world, entity), w / 2 + 56, h / 2 + 13, -1, true);
		}
	}
}