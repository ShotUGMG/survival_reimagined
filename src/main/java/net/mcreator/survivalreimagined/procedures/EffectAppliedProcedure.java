package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EffectAppliedProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.DARKNESS_EFFECTS.get() == true) {
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof Player && world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY() + 0.2, entity.getZ())) == (double) SurvivalReimaginedConfigConfiguration.DARKNESS_LEVEL.get()
						&& ((ModList.get().isLoaded("dynamiclights") || ModList.get().isLoaded("lambdynlights"))
								&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:dynlights/light")))
										|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:dynlights/light"))))) == false) {
					if (entity.getPersistentData().getDouble("EffectTick") < (double) SurvivalReimaginedConfigConfiguration.PARANOIA_DELAY.get()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.PARANOIA, 60, 0, true, false));
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:paranoia_adv"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					} else if (entity.getPersistentData().getDouble("EffectApplied") == 2 && entity.getPersistentData().getDouble("EffectTick") >= (double) SurvivalReimaginedConfigConfiguration.PARANOIA_DELAY.get()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.FEAR, 60, 0, true, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(SurvivalReimaginedModMobEffects.PARANOIA);
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:fear_adv"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
					if (entity.getPersistentData().getDouble("EffectTick") >= (double) SurvivalReimaginedConfigConfiguration.PARANOIA_DELAY.get()) {
						entity.getPersistentData().putDouble("EffectApplied", 2);
					}
				} else if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) >= (double) SurvivalReimaginedConfigConfiguration.LIGHT_LEVEL.get()) {
					entity.getPersistentData().putDouble("EffectTick", 0);
				}
			}
		}
	}
}
