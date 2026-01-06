package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ApplyRadiationProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDamageValue() == 119) {
			if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(ResourceLocation.parse("survival_reimagined:radiated_forest"))) {
				if (entity instanceof Player) {
					if (getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE) {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(SurvivalReimaginedModMobEffects.RADIATION) ? _livEnt.getEffect(SurvivalReimaginedModMobEffects.RADIATION).getDuration() : 0) == 1
								^ !(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(SurvivalReimaginedModMobEffects.RADIATION))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.RADIATION, 60, (int) 0.1, true, false));
						}
					}
				}
			}
		}
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(ResourceLocation.parse("survival_reimagined:radiated_forest"))) {
			if (entity instanceof Slime || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:undead")))) {
				if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(SurvivalReimaginedModMobEffects.RADIATION)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(SurvivalReimaginedModMobEffects.RADIATION);
				}
			} else {
				if (!(entity instanceof Player)) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(SurvivalReimaginedModMobEffects.RADIATION) ? _livEnt.getEffect(SurvivalReimaginedModMobEffects.RADIATION).getDuration() : 0) == 1
							^ !(entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(SurvivalReimaginedModMobEffects.RADIATION))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(SurvivalReimaginedModMobEffects.RADIATION, 60, (int) 0.1, true, false));
					}
				}
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