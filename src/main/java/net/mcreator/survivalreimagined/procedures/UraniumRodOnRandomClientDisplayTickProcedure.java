package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModParticleTypes;

public class UraniumRodOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.RADIATION_PARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), 0.25, 0.75)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
				(z + Mth.nextDouble(RandomSource.create(), 0.25, 0.75)), 0, 0, 0);
		world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.RADIATION_PARTICLE_2.get()), (x + Mth.nextDouble(RandomSource.create(), 0.25, 0.75)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
				(z + Mth.nextDouble(RandomSource.create(), 0.25, 0.75)), 0, 0, 0);
		if (Math.random() < 0.1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.ambient")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.ambient")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}
