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

import net.mcreator.survivalreimagined.jei_recipes.ProcessingRecipe;
import net.mcreator.survivalreimagined.jei_recipes.MetalRefiningRecipe;
import net.mcreator.survivalreimagined.jei_recipes.ForgingRecipe;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber(modid = SurvivalReimaginedMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SurvivalReimaginedModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "survival_reimagined");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "survival_reimagined");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("survival_reimagined").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("forging", () -> ForgingRecipe.Type.INSTANCE);
			SERIALIZERS.register("forging", () -> ForgingRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("metal_refining", () -> MetalRefiningRecipe.Type.INSTANCE);
			SERIALIZERS.register("metal_refining", () -> MetalRefiningRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("processing", () -> ProcessingRecipe.Type.INSTANCE);
			SERIALIZERS.register("processing", () -> ProcessingRecipe.Serializer.INSTANCE);
		});
	}
}
