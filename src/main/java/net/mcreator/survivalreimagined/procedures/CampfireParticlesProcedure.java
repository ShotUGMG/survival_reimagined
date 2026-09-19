package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class CampfireParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.HAY_BLOCK) {
				for (int index136 = 0; index136 < 3; index136++) {
					world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + 0.5), (y + Mth.nextDouble(RandomSource.create(), 0.5, 0.7)), (z + 0.5), 0, 0.075, 0);
				}
			} else {
				for (int index137 = 0; index137 < 3; index137++) {
					world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + Mth.nextDouble(RandomSource.create(), 0.5, 0.7)), (z + 0.5), 0, 0.075, 0);
				}
			}
			if (Math.random() < 0.3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + 0.5, y, z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.campfire.crackle")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound((x + 0.5), y, (z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.campfire.crackle")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}