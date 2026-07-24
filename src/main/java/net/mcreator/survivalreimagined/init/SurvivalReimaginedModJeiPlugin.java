package net.mcreator.survivalreimagined.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.jei_recipes.*;

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
	public static mezz.jei.api.recipe.RecipeType<MillstoneJEIRecipe> MillstoneJEI_Type = new mezz.jei.api.recipe.RecipeType<>(MillstoneJEIRecipeCategory.UID, MillstoneJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<ForgeJEIRecipe> ForgeJEI_Type = new mezz.jei.api.recipe.RecipeType<>(ForgeJEIRecipeCategory.UID, ForgeJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MetalRefiningRecipe> MetalRefining_Type = new mezz.jei.api.recipe.RecipeType<>(MetalRefiningRecipeCategory.UID, MetalRefiningRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MineralProcessingJEIRecipe> MineralProcessingJEI_Type = new mezz.jei.api.recipe.RecipeType<>(MineralProcessingJEIRecipeCategory.UID, MineralProcessingJEIRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("survival_reimagined:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new MillstoneJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ForgeJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MetalRefiningRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MineralProcessingJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<MillstoneJEIRecipe> MillstoneJEIRecipes = recipeManager.getAllRecipesFor(MillstoneJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MillstoneJEI_Type, MillstoneJEIRecipes);
		List<ForgeJEIRecipe> ForgeJEIRecipes = recipeManager.getAllRecipesFor(ForgeJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(ForgeJEI_Type, ForgeJEIRecipes);
		List<MetalRefiningRecipe> MetalRefiningRecipes = recipeManager.getAllRecipesFor(MetalRefiningRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MetalRefining_Type, MetalRefiningRecipes);
		List<MineralProcessingJEIRecipe> MineralProcessingJEIRecipes = recipeManager.getAllRecipesFor(MineralProcessingJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MineralProcessingJEI_Type, MineralProcessingJEIRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.MILLSTONE.get().asItem()), MillstoneJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.FORGE.get().asItem()), ForgeJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.METAL_REFINING_TABLE.get().asItem()), MetalRefining_Type);
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE.get().asItem()), MineralProcessingJEI_Type);
	}
}