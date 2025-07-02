package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModParticleTypes;

public class ParticleConstantProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double PosDecX = 0;
		double PosDecY = 0;
		double PosDecZ = 0;
		PosDecX = Math.random();
		PosDecY = Math.random();
		PosDecZ = Math.random();
		world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.RADIATED.get()), (x + PosDecX), (y + PosDecY), (z + PosDecZ), 0.1, 0.4, 0.1);
	}
}
