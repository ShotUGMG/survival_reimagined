package net.mcreator.survivalreimagined.integration.jei;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.recipe.RecipeUtils;
import net.mcreator.survivalreimagined.recipe.MetalRefiningRecipe;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModJeiPlugin;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class MetalRefiningJeiCategory extends AbstractJeiCategory<RecipeHolder<MetalRefiningRecipe>> {
	public MetalRefiningJeiCategory(IGuiHelper helper) {
		super(SurvivalReimaginedModJeiPlugin.METAL_REFINING_JEI_CATEGORY, "jei.survival_reimagined.metal_refining", helper.createDrawable(ResourceLocation.parse("survival_reimagined:textures/screens/mrt_jei.png"), 0, 0, 176, 90),
				helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.METAL_REFINING_TABLE.get())));
	}

	@Override
	public void draw(RecipeHolder<MetalRefiningRecipe> recipe, GuiGraphics guiGraphics, double mouseX, double mouseY) {
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<MetalRefiningRecipe> recipe) {
		builder.addSlot(RecipeIngredientRole.INPUT, 44, 38).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().metal_input_1ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 38).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().metal_input_2ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 152, 63).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().metal_input_3ItemInput()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 38).addItemStack(recipe.value().getItemStackResult("metal_output"));
	}
}