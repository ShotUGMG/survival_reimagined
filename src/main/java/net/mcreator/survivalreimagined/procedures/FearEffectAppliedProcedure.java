package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class FearEffectAppliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.005) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -10, 10), y + Mth.nextDouble(RandomSource.create(), -10, 10), z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_shrieker.shriek")), SoundSource.BLOCKS, 1, (float) 0.8);
				} else {
					_level.playLocalSound((x + Mth.nextDouble(RandomSource.create(), -10, 10)), (y + Mth.nextDouble(RandomSource.create(), -10, 10)), (z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_shrieker.shriek")), SoundSource.BLOCKS, 1, (float) 0.8, false);
				}
			}
		} else if (Math.random() < 0.005) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -10, 10), y + Mth.nextDouble(RandomSource.create(), -10, 10), z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.creeper.primed")), SoundSource.BLOCKS, 1, (float) 0.9);
				} else {
					_level.playLocalSound((x + Mth.nextDouble(RandomSource.create(), -10, 10)), (y + Mth.nextDouble(RandomSource.create(), -10, 10)), (z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.creeper.primed")), SoundSource.BLOCKS, 1, (float) 0.9, false);
				}
			}
		} else if (Math.random() < 0.0025) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -10, 10), y + Mth.nextDouble(RandomSource.create(), -10, 10), z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:player_digging.stone")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound((x + Mth.nextDouble(RandomSource.create(), -10, 10)), (y + Mth.nextDouble(RandomSource.create(), -10, 10)), (z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:player_digging.stone")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		} else if (Math.random() < 0.005) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -10, 10), y + Mth.nextDouble(RandomSource.create(), -10, 10), z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound((x + Mth.nextDouble(RandomSource.create(), -10, 10)), (y + Mth.nextDouble(RandomSource.create(), -10, 10)), (z + Mth.nextDouble(RandomSource.create(), -10, 10)),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
		} else if (SurvivalReimaginedModVariables.WorldVariables.get(world).HeartBeat == 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.heartbeat")), SoundSource.PLAYERS, 2, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.heartbeat")), SoundSource.PLAYERS, 2, (float) 0.8, false);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("survival_reimagined:fear_damage")))), 4);
		}
		entity.getPersistentData().putDouble("EffectTick", (entity.getPersistentData().getDouble("EffectTick") + 1));
	}
}
