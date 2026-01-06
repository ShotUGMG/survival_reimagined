package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements SurvivalReimaginedModBiomes.SurvivalReimaginedModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> survival_reimagined_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.survival_reimagined_dimensionTypeReference != null) {
			retval = SurvivalReimaginedModBiomes.adaptSurfaceRule(retval, this.survival_reimagined_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setsurvival_reimaginedDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.survival_reimagined_dimensionTypeReference = dimensionType;
	}
}