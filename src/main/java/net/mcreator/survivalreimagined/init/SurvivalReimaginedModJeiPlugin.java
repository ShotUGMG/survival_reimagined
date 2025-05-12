
package net.mcreator.survivalreimagined.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.jei_recipes.ProcessingRecipeCategory;
import net.mcreator.survivalreimagined.jei_recipes.ProcessingRecipe;
import net.mcreator.survivalreimagined.jei_recipes.MetalRefiningRecipeCategory;
import net.mcreator.survivalreimagined.jei_recipes.MetalRefiningRecipe;
import net.mcreator.survivalreimagined.jei_recipes.ForgingRecipeCategory;
import net.mcreator.survivalreimagined.jei_recipes.ForgingRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class SurvivalReimaginedModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<ForgingRecipe> Forging_Type = new mezz.jei.api.recipe.RecipeType<>(ForgingRecipeCategory.UID, ForgingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MetalRefiningRecipe> MetalRefining_Type = new mezz.jei.api.recipe.RecipeType<>(MetalRefiningRecipeCategory.UID, MetalRefiningRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<ProcessingRecipe> Processing_Type = new mezz.jei.api.recipe.RecipeType<>(ProcessingRecipeCategory.UID, ProcessingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("survival_reimagined:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new ForgingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MetalRefiningRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ProcessingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<ForgingRecipe> ForgingRecipes = recipeManager.getAllRecipesFor(ForgingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Forging_Type, ForgingRecipes);
		List<MetalRefiningRecipe> MetalRefiningRecipes = recipeManager.getAllRecipesFor(MetalRefiningRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MetalRefining_Type, MetalRefiningRecipes);
		List<ProcessingRecipe> ProcessingRecipes = recipeManager.getAllRecipesFor(ProcessingRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Processing_Type, ProcessingRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
	}
}
