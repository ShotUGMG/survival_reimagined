package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WeightCalcuationsProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.WEIGHT.get() == true) {
			if (entity instanceof Player) {
				if (getEntityGameType(entity) == GameType.SURVIVAL) {
					entity.getPersistentData().putDouble("StackCount", 0);
					entity.getPersistentData().putDouble("ItemsMedium", 0);
					entity.getPersistentData().putDouble("StackSizeConverter", 0);
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
						for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
							ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
							if (!(itemstackiterator.getItem() == ItemStack.EMPTY.getItem())) {
								entity.getPersistentData().putDouble("ItemsMedium", (entity.getPersistentData().getDouble("ItemsMedium") + itemstackiterator.getCount()));
								entity.getPersistentData().putDouble("StackCount", (entity.getPersistentData().getDouble("StackCount") + 1));
							}
						}
					}
					if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("StackCount"))).length() == 1) {
						entity.getPersistentData().putDouble("StackSizeConverterJump", (entity.getPersistentData().getDouble("StackCount") / 100));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("StackCount"))).length() == 2) {
						entity.getPersistentData().putDouble("StackSizeConverterJump", (entity.getPersistentData().getDouble("StackCount") / 100));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("StackCount"))).length() == 3) {
						entity.getPersistentData().putDouble("StackSizeConverterJump", (entity.getPersistentData().getDouble("StackCount") / 1000));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("StackCount"))).length() == 4) {
						entity.getPersistentData().putDouble("StackSizeConverterJump", (entity.getPersistentData().getDouble("StackCount") / 10000));
					}
					if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 1) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 100));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 2) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 1000));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 3) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 10000));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 4) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 100000));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 5) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 1000000));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 6) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 10000000));
					} else if ((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("ItemsMedium"))).length() == 7) {
						entity.getPersistentData().putDouble("StackSizeConverter", (entity.getPersistentData().getDouble("ItemsMedium") / 100000000));
					}
					if (entity.getPersistentData().getDouble("ItemsMedium") >= 192 && entity.getPersistentData().getDouble("StackCount") < 16) {
						if (entity instanceof LivingEntity _livingEntity54 && _livingEntity54.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity54.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((0.1 - entity.getPersistentData().getDouble("StackSizeConverter")));
					} else if (entity.getPersistentData().getDouble("ItemsMedium") >= 960 && entity.getPersistentData().getDouble("StackCount") >= 16) {
						if (entity instanceof LivingEntity _livingEntity57 && _livingEntity57.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity57.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
					} else {
						if ((entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(SurvivalReimaginedModMobEffects.BROKEN_LEG_POTION)) == false) {
							if (entity instanceof LivingEntity _livingEntity59 && _livingEntity59.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
								_livingEntity59.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
						}
					}
					if (entity.getPersistentData().getDouble("ItemsMedium") >= 384 && entity.getPersistentData().getDouble("StackCount") < 16) {
						if (entity instanceof LivingEntity _livingEntity63 && _livingEntity63.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
							_livingEntity63.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue((0.4 - entity.getPersistentData().getDouble("StackSizeConverterJump")));
					} else if (entity.getPersistentData().getDouble("ItemsMedium") >= 576 && entity.getPersistentData().getDouble("StackCount") >= 9) {
						if (entity instanceof LivingEntity _livingEntity66 && _livingEntity66.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
							_livingEntity66.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0);
					} else {
						if (entity instanceof LivingEntity _livingEntity67 && _livingEntity67.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
							_livingEntity67.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.4);
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt69 && _livEnt69.hasEffect(SurvivalReimaginedModMobEffects.BROKEN_LEG_POTION)) == false) {
						if (entity instanceof LivingEntity _livingEntity70 && _livingEntity70.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity70.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
					}
					if (entity instanceof LivingEntity _livingEntity71 && _livingEntity71.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
						_livingEntity71.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.4);
				}
				if (((entity instanceof LivingEntity _livingEntity80 && _livingEntity80.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity80.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)) > (0.05)
						&& ((entity instanceof LivingEntity _livingEntity80 && _livingEntity80.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity80.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)) < (0.1)) {
					if (entity.getPersistentData().getBoolean("Anvil1Played") == false) {
						entity.getPersistentData().putBoolean("Anvil1Played", true);
						SurvivalReimaginedMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, (float) 0.6, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, (float) 0.6, 1, false);
								}
							}
						});
					}
				} else if (((entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity86.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)) > (0)
						&& ((entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity86.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)) < (0.05)) {
					if (entity.getPersistentData().getBoolean("Anvil2Played") == false) {
						entity.getPersistentData().putBoolean("Anvil2Played", true);
						SurvivalReimaginedMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, (float) 0.6, (float) 0.8);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, (float) 0.6, (float) 0.8, false);
								}
							}
						});
					}
				} else if ((entity instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity92.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) == 0) {
					if (entity.getPersistentData().getBoolean("Anvil3Played") == false) {
						entity.getPersistentData().putBoolean("Anvil3Played", true);
						SurvivalReimaginedMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, (float) 0.6, (float) 0.6);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, (float) 0.6, (float) 0.6, false);
								}
							}
						});
					}
				}
				if ((entity instanceof LivingEntity _livingEntity97 && _livingEntity97.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity97.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) >= 0.1) {
					entity.getPersistentData().putBoolean("Anvil1Played", false);
					entity.getPersistentData().putBoolean("Anvil2Played", false);
					entity.getPersistentData().putBoolean("Anvil3Played", false);
				}
			}
			if ((entity instanceof LivingEntity _livEnt102 && _livEnt102.hasEffect(SurvivalReimaginedModMobEffects.BROKEN_LEG_POTION)) == true) {
				if (entity.getPersistentData().getDouble("Clock") > 120) {
					if (entity.getPersistentData().getBoolean("SpeedChanged") == false) {
						if (entity instanceof LivingEntity _livingEntity105 && _livingEntity105.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity105.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.05);
						entity.getPersistentData().putBoolean("SpeedChanged", true);
					}
				} else {
					entity.getPersistentData().putBoolean("SpeedChanged", false);
				}
				if (entity.getPersistentData().getDouble("Clock") == 120) {
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FALL)), 2);
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					});
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}