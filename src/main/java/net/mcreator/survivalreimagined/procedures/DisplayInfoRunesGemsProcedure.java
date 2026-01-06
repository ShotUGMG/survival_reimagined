package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisplayInfoRunesGemsProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rune_type/gold"))) && itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes")))) {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/sapphire")))) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A79Sapphire" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/amber")))) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A76Amber" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/diamond")))) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A7bDiamond" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/emerald")))) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A72Emerald" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/ruby")))) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A74Ruby" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/lapis")))) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A71Lapis" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rune_type/silver"))) && itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes")))) {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/sapphire")))) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A79Sapphire" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/amber")))) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A76Amber" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/diamond")))) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A7bDiamond" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/emerald")))) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A72Emerald" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/ruby")))) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A74Ruby" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:runes/lapis")))) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A71Lapis" + "\n" + "\n" + "\u00A7fApplies to:" + "\n" + "\u00A77 Weapons" + "\n" + "\u00A77 Armor" + "\n" + "\u00A77 Tools";
			}
		}
		return "\n";
	}
}