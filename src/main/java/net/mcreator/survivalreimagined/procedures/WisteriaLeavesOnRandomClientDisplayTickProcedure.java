package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModParticleTypes;

public class WisteriaLeavesOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (Math.random() < 0.3) {
				world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.FALLING_WISTERIA.get()), (x + Math.random()), y, (z + Math.random()), 0, 0, 0);
			}
			if (Math.random() < 0.3) {
				world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.FALLING_WISTERIA_DARK.get()), (x + Math.random()), y, (z + Math.random()), 0, 0, 0);
			}
		}
	}
}
