package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class GasMaskHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GaskMaskDamage == 0) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.GaskMaskDamage = 200;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GaskMaskDamage <= 200) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.GaskMaskDamage = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GaskMaskDamage - 1;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GasMaskHeal == 0) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.GasMaskHeal = 20;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GasMaskHeal <= 20) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.GasMaskHeal = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GasMaskHeal - 1;
				_vars.markSyncDirty();
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("survival_reimagined:radiated_forest"))) {
			if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("survival_reimagined:perpetual_filtering")))) != 0) {
				if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GasMaskHeal == 0) {
					if (itemstack.getDamageValue() != 0) {
						itemstack.setDamageValue(itemstack.getDamageValue() - 10);
						if (world.isClientSide()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:filter_mends")), SoundSource.MASTER, (float) 0.3, (float) 1.5);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:filter_mends")), SoundSource.MASTER, (float) 0.3, (float) 1.5, false);
								}
							}
						}
					}
				}
			}
			if (itemstack.getDamageValue() < 119) {
				if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GaskMaskDamage == 0) {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
					if (world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:gas_mask_breath")), SoundSource.MASTER, (float) 0.8, (float) 0.8);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:gas_mask_breath")), SoundSource.MASTER, (float) 0.8, (float) 0.8, false);
							}
						}
					}
				}
			}
		}
		if (itemstack.getDamageValue() == 119) {
			itemstack.setDamageValue(120);
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.USED_FILTER.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		}
	}
}