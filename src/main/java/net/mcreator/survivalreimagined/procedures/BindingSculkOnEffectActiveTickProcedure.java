package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class BindingSculkOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.PLAYERS, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.PLAYERS, 2, 1, false);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("survival_reimagined:binding_sculk_damage")))), 2);
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		} else {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("survival_reimagined:binding_sculk_damage")))), 2);
			entity.setDeltaMovement(new Vec3(0, 0, 0));
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