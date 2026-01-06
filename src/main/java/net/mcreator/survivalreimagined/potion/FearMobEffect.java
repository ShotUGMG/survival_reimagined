package net.mcreator.survivalreimagined.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.survivalreimagined.procedures.FearEffectStartedappliedProcedure;
import net.mcreator.survivalreimagined.procedures.FearEffectAppliedProcedure;

public class FearMobEffect extends MobEffect {
	public FearMobEffect() {
		super(MobEffectCategory.HARMFUL, -14803940);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		FearEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		FearEffectAppliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}