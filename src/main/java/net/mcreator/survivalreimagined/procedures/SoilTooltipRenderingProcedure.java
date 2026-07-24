package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class SoilTooltipRenderingProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == Blocks.DIRT.asItem()) {
			tooltip.add(Component.literal("\u00A77 Low Fertility"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77  Nitrogen: 20%"));
				tooltip.add(Component.literal("\u00A77  Phosphorus: 20%"));
				tooltip.add(Component.literal("\u00A77  Potassium: 20%"));
			} else {
				tooltip.add(Component.literal("\u00A77  N: 20%"));
				tooltip.add(Component.literal("\u00A77  P: 20%"));
				tooltip.add(Component.literal("\u00A77  K: 20%"));
			}
		} else if (itemstack.getItem() == SurvivalReimaginedModBlocks.MEDIUM_FERTILITY_DIRT.get().asItem()) {
			tooltip.add(Component.literal("\u00A77 Medium Fertility"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77  Nitrogen: 60%"));
				tooltip.add(Component.literal("\u00A77  Phosphorus: 60%"));
				tooltip.add(Component.literal("\u00A77  Potassium: 60%"));
			} else {
				tooltip.add(Component.literal("\u00A77  N: 60%"));
				tooltip.add(Component.literal("\u00A77  P: 60%"));
				tooltip.add(Component.literal("\u00A77  K: 60%"));
			}
		} else if (itemstack.getItem() == SurvivalReimaginedModBlocks.HIGH_FERTILITY_DIRT.get().asItem()) {
			tooltip.add(Component.literal("\u00A77 High Fertility"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77  Nitrogen: 80%"));
				tooltip.add(Component.literal("\u00A77  Phosphorus: 80%"));
				tooltip.add(Component.literal("\u00A77  Potassium: 80%"));
			} else {
				tooltip.add(Component.literal("\u00A77  N: 80%"));
				tooltip.add(Component.literal("\u00A77  P: 80%"));
				tooltip.add(Component.literal("\u00A77  K: 80%"));
			}
		}
	}
}