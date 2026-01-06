package net.mcreator.survivalreimagined.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.recipe.ProcessingRecipe;
import net.mcreator.survivalreimagined.recipe.MetalRefiningRecipe;
import net.mcreator.survivalreimagined.recipe.ForgingRecipe;
import net.mcreator.survivalreimagined.recipe.AlloyForgeRecipe;
import net.mcreator.survivalreimagined.integration.jei.ProcessingJeiCategory;
import net.mcreator.survivalreimagined.integration.jei.MetalRefiningJeiCategory;
import net.mcreator.survivalreimagined.integration.jei.ForgingJeiCategory;
import net.mcreator.survivalreimagined.integration.jei.AlloyForgeJeiCategory;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;

@JeiPlugin
public class SurvivalReimaginedModJeiPlugin implements IModPlugin {
	private static final String UID = "survival_reimagined";
	public static RecipeType<RecipeHolder<ForgingRecipe>> FORGING_JEI_CATEGORY = RecipeType.create(UID, "forging", (Class<RecipeHolder<ForgingRecipe>>) (Class<?>) ForgingRecipe.class);
	public static RecipeType<RecipeHolder<ProcessingRecipe>> PROCESSING_JEI_CATEGORY = RecipeType.create(UID, "processing", (Class<RecipeHolder<ProcessingRecipe>>) (Class<?>) ProcessingRecipe.class);
	public static RecipeType<RecipeHolder<MetalRefiningRecipe>> METAL_REFINING_JEI_CATEGORY = RecipeType.create(UID, "metal_refining", (Class<RecipeHolder<MetalRefiningRecipe>>) (Class<?>) MetalRefiningRecipe.class);
	public static RecipeType<RecipeHolder<AlloyForgeRecipe>> ALLOY_FORGE_JEI_CATEGORY = RecipeType.create(UID, "alloy_forge", (Class<RecipeHolder<AlloyForgeRecipe>>) (Class<?>) AlloyForgeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.fromNamespaceAndPath(UID, "jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new ForgingJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ProcessingJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MetalRefiningJeiCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new AlloyForgeJeiCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		registration.addRecipes(FORGING_JEI_CATEGORY, recipeManager.getAllRecipesFor(ForgingRecipe.Type.INSTANCE));
		registration.addRecipes(PROCESSING_JEI_CATEGORY, recipeManager.getAllRecipesFor(ProcessingRecipe.Type.INSTANCE));
		registration.addRecipes(METAL_REFINING_JEI_CATEGORY, recipeManager.getAllRecipesFor(MetalRefiningRecipe.Type.INSTANCE));
		registration.addRecipes(ALLOY_FORGE_JEI_CATEGORY, recipeManager.getAllRecipesFor(AlloyForgeRecipe.Type.INSTANCE));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.FORGE.get().asItem()), FORGING_JEI_CATEGORY);
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE.get().asItem()), PROCESSING_JEI_CATEGORY);
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.METAL_REFINING_TABLE.get().asItem()), METAL_REFINING_JEI_CATEGORY);
		registration.addRecipeCatalyst(new ItemStack(SurvivalReimaginedModBlocks.ADVANCED_ALLOY_FORGE.get().asItem()), ALLOY_FORGE_JEI_CATEGORY);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
	}
}