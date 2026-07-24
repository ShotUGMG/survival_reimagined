package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.survivalreimagined.network.PlayPlayerAnimationMessage;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CarcassHoldAnimationProcedure {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:carcasses")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:carcasses")))) {
			if (entity instanceof Player) {
				if (entity.level().isClientSide()) {
					CompoundTag data = entity.getPersistentData();
					data.putString("PlayerCurrentAnimation", "survival_reimagined:carcass.model.new");
					data.putBoolean("OverrideCurrentAnimation", false);
					data.putBoolean("FirstPersonAnimation", false);
				} else {
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "survival_reimagined:carcass.model.new", false, false));
				}
			}
		} else {
			if ((entity instanceof Player ? entity.getPersistentData().getString("PlayerCurrentAnimation").equals("survival_reimagined:carcass.model.new") : false) == true) {
				if (entity instanceof Player) {
					if (entity.level().isClientSide()) {
						CompoundTag data = entity.getPersistentData();
						data.remove("PlayerCurrentAnimation");
						data.remove("PlayerAnimationProgress");
						data.putBoolean("ResetPlayerAnimation", true);
						data.putBoolean("FirstPersonAnimation", false);
					} else {
						PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "", false, false));
					}
				}
			}
		}
	}
}