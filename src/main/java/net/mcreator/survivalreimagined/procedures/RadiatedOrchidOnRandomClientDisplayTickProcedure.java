package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModParticleTypes;

public class RadiatedOrchidOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double LocX = 0;
		double LocY = 0;
		double LocZ = 0;
		double PosDecX = 0;
		double PosDecY = 0;
		double PosDecZ = 0;
		for (int index0 = 0; index0 < 20; index0++) {
			LocX = Mth.nextInt(RandomSource.create(), -20, 20);
			LocY = Mth.nextInt(RandomSource.create(), -20, 20);
			LocZ = Mth.nextInt(RandomSource.create(), -20, 20);
			world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.RADIATED.get()), (x + LocX), (y + LocY), (z + LocZ), (Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), (Mth.nextDouble(RandomSource.create(), -0.2, 0.2)),
					(Mth.nextDouble(RandomSource.create(), -0.2, 0.2)));
		}
		PosDecX = Math.random();
		PosDecY = Math.random();
		PosDecZ = Math.random();
		world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.RADIATED.get()), (x + PosDecX), (y + PosDecY), (z + PosDecZ), (Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), 0.4,
				(Mth.nextDouble(RandomSource.create(), -0.2, 0.2)));
	}
}
