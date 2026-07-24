package net.mcreator.survivalreimagined.mixin;

import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({NoiseBasedChunkGenerator.class})
public abstract class NoiseBasedChunkGeneratorMixin {
    public NoiseBasedChunkGeneratorMixin() {
    }

    @Inject(
        method = {"createFluidPicker"},
        at = {@At("HEAD")},
        cancellable = true
    )
    private static void onCreateFluidPicker(NoiseGeneratorSettings settings, CallbackInfoReturnable<Aquifer.FluidPicker> cir) {
        cir.setReturnValue((x, y, z) -> {
            return y < -54 ? new Aquifer.FluidStatus(settings.seaLevel(), Fluids.WATER.defaultFluidState().createLegacyBlock()) : new Aquifer.FluidStatus(settings.seaLevel(), settings.defaultFluid());
        });
    }
}