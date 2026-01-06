package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class AAFScriptureGUIThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_leather")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_leather")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.PLAYERS, (float) 0.8, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.PLAYERS, (float) 0.8, 1, false);
			}
		}
		if (entity.getPersistentData().getDouble("PageNumber") == 0) {
			entity.getPersistentData().putDouble("PageNumber", 1);
		}
	}
}