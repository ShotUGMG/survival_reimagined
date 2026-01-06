package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class RadiationOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("survival_reimagined:radiation_damage")))), 4);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:radiation/damage")), SoundSource.HOSTILE, (float) 0.8, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:radiation/damage")), SoundSource.HOSTILE, (float) 0.8, 1, false);
			}
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}