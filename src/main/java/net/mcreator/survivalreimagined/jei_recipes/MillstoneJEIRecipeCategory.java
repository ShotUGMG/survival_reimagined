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
import java.util.ArrayList;

public class MillstoneJEIRecipeCategory implements IRecipeCategory<MillstoneJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("survival_reimagined:millstone_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("survival_reimagined:textures/screens/millstone_gui_jei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public MillstoneJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 90);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.MILLSTONE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<MillstoneJEIRecipe> getRecipeType() {
		return SurvivalReimaginedModJeiPlugin.MillstoneJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Millstone JEI");
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
	public void draw(MillstoneJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/millstoe_arrow.png"), 79, 39, 0, 18 * ((mc.player.tickCount / 10) % 8) - 1, 18, 18, 18, 144);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MillstoneJEIRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> stacks = new ArrayList<>();
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(0).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(0)));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 21).addItemStacks(stacks);
		builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 66).addItemStack(actualOutputs.get(0));
	}
}