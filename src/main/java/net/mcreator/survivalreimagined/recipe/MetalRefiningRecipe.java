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

public record MetalRefiningRecipe(SizedIngredient metal_input_1ItemInput, SizedIngredient metal_input_2ItemInput, SizedIngredient metal_input_3ItemInput, ItemStack metal_outputItemOutput) implements Recipe<RecipeInput> {
	public @NotNull ItemStack getItemStackResult(String output) {
		if (output.equals("metal_output")) {
			return metal_outputItemOutput;
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

	public static class Type implements RecipeType<MetalRefiningRecipe> {
		private Type() {
		}

		public static final RecipeType<MetalRefiningRecipe> INSTANCE = new Type();
	}

	public static class Serializer implements RecipeSerializer<MetalRefiningRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public final MapCodec<MetalRefiningRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
				.group(SizedIngredient.FLAT_CODEC.fieldOf("metal_input_1").forGetter(MetalRefiningRecipe::metal_input_1ItemInput), SizedIngredient.FLAT_CODEC.fieldOf("metal_input_2").forGetter(MetalRefiningRecipe::metal_input_2ItemInput),
						SizedIngredient.FLAT_CODEC.fieldOf("metal_input_3").forGetter(MetalRefiningRecipe::metal_input_3ItemInput), ItemStack.CODEC.fieldOf("metal_output").forGetter(MetalRefiningRecipe::metal_outputItemOutput))
				.apply(instance, Serializer::createMetalRefiningRecipe));
		private static final StreamCodec<RegistryFriendlyByteBuf, MetalRefiningRecipe> STREAM_CODEC = StreamCodec.of(Serializer::write, Serializer::read);

		@Override
		public @NotNull MapCodec<MetalRefiningRecipe> codec() {
			return CODEC;
		}

		@Override
		public @NotNull StreamCodec<RegistryFriendlyByteBuf, MetalRefiningRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static MetalRefiningRecipe read(RegistryFriendlyByteBuf buffer) {
			SizedIngredient metal_input_1ItemInput = SizedIngredient.STREAM_CODEC.decode(buffer);
			SizedIngredient metal_input_2ItemInput = SizedIngredient.STREAM_CODEC.decode(buffer);
			SizedIngredient metal_input_3ItemInput = SizedIngredient.STREAM_CODEC.decode(buffer);
			ItemStack metal_outputItemOutput = ItemStack.STREAM_CODEC.decode(buffer);
			return new MetalRefiningRecipe(metal_input_1ItemInput, metal_input_2ItemInput, metal_input_3ItemInput, metal_outputItemOutput);
		}

		private static void write(RegistryFriendlyByteBuf buffer, MetalRefiningRecipe recipe) {
			SizedIngredient.STREAM_CODEC.encode(buffer, recipe.metal_input_1ItemInput());
			SizedIngredient.STREAM_CODEC.encode(buffer, recipe.metal_input_2ItemInput());
			SizedIngredient.STREAM_CODEC.encode(buffer, recipe.metal_input_3ItemInput());
			ItemStack.STREAM_CODEC.encode(buffer, recipe.metal_outputItemOutput());
		}

		static MetalRefiningRecipe createMetalRefiningRecipe(SizedIngredient metal_input_1ItemInput, SizedIngredient metal_input_2ItemInput, SizedIngredient metal_input_3ItemInput, ItemStack metal_outputItemOutput) {
			return new MetalRefiningRecipe(metal_input_1ItemInput, metal_input_2ItemInput, metal_input_3ItemInput, metal_outputItemOutput);
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