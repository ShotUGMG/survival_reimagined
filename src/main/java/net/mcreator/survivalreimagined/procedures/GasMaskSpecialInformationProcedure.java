package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class GasMaskSpecialInformationProcedure {
	public static String execute(LevelAccessor world, ItemStack itemstack) {
		if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("survival_reimagined:perpetual_filtering")))) != 0) {
			return "\n";
		} else if (itemstack.getDamageValue() < 119 || itemstack.getDamageValue() == 0) {
			return "\u00A77 Condition: \u00A72Usable";
		} else if (itemstack.getDamageValue() >= 119) {
			return "\u00A77 Condition: \u00A74Unusable";
		}
		return "\n";
	}
}