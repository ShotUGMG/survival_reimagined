package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

public class HeartItemUsedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == SurvivalReimaginedModItems.RUBY_HEART.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 40) {
				if ((entity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(itemstack.getItem())) == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.PLAYERS, (float) 0.2, (float) 1.3);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.PLAYERS, (float) 0.2, (float) 1.3, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, (float) 0.6, (float) 1.2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, (float) 0.6, (float) 1.2, false);
						}
					}
					if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity8.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 2));
					if (itemstack.getItem() == SurvivalReimaginedModItems.RUBY_HEART.get()) {
						itemstack.shrink(1);
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
						if (world.isClientSide()) {
							if (world.isClientSide())
								Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(SurvivalReimaginedModItems.RUBY_HEART.get()));
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:ruby_heart_adv"));
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
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Max Health Reached"), true);
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:max_health"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.GOLD_HEART.get()) {
			if (SurvivalReimaginedConfigConfiguration.IMMUNITY_ZOMBIFICATION.get() == true) {
				if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).ZombificationImmune == false) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are now Immune to Zombification"), true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.PLAYERS, (float) 0.2, (float) 1.3);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.PLAYERS, (float) 0.2, (float) 1.3, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, (float) 0.6, (float) 1.2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, (float) 0.6, (float) 1.2, false);
						}
					}
					if (world.isClientSide()) {
						if (world.isClientSide())
							Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(SurvivalReimaginedModItems.GOLD_HEART.get()));
					}
					itemstack.shrink(1);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.ZombificationImmune = true;
						_vars.markSyncDirty();
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:zombification_immunity"));
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
	}
}