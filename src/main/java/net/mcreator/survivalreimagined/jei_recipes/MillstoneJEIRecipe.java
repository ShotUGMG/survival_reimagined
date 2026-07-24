package net.mcreator.survivalreimagined.jei_recipes;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;

import java.util.List;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Codec;

public class MillstoneJEIRecipe implements Recipe<RecipeInput> {
	private final List<ItemStack> output;
	private final NonNullList<Ingredient> recipeItems;
	private final List<Integer> integers;

	public MillstoneJEIRecipe(List<ItemStack> output, NonNullList<Ingredient> recipeItems, List<Integer> integers) {
		this.output = output;
		this.recipeItems = recipeItems;
		this.integers = integers;
	}

	@Override
	public boolean matches(RecipeInput pContainer, Level pLevel) {
		if (pLevel.isClientSide()) {
			return false;
		}
		return false;
	}

	public List<Integer> integers() {
		return this.integers;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(RecipeInput input, HolderLookup.Provider holder) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider provider) {
		return ItemStack.EMPTY;
	}

	public List<ItemStack> getResultItems() {
		return output;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<MillstoneJEIRecipe> {
		private Type() {
		}

		public static final RecipeType<MillstoneJEIRecipe> INSTANCE = new Type();
	}

	public static class Serializer implements RecipeSerializer<MillstoneJEIRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		private static final MapCodec<MillstoneJEIRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(ItemStack.OPTIONAL_CODEC.listOf().fieldOf("outputs").forGetter(recipe -> recipe.output), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap(ingredients -> {
					Ingredient[] aingredient = ingredients.toArray(Ingredient[]::new); // Skip the empty check and create the array.
					if (aingredient.length == 0) {
						return DataResult.error(() -> "No ingredients found in custom recipe");
					} else {
						return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
					}
				}, DataResult::success).forGetter(recipe -> recipe.recipeItems), Codec.INT.listOf().fieldOf("integers").forGetter(recipe -> recipe.integers)).apply(builder, MillstoneJEIRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, MillstoneJEIRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

		@Override
		public MapCodec<MillstoneJEIRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, MillstoneJEIRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static MillstoneJEIRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
			inputs.replaceAll(ingredients -> Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
			List<ItemStack> outputs = NonNullList.withSize(buf.readVarInt(), ItemStack.EMPTY);
			outputs.replaceAll(results -> ItemStack.STREAM_CODEC.decode(buf));
			List<Integer> numbers = NonNullList.withSize(buf.readVarInt(), 0);
			numbers.replaceAll(num -> buf.readVarInt());
			return new MillstoneJEIRecipe(outputs, inputs, numbers);
		}

		private static void toNetwork(RegistryFriendlyByteBuf buf, MillstoneJEIRecipe recipe) {
			buf.writeVarInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				if (ing.getItems()[0].getItem() == Items.AIR)
					Ingredient.CONTENTS_STREAM_CODEC.encode(buf, Ingredient.EMPTY);
				else
					Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
			}
			buf.writeVarInt(recipe.getResultItems().size());
			for (ItemStack itemstack : recipe.getResultItems()) {
				ItemStack.STREAM_CODEC.encode(buf, itemstack);
			}
			buf.writeVarInt(recipe.integers().size());
			for (Integer num : recipe.integers()) {
				buf.writeVarInt(num);
			}
		}
	}
}