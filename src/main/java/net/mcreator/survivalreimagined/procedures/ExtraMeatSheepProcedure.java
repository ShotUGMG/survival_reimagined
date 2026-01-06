package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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

import javax.annotation.Nullable;

@EventBusSubscriber
public class ExtraMeatSheepProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:tools/knife")))
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.SHEEP_LEG.get()) {
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (getEntityGameType(entity) == GameType.SURVIVAL) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (Math.random() < 0.1) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					for (int index0 = 0; index0 < 3; index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.MUTTON));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), 1, 2); index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
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
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:extra_animal_meat"));
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
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:tools/knife")))
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.SHEEP_HEAD.get()) {
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (getEntityGameType(entity) == GameType.SURVIVAL) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.mud.step")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (Math.random() < 0.1) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					for (int index2 = 0; index2 < 3; index2++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.MUTTON));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					for (int index3 = 0; index3 < 2; index3++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SurvivalReimaginedModItems.BRAIN.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
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
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:extra_animal_meat"));
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