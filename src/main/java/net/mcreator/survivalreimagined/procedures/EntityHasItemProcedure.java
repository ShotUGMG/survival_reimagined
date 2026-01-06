package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityHasItemProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double NumGen = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:zombies"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:skeletons")))
				|| entity instanceof Piglin || entity instanceof PiglinBrute) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getCount() == 1) {
				NumGen = Mth.nextInt(RandomSource.create(), 1, 5);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
						.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getMaxDamage() - NumGen));
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, ItemStack.EMPTY);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
					}
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getCount() == 1) {
				NumGen = Mth.nextInt(RandomSource.create(), 1, 5);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getMaxDamage() - NumGen));
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, ItemStack.EMPTY);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
					}
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getCount() == 1) {
				NumGen = Mth.nextInt(RandomSource.create(), 1, 5);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
						.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getMaxDamage() - NumGen));
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, ItemStack.EMPTY);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
					}
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getCount() == 1) {
				NumGen = Mth.nextInt(RandomSource.create(), 1, 5);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
						.setDamageValue((int) ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getMaxDamage() - NumGen));
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, ItemStack.EMPTY);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() == 1) {
				NumGen = Mth.nextInt(RandomSource.create(), 1, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getMaxDamage() - NumGen));
				if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.TRIDENT) == false) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack60 = ItemStack.EMPTY.copy();
						_setstack60.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack60);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() == 1) {
				NumGen = Mth.nextInt(RandomSource.create(), 1, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setDamageValue((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getMaxDamage() - NumGen));
				if (((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.TRIDENT) == false) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack73 = ItemStack.EMPTY.copy();
						_setstack73.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack73);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			}
		}
	}
}