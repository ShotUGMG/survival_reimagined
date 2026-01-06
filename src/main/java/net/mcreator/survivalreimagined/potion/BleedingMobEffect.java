package net.mcreator.survivalreimagined.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.survivalreimagined.procedures.BleedingOnEffectActiveTickProcedure;
import net.mcreator.survivalreimagined.procedures.BleedingEffectStartedappliedProcedure;
import net.mcreator.survivalreimagined.procedures.BleedingActiveTickConditionProcedure;

public class BleedingMobEffect extends MobEffect {
	public BleedingMobEffect() {
		super(MobEffectCategory.HARMFUL, -2935242);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		BleedingEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return BleedingActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BleedingOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}