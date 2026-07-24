package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Final;

import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBiomes;

import java.util.function.Function;

@Mixin(MultiNoiseBiomeSourceParameterList.Preset.class)
public class BiomeSourcePresetMixin {
	@Mutable
	@Shadow
	@Final
	private MultiNoiseBiomeSourceParameterList.Preset.SourceProvider provider;

	@Inject(method = "<init>", at = @At("RETURN"))
	private void daisyChainProvider(ResourceLocation idArg, MultiNoiseBiomeSourceParameterList.Preset.SourceProvider ignored, CallbackInfo ci) {
		if (idArg.equals(SurvivalReimaginedModBiomes.OVERWORLD_BIOMESOURCE_PRESET_ID) || idArg.equals(SurvivalReimaginedModBiomes.NETHER_BIOMESOURCE_PRESET_ID)) {
			MultiNoiseBiomeSourceParameterList.Preset.SourceProvider existingProvider = this.provider;
			this.provider = new MultiNoiseBiomeSourceParameterList.Preset.SourceProvider() {
				@Override
				public <T> Climate.ParameterList<T> apply(Function<ResourceKey<Biome>, T> lookup) {
					Climate.ParameterList<T> originalList = existingProvider.apply(lookup);
					return SurvivalReimaginedModBiomes.adaptPresetParameterList(idArg, originalList, lookup);
				}
			};
		}
	}
}