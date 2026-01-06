package net.mcreator.survivalreimagined.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class SurvivalReimaginedModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("survival_reimagined:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(SurvivalReimaginedModItems.SAPPHIRE_GOLD_RUNE.get()), new ItemStack(SurvivalReimaginedModItems.SAPPHIRE_SILVER_RUNE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.survival_reimagined.sapphire_rune"));
		registration.addIngredientInfo(List.of(new ItemStack(SurvivalReimaginedModItems.SILVER_AMBER_RUNE.get()), new ItemStack(SurvivalReimaginedModItems.GOLD_AMBER_RUNE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.survival_reimagined.amber_rune"));
		registration.addIngredientInfo(List.of(new ItemStack(SurvivalReimaginedModItems.GOLD_DIAMOND_RUNE.get()), new ItemStack(SurvivalReimaginedModItems.SILVER_DIAMOND_RUNE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.survival_reimagined.diamond_rune"));
		registration.addIngredientInfo(List.of(new ItemStack(SurvivalReimaginedModItems.SILVER_EMERALD_RUNE.get()), new ItemStack(SurvivalReimaginedModItems.GOLD_EMERALD_RUNE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.survival_reimagined.emerald_rune"));
		registration.addIngredientInfo(List.of(new ItemStack(SurvivalReimaginedModItems.GOLD_LAPIS_RUNE.get()), new ItemStack(SurvivalReimaginedModItems.SILVER_LAPIS_RUNE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.survival_reimagined.lapis_rune"));
		registration.addIngredientInfo(List.of(new ItemStack(SurvivalReimaginedModItems.SILVER_RUBY_RUNE.get()), new ItemStack(SurvivalReimaginedModItems.GOLD_RUBY_RUNE.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.survival_reimagined.ruby_rune"));
	}
}