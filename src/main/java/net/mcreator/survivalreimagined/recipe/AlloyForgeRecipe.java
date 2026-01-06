package net.mcreator.survivalreimagined.recipe;

import org.jetbrains.annotations.NotNull;

import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;

import javax.annotation.Nonnull;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;

public record AlloyForgeRecipe(SizedIngredient alloy_input_1ItemInput, SizedIngredient alloy_input_2ItemInput, SizedIngredient alloy_input_3ItemInput, ItemStack alloy_outputItemOutput) implements Recipe<RecipeInput> {
	public @NotNull ItemStack getItemStackResult(String output) {
		if (output.equals("alloy_output")) {
			return alloy_outputItemOutput;
		}
		return ItemStack.EMPTY;
	}

	public @NotNull FluidStack getFluidStackResult(String output) {
		return FluidStack.EMPTY;
	}

	public @NotNull boolean getBooleanResult(String output) {
		return false;
	}

	public @NotNull double getDoubleResult(String output) {
		return 0.0d;
	}

	public @NotNull String getStringResult(String output) {
		return "";
	}

	public static class Type implements RecipeType<AlloyForgeRecipe> {
		private Type() {
		}

		public static final RecipeType<AlloyForgeRecipe> INSTANCE = new Type();
	}

	public static class Serializer implements RecipeSerializer<AlloyForgeRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public final MapCodec<AlloyForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
				.group(SizedIngredient.FLAT_CODEC.fieldOf("alloy_input_1").forGetter(AlloyForgeRecipe::alloy_input_1ItemInput), SizedIngredient.FLAT_CODEC.fieldOf("alloy_input_2").forGetter(AlloyForgeRecipe::alloy_input_2ItemInput),
						SizedIngredient.FLAT_CODEC.fieldOf("alloy_input_3").forGetter(AlloyForgeRecipe::alloy_input_3ItemInput), ItemStack.CODEC.fieldOf("alloy_output").forGetter(AlloyForgeRecipe::alloy_outputItemOutput))
				.apply(instance, Serializer::createAlloyForgeRecipe));
		private static final StreamCodec<RegistryFriendlyByteBuf, AlloyForgeRecipe> STREAM_CODEC = StreamCodec.of(Serializer::write, Serializer::read);

		@Override
		public @NotNull MapCodec<AlloyForgeRecipe> codec() {
			return CODEC;
		}

		@Override
		public @NotNull StreamCodec<RegistryFriendlyByteBuf, AlloyForgeRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static AlloyForgeRecipe read(RegistryFriendlyByteBuf buffer) {
			SizedIngredient alloy_input_1ItemInput = SizedIngredient.STREAM_CODEC.decode(buffer);
			SizedIngredient alloy_input_2ItemInput = SizedIngredient.STREAM_CODEC.decode(buffer);
			SizedIngredient alloy_input_3ItemInput = SizedIngredient.STREAM_CODEC.decode(buffer);
			ItemStack alloy_outputItemOutput = ItemStack.STREAM_CODEC.decode(buffer);
			return new AlloyForgeRecipe(alloy_input_1ItemInput, alloy_input_2ItemInput, alloy_input_3ItemInput, alloy_outputItemOutput);
		}

		private static void write(RegistryFriendlyByteBuf buffer, AlloyForgeRecipe recipe) {
			SizedIngredient.STREAM_CODEC.encode(buffer, recipe.alloy_input_1ItemInput());
			SizedIngredient.STREAM_CODEC.encode(buffer, recipe.alloy_input_2ItemInput());
			SizedIngredient.STREAM_CODEC.encode(buffer, recipe.alloy_input_3ItemInput());
			ItemStack.STREAM_CODEC.encode(buffer, recipe.alloy_outputItemOutput());
		}

		static AlloyForgeRecipe createAlloyForgeRecipe(SizedIngredient alloy_input_1ItemInput, SizedIngredient alloy_input_2ItemInput, SizedIngredient alloy_input_3ItemInput, ItemStack alloy_outputItemOutput) {
			return new AlloyForgeRecipe(alloy_input_1ItemInput, alloy_input_2ItemInput, alloy_input_3ItemInput, alloy_outputItemOutput);
		}
	}

	// Unused
	@Override
	public @NotNull RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	// Unused
	@Override
	public @NotNull RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	// Unused
	@Override
	public @Nonnull NonNullList<Ingredient> getIngredients() {
		return NonNullList.withSize(1, Ingredient.EMPTY);
	}

	// Unused
	@Override
	public boolean matches(@NotNull RecipeInput pContainer, @NotNull Level Level) {
		return false;
	}

	// Unused
	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	// Unused
	@Override
	public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
		return ItemStack.EMPTY;
	}

	// Unused
	@Override
	public ItemStack assemble(@NotNull RecipeInput input, @NotNull HolderLookup.Provider holder) {
		return ItemStack.EMPTY;
	}
}