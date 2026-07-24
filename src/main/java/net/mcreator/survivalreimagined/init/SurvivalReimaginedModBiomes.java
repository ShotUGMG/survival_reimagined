/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

@EventBusSubscriber
public class SurvivalReimaginedModBiomes {
	public static final ResourceLocation OVERWORLD_BIOMESOURCE_PRESET_ID = ResourceLocation.withDefaultNamespace("overworld");
	public static final ResourceLocation NETHER_BIOMESOURCE_PRESET_ID = ResourceLocation.withDefaultNamespace("nether");
	private static boolean BOOTSTRAP_VALIDATION_PASSED = false;

	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		BOOTSTRAP_VALIDATION_PASSED = true;
	}

	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		Registry<LevelStem> levelStemTypeRegistry = event.getServer().registryAccess().registryOrThrow(Registries.LEVEL_STEM);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			Holder<DimensionType> dimensionType = levelStem.type();
			if (dimensionType.is(BuiltinDimensionTypes.NETHER) || dimensionType.is(BuiltinDimensionTypes.OVERWORLD)) {
				if (levelStem.generator() instanceof NoiseBasedChunkGenerator noiseGenerator) {
					((SurvivalReimaginedModNoiseGeneratorSettings) (Object) noiseGenerator.generatorSettings().value()).setsurvival_reimaginedDimensionTypeReference(dimensionType);
				}
			}
		}
	}

	public static SurfaceRules.RuleSource adaptSurfaceRule(SurfaceRules.RuleSource currentRuleSource, Holder<DimensionType> dimensionType) {
		if (dimensionType.is(BuiltinDimensionTypes.OVERWORLD))
			return injectOverworldSurfaceRules(currentRuleSource);
		return currentRuleSource;
	}

	public static <T> Climate.ParameterList<T> adaptPresetParameterList(ResourceLocation idArg, Climate.ParameterList<T> originalList, Function<ResourceKey<Biome>, T> lookup) {
		if (!BOOTSTRAP_VALIDATION_PASSED)
			return originalList;
		if (idArg.equals(OVERWORLD_BIOMESOURCE_PRESET_ID))
			return SurvivalReimaginedModBiomes.modifyOverworldParameterPoints(originalList, lookup);
		return originalList;
	}

	private static SurfaceRules.RuleSource injectOverworldSurfaceRules(SurfaceRules.RuleSource currentRuleSource) {
		List<SurfaceRules.RuleSource> customSurfaceRules = new ArrayList<>();
		customSurfaceRules.add(anySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("survival_reimagined", "radiated_forest")), SurvivalReimaginedModBlocks.RADIATED_SHALE.get().defaultBlockState(),
				SurvivalReimaginedModBlocks.SHALE.get().defaultBlockState(), SurvivalReimaginedModBlocks.SHALE.get().defaultBlockState()));
		customSurfaceRules.add(preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_forest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
				Blocks.DIRT.defaultBlockState()));
		if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
			customSurfaceRules.addAll(sequenceRuleSource.sequence());
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		} else {
			customSurfaceRules.add(currentRuleSource);
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		}
	}

	public static <T> Climate.ParameterList<T> modifyOverworldParameterPoints(Climate.ParameterList<T> originalList, Function<ResourceKey<Biome>, T> lookup) {
		List<Pair<Climate.ParameterPoint, T>> parameters = new ArrayList<>(originalList.values());
		parameters.add(new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.8f, -0.1f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-1.05f, 0.3f), Climate.Parameter.span(-0.2f, 1f), Climate.Parameter.point(0.0f),
				Climate.Parameter.span(-1f, 0f), 0), lookup.apply(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_forest")))));
		parameters.add(new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.8f, -0.1f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-1.05f, 0.3f), Climate.Parameter.span(-0.2f, 1f), Climate.Parameter.point(1.0f),
				Climate.Parameter.span(-1f, 0f), 0), lookup.apply(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_forest")))));
		parameters.add(new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.3f, 0.3f), Climate.Parameter.span(-0.8f, 0.8f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 0f), Climate.Parameter.span(0.75f, 1.5f),
				Climate.Parameter.span(0f, 1f), 0), lookup.apply(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("survival_reimagined", "radiated_forest")))));
		return new Climate.ParameterList<>(parameters);
	}

	private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
										SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock)))));
	}

	private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(5), 0),
						SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0)),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
												SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
										SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock))))));
	}

	public interface SurvivalReimaginedModNoiseGeneratorSettings {
		void setsurvival_reimaginedDimensionTypeReference(Holder<DimensionType> dimensionType);
	}
}