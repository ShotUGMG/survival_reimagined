package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StatusEffectsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 6 && (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Peckish"), true);
			} else if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 4 && (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Famished"), true);
			} else if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 2 && (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 0) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Starving"), true);
				if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity10.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.05);
			} else if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) == 0) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Dying"), true);
			}
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 2) {
				if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity14.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
			}
		}
	}
}
