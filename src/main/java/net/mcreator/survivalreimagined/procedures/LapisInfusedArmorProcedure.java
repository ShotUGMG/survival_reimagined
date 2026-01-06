package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LapisInfusedArmorProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean XPGiven = false;
		double SilverXP = 0;
		double GoldXP = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/armor")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/armor")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/armor")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true) {
			GoldXP = Math.round((entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0) / 4 + Mth.nextInt(RandomSource.create(), 4, 8));
			SilverXP = Math.round((entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0) / 6 + Mth.nextInt(RandomSource.create(), 2, 4));
			entity.getPersistentData().putDouble("XP", (entity.getPersistentData().getDouble("XP") + 1));
			if (entity.getPersistentData().getDouble("XP") == 99) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
					if (Math.random() < 0.1) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) GoldXP);
						XPGiven = true;
					}
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
					if (Math.random() < 0.1) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) GoldXP);
						XPGiven = true;
					}
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
					if (Math.random() < 0.1) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) GoldXP);
						XPGiven = true;
					}
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
					if (Math.random() < 0.1) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) SilverXP);
						XPGiven = true;
					}
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
					if (Math.random() < 0.05) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) SilverXP);
						XPGiven = true;
					}
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
					if (Math.random() < 0.05) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) SilverXP);
						XPGiven = true;
					}
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
					if (Math.random() < 0.05) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) SilverXP);
						XPGiven = true;
					}
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
					if (Math.random() < 0.05) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints((int) SilverXP);
						XPGiven = true;
					}
				}
			}
			if (entity.getPersistentData().getDouble("XP") >= 100) {
				entity.getPersistentData().putDouble("XP", 0);
			}
			if (XPGiven == true) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.5,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
					}
				}
				XPGiven = false;
			}
		}
	}
}