package net.mcreator.survivalreimagined.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.survivalreimagined.procedures.ParanoiaOnEffectActiveTickProcedure;
import net.mcreator.survivalreimagined.procedures.ParanoiaEffectStartedappliedProcedure;

public class ParanoiaMobEffect extends MobEffect {
	public ParanoiaMobEffect() {
		super(MobEffectCategory.HARMFUL, -13884123);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ParanoiaEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ParanoiaOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}