package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BloodMoonAnnouncementProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon == true && SurvivalReimaginedModVariables.WorldVariables.get(world).AnnouncementPlayed == false) {
			SurvivalReimaginedModVariables.WorldVariables.get(world).AnnouncementPlayed = true;
			SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
			SurvivalReimaginedMod.queueServerWork(20, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74The Bloodmoon is Rising...."), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.MASTER, 1, 1, false);
					}
				}
			});
		} else if (SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon == false && world instanceof Level _lvl3 && _lvl3.isDay()) {
			SurvivalReimaginedModVariables.WorldVariables.get(world).AnnouncementPlayed = false;
			SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
