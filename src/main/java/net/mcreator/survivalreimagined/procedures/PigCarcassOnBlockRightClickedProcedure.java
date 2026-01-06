package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class PigCarcassOnBlockRightClickedProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:tools/saw")))
				&& (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 0) {
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (getEntityGameType(entity) == GameType.SURVIVAL) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
			});
			if (Math.random() < 0.1) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(SurvivalReimaginedModBlocks.PIG_CARCASS.get().defaultBlockState()));
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.place")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.place")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:animal_amputation"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					for (int index0 = 0; index0 < 4; index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModBlocks.PIG_LEG.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				});
			}
			return InteractionResult.SUCCESS;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:tools/saw")))
				&& (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip20 ? blockstate.getValue(_getip20) : -1) == 1) {
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (getEntityGameType(entity) == GameType.SURVIVAL) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
			});
			if (Math.random() < 0.1) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(SurvivalReimaginedModBlocks.PIG_CARCASS.get().defaultBlockState()));
					{
						int _value = 2;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.place")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.place")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModBlocks.PIG_HEAD.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				});
			}
			return InteractionResult.SUCCESS;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:tools/knife")))
				&& (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip36 ? blockstate.getValue(_getip36) : -1) == 2) {
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (getEntityGameType(entity) == GameType.SURVIVAL) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
			});
			if (Math.random() < 0.1) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(SurvivalReimaginedModBlocks.PIG_CARCASS.get().defaultBlockState()));
					{
						int _value = 3;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.place")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.place")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(Items.PORKCHOP));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModItems.HEART_ITEM.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModItems.STOMACH.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModItems.LUNGS.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModItems.LIVER.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(SurvivalReimaginedModItems.INTESTINES.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:animal_guts"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
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