package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

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
					if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("FilterPercentage") < 100) {
						{
							final String _tagName = "FilterPercentage";
							final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("FilterPercentage") + 1);
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
						}
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
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("FilterPercentage") > 0) {
				if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).GaskMaskDamage == 0) {
					{
						final String _tagName = "FilterPercentage";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("FilterPercentage") - 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
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
	}
}