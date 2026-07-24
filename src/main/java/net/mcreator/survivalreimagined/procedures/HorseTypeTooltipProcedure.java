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

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class HorseTypeTooltipProcedure {
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
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/white")))) {
			tooltip.add(Component.literal("\u00A77 White"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/creamy")))) {
			tooltip.add(Component.literal("\u00A77 Creamy"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/chestnut")))) {
			tooltip.add(Component.literal("\u00A77 Chestnut"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/brown")))) {
			tooltip.add(Component.literal("\u00A77 Brown"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/black")))) {
			tooltip.add(Component.literal("\u00A77 Black"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/gray")))) {
			tooltip.add(Component.literal("\u00A77 Gray"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_color/darkbrown")))) {
			tooltip.add(Component.literal("\u00A77 Dark Brown"));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_markings/stockings")))) {
			tooltip.add(Component.literal("\u00A77 Stockings"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_markings/field")))) {
			tooltip.add(Component.literal("\u00A77 WhiteField"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_markings/white_dots")))) {
			tooltip.add(Component.literal("\u00A77 White Dots"));
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:horse_markings/black_dots")))) {
			tooltip.add(Component.literal("\u00A77 Black Dots"));
		}
	}
}