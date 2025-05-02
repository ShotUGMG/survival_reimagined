
package net.mcreator.survivalreimagined.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.survivalreimagined.procedures.BindingSculkOnEffectActiveTickProcedure;
import net.mcreator.survivalreimagined.procedures.BindingSculkEffectStartedappliedProcedure;
import net.mcreator.survivalreimagined.procedures.BindingSculkActiveTickConditionProcedure;

import java.util.Set;

public class BindingSculkMobEffect extends MobEffect {
	public BindingSculkMobEffect() {
		super(MobEffectCategory.HARMFUL, -16563888);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		BindingSculkEffectStartedappliedProcedure.execute(entity.level());
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return BindingSculkActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BindingSculkOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
