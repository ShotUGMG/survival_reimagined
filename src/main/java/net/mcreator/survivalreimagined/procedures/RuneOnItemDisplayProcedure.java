package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class RuneOnItemDisplayProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SapphireInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A79Sapphire";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("AmberInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A76Amber";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("DiamondInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A7bDiamond";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EmeraldInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A72Emerald";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("RubyInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A74Ruby";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A71Lapis";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SpinelInfused") == true) {
				return "\u00A77 Rune Type: \u00A76Gold" + "\n" + "\u00A77 Crystal: \u00A7dSpinel";
			}
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SapphireInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A79Sapphire";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("AmberInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A76Amber";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("DiamondInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A7bDiamond";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EmeraldInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A72Emerald";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("RubyInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A74Ruby";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A71Lapis";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SpinelInfused") == true) {
				return "\u00A77 Rune Type: \u00A7fSilver" + "\n" + "\u00A77 Crystal: \u00A7dSpinel";
			}
		}
		return "\n";
	}
}