package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class RunesMPTProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.SAPPHIRE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_SILVER_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack6 = new ItemStack(SurvivalReimaginedModItems.SAPPHIRE_SILVER_RUNE.get()).copy();
						_setstack6.setCount(1);
						_menu.getSlots().get(3).set(_setstack6);
						_player.containerMenu.broadcastChanges();
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_GOLD_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack9 = new ItemStack(SurvivalReimaginedModItems.SAPPHIRE_GOLD_RUNE.get()).copy();
						_setstack9.setCount(1);
						_menu.getSlots().get(3).set(_setstack9);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == SurvivalReimaginedModItems.AMBER.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_SILVER_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack14 = new ItemStack(SurvivalReimaginedModItems.SILVER_AMBER_RUNE.get()).copy();
						_setstack14.setCount(1);
						_menu.getSlots().get(3).set(_setstack14);
						_player.containerMenu.broadcastChanges();
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_GOLD_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack17 = new ItemStack(SurvivalReimaginedModItems.GOLD_AMBER_RUNE.get()).copy();
						_setstack17.setCount(1);
						_menu.getSlots().get(3).set(_setstack17);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_SILVER_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack22 = new ItemStack(SurvivalReimaginedModItems.SILVER_DIAMOND_RUNE.get()).copy();
						_setstack22.setCount(1);
						_menu.getSlots().get(3).set(_setstack22);
						_player.containerMenu.broadcastChanges();
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_GOLD_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack25 = new ItemStack(SurvivalReimaginedModItems.GOLD_DIAMOND_RUNE.get()).copy();
						_setstack25.setCount(1);
						_menu.getSlots().get(3).set(_setstack25);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.EMERALD) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_SILVER_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack30 = new ItemStack(SurvivalReimaginedModItems.SILVER_EMERALD_RUNE.get()).copy();
						_setstack30.setCount(1);
						_menu.getSlots().get(3).set(_setstack30);
						_player.containerMenu.broadcastChanges();
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_GOLD_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack33 = new ItemStack(SurvivalReimaginedModItems.GOLD_EMERALD_RUNE.get()).copy();
						_setstack33.setCount(1);
						_menu.getSlots().get(3).set(_setstack33);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == SurvivalReimaginedModItems.RUBY.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_SILVER_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack38 = new ItemStack(SurvivalReimaginedModItems.SILVER_RUBY_RUNE.get()).copy();
						_setstack38.setCount(1);
						_menu.getSlots().get(3).set(_setstack38);
						_player.containerMenu.broadcastChanges();
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_GOLD_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack41 = new ItemStack(SurvivalReimaginedModItems.GOLD_RUBY_RUNE.get()).copy();
						_setstack41.setCount(1);
						_menu.getSlots().get(3).set(_setstack41);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.LAPIS_LAZULI) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_SILVER_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack46 = new ItemStack(SurvivalReimaginedModItems.SILVER_LAPIS_RUNE.get()).copy();
						_setstack46.setCount(1);
						_menu.getSlots().get(3).set(_setstack46);
						_player.containerMenu.broadcastChanges();
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.EMPTY_GOLD_RUNE.get()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
						ItemStack _setstack49 = new ItemStack(SurvivalReimaginedModItems.GOLD_LAPIS_RUNE.get()).copy();
						_setstack49.setCount(1);
						_menu.getSlots().get(3).set(_setstack49);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}