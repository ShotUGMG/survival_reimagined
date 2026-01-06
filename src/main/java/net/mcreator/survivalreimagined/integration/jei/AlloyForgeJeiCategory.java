package net.mcreator.survivalreimagined.integration.jei;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Font;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.recipe.RecipeUtils;
import net.mcreator.survivalreimagined.recipe.AlloyForgeRecipe;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModJeiPlugin;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;

public class AlloyForgeJeiCategory extends AbstractJeiCategory<RecipeHolder<AlloyForgeRecipe>> {
	public AlloyForgeJeiCategory(IGuiHelper helper) {
		super(SurvivalReimaginedModJeiPlugin.ALLOY_FORGE_JEI_CATEGORY, "jei.survival_reimagined.alloy_forge", helper.createDrawable(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_gui.png"), 0, 0, 176, 86),
				helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.ADVANCED_ALLOY_FORGE.get())));
	}

	@Override
	public void draw(RecipeHolder<AlloyForgeRecipe> recipe, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		Font font = Minecraft.getInstance().font;
		long ticks = Minecraft.getInstance().level.getGameTime();
		if (mouseX > 155 && mouseX < 155 + 16 && mouseY > 66 && mouseY < 66 + 16) {
			guiGraphics.renderComponentTooltip(font, List.of(Component.literal("Forge recipes can be used here. (Alloy Only)")), (int) mouseX, (int) mouseY);
		}
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<AlloyForgeRecipe> recipe) {
		builder.addSlot(RecipeIngredientRole.INPUT, 71, 39).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().alloy_input_1ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 89, 39).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().alloy_input_2ItemInput()));
		builder.addSlot(RecipeIngredientRole.INPUT, 8, 57).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().alloy_input_3ItemInput()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 39).addItemStack(recipe.value().getItemStackResult("alloy_output"));
	}
}