package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import org.checkerframework.common.aliasing.qual.Unique;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.tags.SurvivalReimaginedItemModTags;

import java.util.Set;

@Mixin(ItemStack.class)
public class ItemstackFixForMeatItemsMixin {
	@Inject(
		method = "isSameItemSameComponents",
		at = @At("HEAD"),
		cancellable = true	
	)
	private static void onlyCompareItems(
		ItemStack first,
		ItemStack second,
		CallbackInfoReturnable<Boolean> cir
	) {
		if (shouldIgnoreComponents(first)
		&& first.getItem() == second.getItem()) {
			cir.setReturnValue(true);
		}
	}
	private static boolean shouldIgnoreComponents(ItemStack stack) {
		return stack.is(SurvivalReimaginedItemModTags.Items.MERGEABLE_MEATS);
	}
}