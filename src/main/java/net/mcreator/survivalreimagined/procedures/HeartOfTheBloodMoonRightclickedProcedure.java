package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class HeartOfTheBloodMoonRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
			SurvivalReimaginedModVariables.MapVariables.get(world).AnnouncementPlayed = true;
			SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = true;
			SurvivalReimaginedModVariables.MapVariables.get(world).markSyncDirty();
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74Heart Of The Bloodmoons essence is released into the air, forcing a BloodMoon"), false);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.HEART_OF_THE_BLOOD_MOON.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}