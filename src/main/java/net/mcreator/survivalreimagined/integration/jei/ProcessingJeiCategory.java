package net.mcreator.survivalreimagined.integration.jei;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.recipe.RecipeUtils;
import net.mcreator.survivalreimagined.recipe.ProcessingRecipe;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModJeiPlugin;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class ProcessingJeiCategory extends AbstractJeiCategory<RecipeHolder<ProcessingRecipe>> {
	public ProcessingJeiCategory(IGuiHelper helper) {
		super(SurvivalReimaginedModJeiPlugin.PROCESSING_JEI_CATEGORY, "jei.survival_reimagined.processing", helper.createDrawable(ResourceLocation.parse("survival_reimagined:textures/screens/mpt_jei.png"), 0, 0, 176, 90),
				helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE.get())));
	}

	@Override
	public void draw(RecipeHolder<ProcessingRecipe> recipe, GuiGraphics guiGraphics, double mouseX, double mouseY) {
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<ProcessingRecipe> recipe) {
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 35).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().processing_input_1ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 62).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().processing_input_2ItemInput()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 98, 35).addItemStack(recipe.value().getItemStackResult("processing_output"));
	}
}