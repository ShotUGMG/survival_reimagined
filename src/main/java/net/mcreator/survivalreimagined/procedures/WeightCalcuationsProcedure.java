package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WeightCalcuationsProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedConfigConfiguration.WEIGHT.get() == true) {
			if ((getEntityGameType(entity) == GameType.SURVIVAL) == true) {
				if ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity2.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.085) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/gold")))) {
						if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity6.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity5.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/gold")))) {
						if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity10.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity9.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/gold")))) {
						if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity14.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity13.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/gold")))) {
						if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity18.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity17.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
				}
				if ((entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity20.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.085) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/bronze")))) {
						if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity24.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity23.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/bronze")))) {
						if (entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity28.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity27.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/bronze")))) {
						if (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity32.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity31 && _livingEntity31.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity31.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/bronze")))) {
						if (entity instanceof LivingEntity _livingEntity36 && _livingEntity36.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity36.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity35 && _livingEntity35.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity35.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
				}
				if ((entity instanceof LivingEntity _livingEntity38 && _livingEntity38.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity38.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.085) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/iron")))) {
						if (entity instanceof LivingEntity _livingEntity42 && _livingEntity42.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity42.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity41.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/iron")))) {
						if (entity instanceof LivingEntity _livingEntity46 && _livingEntity46.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity46.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity45 && _livingEntity45.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity45.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/iron")))) {
						if (entity instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity50.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity49.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/iron")))) {
						if (entity instanceof LivingEntity _livingEntity54 && _livingEntity54.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity54.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity53.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00375));
					}
				}
				if ((entity instanceof LivingEntity _livingEntity56 && _livingEntity56.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity56.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.0825) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/steel")))) {
						if (entity instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity60.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity59 && _livingEntity59.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity59.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
											- 0.004375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/steel")))) {
						if (entity instanceof LivingEntity _livingEntity64 && _livingEntity64.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity64.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity63 && _livingEntity63.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity63.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
											- 0.004375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/steel")))) {
						if (entity instanceof LivingEntity _livingEntity68 && _livingEntity68.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity68.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity67 && _livingEntity67.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity67.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
											- 0.004375));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/steel")))) {
						if (entity instanceof LivingEntity _livingEntity72 && _livingEntity72.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity72.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity71 && _livingEntity71.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity71.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
											- 0.004375));
					}
				}
				if ((entity instanceof LivingEntity _livingEntity74 && _livingEntity74.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity74.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.08) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/diamond")))) {
						if (entity instanceof LivingEntity _livingEntity78 && _livingEntity78.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity78.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity77 && _livingEntity77.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity77.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.005));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/diamond")))) {
						if (entity instanceof LivingEntity _livingEntity82 && _livingEntity82.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity82.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity81 && _livingEntity81.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity81.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.005));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/diamond")))) {
						if (entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity86.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity85 && _livingEntity85.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity85.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.005));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/diamond")))) {
						if (entity instanceof LivingEntity _livingEntity90 && _livingEntity90.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity90.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity89.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.005));
					}
				}
				if ((entity instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity92.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.075) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/netherite")))) {
						if (entity instanceof LivingEntity _livingEntity96 && _livingEntity96.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity96.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity95 && _livingEntity95.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity95.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00625));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/netherite")))) {
						if (entity instanceof LivingEntity _livingEntity100 && _livingEntity100.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity100.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity99 && _livingEntity99.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity99.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.00625));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/netherite")))) {
						if (entity instanceof LivingEntity _livingEntity104 && _livingEntity104.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity104.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity103 && _livingEntity103.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity103.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
											- 0.00625));
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:armor/netherite")))) {
						if (entity instanceof LivingEntity _livingEntity108 && _livingEntity108.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity108.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
									((entity instanceof LivingEntity _livingEntity107 && _livingEntity107.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity107.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
											- 0.00625));
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