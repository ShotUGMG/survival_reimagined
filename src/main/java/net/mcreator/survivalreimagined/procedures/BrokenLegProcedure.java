package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BrokenLegProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.BROKEN_LEGS.get() == true) {
			if (entity.fallDistance >= 5) {
				if (Math.random() < (double) SurvivalReimaginedConfigConfiguration.BROKEN_LEG_CHANCE.get()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You have broken a leg"), true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.BROKEN_LEG_POTION, 2400, (int) 0.1, false, false));
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")), SoundSource.PLAYERS, (float) 0.5,
										1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")), SoundSource.PLAYERS, (float) 0.5, 1, false);
							}
						}
					});
				}
			}
		}
	}
}