package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class ClayMoldClientTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("can_burn") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			world.addParticle(ParticleTypes.WHITE_SMOKE, (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 0.25)), (z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0, 0.0025, 0);
			if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.LAVA) {
				world.addParticle(ParticleTypes.SMOKE, (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 0.25)), (z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0, 0.0025, 0);
			}
		}
	}
}
