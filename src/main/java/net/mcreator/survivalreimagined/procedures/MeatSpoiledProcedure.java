package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class MeatSpoiledProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Beef = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/beef"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Beef) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Beef;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_BEEF.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Beef = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Pork = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/pork"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Pork) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Pork;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_PORKCHOP.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Pork = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Mutton = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/mutton"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Mutton) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Mutton;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_MUTTON.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Mutton = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Chicken = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/chicken"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Mutton) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Chicken;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_CHICKEN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Chicken = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Rabbit = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/rabbit"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Rabbit) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Rabbit;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_RABBIT.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Rabbit = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Cod = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/cod"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
						.copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Cod) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Cod;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_COD.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Cod = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Salmon = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/salmon"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Salmon) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Salmon;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_SALMAN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Salmon = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Brain = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/brain"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Brain) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Brain;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_BRAIN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Brain = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Heart = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/heart"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Heart) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Heart;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_HEART.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Heart = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Lungs = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/lungs"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Lungs) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Lungs;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_LUNGS.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Lungs = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Intestines = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/intestines"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Intestines) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Intestines;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_INTESTINES.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Intestines = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Liver = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/liver"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Liver) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Liver;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_INTESTINES.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Liver = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
		if (Math.random() < 0.1) {
			{
				SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
				_vars.Stomach = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:meat/stomach"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Stomach) : false) {
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Stomach;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_INTESTINES.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Stomach = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:bad_meat"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				});
			}
		}
	}
}
