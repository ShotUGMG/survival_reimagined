package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class FertilizerTooltopRenderingProcedure {
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
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:fertilizers/nitrogen")))) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77 Nitrogen: 20%"));
			} else {
				tooltip.add(Component.literal("\u00A77 N: 20%"));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:fertilizers/phosphorus")))) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77 Phosphorus: 20%"));
			} else {
				tooltip.add(Component.literal("\u00A77 P: 20%"));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:fertilizers/potassium")))) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77 Potassium: 20%"));
			} else {
				tooltip.add(Component.literal("\u00A77 K: 20%"));
			}
		}
	}
}