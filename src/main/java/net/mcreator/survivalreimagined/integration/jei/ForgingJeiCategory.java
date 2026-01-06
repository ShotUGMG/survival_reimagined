package net.mcreator.survivalreimagined.integration.jei;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.recipe.RecipeUtils;
import net.mcreator.survivalreimagined.recipe.ForgingRecipe;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModJeiPlugin;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class ForgingJeiCategory extends AbstractJeiCategory<RecipeHolder<ForgingRecipe>> {
	public ForgingJeiCategory(IGuiHelper helper) {
		super(SurvivalReimaginedModJeiPlugin.FORGING_JEI_CATEGORY, "jei.survival_reimagined.forging", helper.createDrawable(ResourceLocation.parse("survival_reimagined:textures/screens/forge_jei.png"), 0, 0, 176, 87),
				helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.FORGE.get())));
	}

	@Override
	public void draw(RecipeHolder<ForgingRecipe> recipe, GuiGraphics guiGraphics, double mouseX, double mouseY) {
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<ForgingRecipe> recipe) {
		builder.addSlot(RecipeIngredientRole.INPUT, 71, 36).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().forge_input_1ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 89, 36).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().forge_input_2ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 26, 62).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().forge_input_3ItemInput()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 36).addItemStack(recipe.value().getItemStackResult("forge_output"));
	}
}