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

public class ForgeJEIRecipeCategory implements IRecipeCategory<ForgeJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("survival_reimagined:forge_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("survival_reimagined:textures/screens/forge_jei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public ForgeJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 87);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SurvivalReimaginedModBlocks.FORGE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<ForgeJEIRecipe> getRecipeType() {
		return SurvivalReimaginedModJeiPlugin.ForgeJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Forge");
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
	public void draw(ForgeJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter-sheet-export.png"), 12, 48, 0, 29 * ((mc.player.tickCount / 5) % 14) - 0, 8, 29, 8, 435);

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow2-sheet.png"), 112, 34, 0, 16 * ((mc.player.tickCount / 10) % 15) - 1, 16, 16, 16, 240);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, ForgeJEIRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> stacks = new ArrayList<>();
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(0).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(0)));
		builder.addSlot(RecipeIngredientRole.INPUT, 71, 36).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(1).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(1)));
		builder.addSlot(RecipeIngredientRole.INPUT, 89, 36).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(2).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(2)));
		builder.addSlot(RecipeIngredientRole.INPUT, 26, 62).addItemStacks(stacks);
		builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 36).addItemStack(actualOutputs.get(0));
	}
}