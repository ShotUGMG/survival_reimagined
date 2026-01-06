package net.mcreator.survivalreimagined.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.survivalreimagined.procedures.RadiationOnEffectActiveTickProcedure;
import net.mcreator.survivalreimagined.procedures.RadiationEffectStartedappliedProcedure;
import net.mcreator.survivalreimagined.procedures.RadiationActiveTickConditionProcedure;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;

@EventBusSubscriber
public class RadiationMobEffect extends MobEffect {
	public RadiationMobEffect() {
		super(MobEffectCategory.HARMFUL, -5258644);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		RadiationEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return RadiationActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		RadiationOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, SurvivalReimaginedModMobEffects.RADIATION.get());
	}
}