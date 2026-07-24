package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoodItemCreatedAssignTimeProcedure {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Pre event) {
		execute(event, event.getPlayer().level(), event.getItemEntity().getItem());
	}

	public static void execute(LevelAccessor world, ItemStack itemstack) {
		execute(null, world, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:food/can_rot")))) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("TimeLastChecked") == 0) {
				{
					final String _tagName = "TimeLastChecked";
					final double _tagValue = (world.dayTime());
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		}
	}
}