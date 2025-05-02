package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MeatSpoiledProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).SpoilTimer == 1600) {
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.BEEF)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_BEEF.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.BEEF);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.COOKED_BEEF)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_BEEF.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_BEEF);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.PORKCHOP)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_PORKCHOP.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.PORKCHOP);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.COOKED_PORKCHOP)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_PORKCHOP.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_PORKCHOP);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.CHICKEN)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_CHICKEN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.CHICKEN);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.COOKED_CHICKEN)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_CHICKEN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_CHICKEN);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.MUTTON)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_MUTTON.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.MUTTON);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.COOKED_MUTTON)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_MUTTON.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_MUTTON);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.RABBIT)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_RABBIT.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.RABBIT);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.COOKED_RABBIT)) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_RABBIT.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_RABBIT);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.BRAIN.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_BRAIN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.BRAIN.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.COOKED_BRAIN.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_BRAIN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.COOKED_BRAIN.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.HEART_ITEM.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_HEART.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.HEART_ITEM.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.COOKED_HEART.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_HEART.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.COOKED_HEART.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.LIVER.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_LIVER.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.LIVER.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.COOKED_LIVER.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_LIVER.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.COOKED_LIVER.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.INTESTINES.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_INTESTINES.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.INTESTINES.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.COOKED_INTESTINES.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_INTESTINES.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.COOKED_INTESTINES.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.STOMACH.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_STOMACH.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.STOMACH.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.COOKED_STOMACH.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_STOMACH.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.COOKED_STOMACH.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
			if (Math.random() < 0.075) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.LUNGS.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_LUNGS.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.LUNGS.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SurvivalReimaginedModItems.COOKED_LUNGS.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.SPOILED_LUNGS.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SurvivalReimaginedModItems.COOKED_LUNGS.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					});
				}
			}
		}
	}
}
