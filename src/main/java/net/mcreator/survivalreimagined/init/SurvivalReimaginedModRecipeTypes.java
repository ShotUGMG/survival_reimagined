package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.survivalreimagined.jei_recipes.MineralProcessingJEIRecipe;
import net.mcreator.survivalreimagined.jei_recipes.MillstoneJEIRecipe;
import net.mcreator.survivalreimagined.jei_recipes.MetalRefiningRecipe;
import net.mcreator.survivalreimagined.jei_recipes.ForgeJEIRecipe;

@EventBusSubscriber
public class SurvivalReimaginedModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "survival_reimagined");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "survival_reimagined");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("survival_reimagined").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("millstone_jei", () -> MillstoneJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("millstone_jei", () -> MillstoneJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("forge_jei", () -> ForgeJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("forge_jei", () -> ForgeJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("metal_refining", () -> MetalRefiningRecipe.Type.INSTANCE);
			SERIALIZERS.register("metal_refining", () -> MetalRefiningRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("mineral_processing_jei", () -> MineralProcessingJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("mineral_processing_jei", () -> MineralProcessingJEIRecipe.Serializer.INSTANCE);
		});
	}
}