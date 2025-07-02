package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class RadiatedMossOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double LocXPlus1 = 0;
		double LocZPlus1 = 0;
		for (int index0 = 0; index0 < 12; index0++) {
			LocXPlus1 = Mth.nextInt(RandomSource.create(), -3, 3);
			LocZPlus1 = Mth.nextInt(RandomSource.create(), -3, 3);
			if (world.isEmptyBlock(BlockPos.containing(x + LocXPlus1, y + 1, z + LocZPlus1)) && (world.getBlockState(BlockPos.containing(x + LocXPlus1, y, z + LocZPlus1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))) {
				if (Math.random() < 0.1) {
					world.setBlock(BlockPos.containing(x + LocXPlus1, y + 1, z + LocZPlus1), SurvivalReimaginedModBlocks.RADIATED_ORCHID.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x + LocXPlus1, y + 1, z + LocZPlus1), SurvivalReimaginedModBlocks.RADIATED_TALL_GRASS.get().defaultBlockState(), 3);
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.COMPOSTER, x, (y + 1), z, 20, 6, 1, 6, 1);
	}
}
