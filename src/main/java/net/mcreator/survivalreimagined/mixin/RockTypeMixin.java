package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.util.List;

@Mixin(Item.class)
public abstract class RockTypeMixin {
	@Inject(method = "appendHoverText", at = @At("TAIL"))
	private void onAppendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag, CallbackInfo ci) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/tin")))) {
			tooltip.add(Component.translatable("tin.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/copper")))) {
			tooltip.add(Component.translatable("copper.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/iron")))) {
			tooltip.add(Component.translatable("iron.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/manganese")))) {
			tooltip.add(Component.translatable("manganese.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/silver")))) {
			tooltip.add(Component.translatable("silver.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/gold")))) {
			tooltip.add(Component.translatable("gold.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/titanium")))) {
			tooltip.add(Component.translatable("titanium.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/uranium")))) {
			tooltip.add(Component.translatable("uranium.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/zinc")))) {
			tooltip.add(Component.translatable("zinc.tooltip").withStyle(ChatFormatting.GRAY));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rock_type/coal")))) {
			tooltip.add(Component.translatable("coal.tooltip").withStyle(ChatFormatting.GRAY));
		}
	}
}