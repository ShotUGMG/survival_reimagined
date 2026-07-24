package net.mcreator.survivalreimagined.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModJeiPlugin;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;

public class MineralProcessingJEIRecipeCategory implements IRecipeCategory<MineralProcessingJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("survival_reimagined:mineral_processing_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("survival_reimagined:textures/screens/mpt_jei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public MineralProcessingJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 90);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<MineralProcessingJEIRecipe> getRecipeType() {
		return SurvivalReimaginedModJeiPlugin.MineralProcessingJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Mineral Processing");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(MineralProcessingJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow2-sheet.png"), 80, 33, 0, 16 * ((mc.player.tickCount / 10) % 15) - 1, 16, 16, 16, 240);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MineralProcessingJEIRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 35).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 62).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 98, 35).addItemStack(actualOutputs.get(0));
	}
}