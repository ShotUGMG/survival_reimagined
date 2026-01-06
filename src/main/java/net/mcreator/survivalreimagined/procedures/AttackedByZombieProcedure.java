package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AttackedByZombieProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.ZOMBIFICATION.get() == true) {
			if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).ZombificationImmune == false) {
				if ((entity instanceof LivingEntity _livEnt1 && _livEnt1.isBlocking()) == false) {
					if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:zombies")))
							|| sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(SurvivalReimaginedModMobEffects.ZOMBIFICATION)) {
						if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(SurvivalReimaginedModMobEffects.ZOMBIFICATION))) {
							if (Math.random() < (double) SurvivalReimaginedConfigConfiguration.CHANCE_ZOMBIFICATION.get()) {
								SurvivalReimaginedModVariables.WorldVariables.get(world).EffectDanger = 0;
								SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.ZOMBIFICATION, (int) (double) SurvivalReimaginedConfigConfiguration.TIME_ZOMBIFICATION.get(), 0, true, false));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.PLAYERS, 1, 1, false);
									}
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:zombification_adv"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
				}
			}
		}
	}
}