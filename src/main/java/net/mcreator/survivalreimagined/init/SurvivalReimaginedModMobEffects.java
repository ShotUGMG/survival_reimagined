
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.procedures.ZombificationEffectExpiresProcedure;
import net.mcreator.survivalreimagined.potion.ZombificationMobEffect;
import net.mcreator.survivalreimagined.potion.ParanoiaMobEffect;
import net.mcreator.survivalreimagined.potion.FearMobEffect;
import net.mcreator.survivalreimagined.potion.BindingSculkMobEffect;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber
public class SurvivalReimaginedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> PARANOIA = REGISTRY.register("paranoia", () -> new ParanoiaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FEAR = REGISTRY.register("fear", () -> new FearMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ZOMBIFICATION = REGISTRY.register("zombification", () -> new ZombificationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BINDING_SCULK = REGISTRY.register("binding_sculk", () -> new BindingSculkMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(ZOMBIFICATION)) {
			ZombificationEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}
}
