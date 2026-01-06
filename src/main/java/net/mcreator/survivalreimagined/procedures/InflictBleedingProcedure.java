package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InflictBleedingProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.BLEEDING_EFFECT.get() == true) {
			if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:blood_moon/spider")))) {
				if (Math.random() < (double) SurvivalReimaginedConfigConfiguration.BLEED_CHANCE.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.BLEEDING, 120, (int) 0.1, true, false));
				}
			}
		}
	}
}