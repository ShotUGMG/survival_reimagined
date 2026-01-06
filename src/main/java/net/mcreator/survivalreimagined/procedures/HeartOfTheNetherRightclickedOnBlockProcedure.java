package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class HeartOfTheNetherRightclickedOnBlockProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OBSIDIAN && world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.FIRE.defaultBlockState(), 3);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.NETHER_PORTAL) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:portal_open")), SoundSource.AMBIENT, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:portal_open")), SoundSource.AMBIENT, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.ambient")), SoundSource.AMBIENT, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.ambient")), SoundSource.AMBIENT, 1, 1, false);
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.AMBIENT, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.AMBIENT, 1, 1, false);
					}
				}
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:nether_heart"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			});
			if (getEntityGameType(entity) == GameType.SURVIVAL) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.HEART_OF_THE_NETHER.get()) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount(0);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.HEART_OF_THE_NETHER.get()) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setCount(0);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
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