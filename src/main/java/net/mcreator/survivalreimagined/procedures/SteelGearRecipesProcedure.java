package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class SteelGearRecipesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE
				.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_SWORD_BLADE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack6 = new ItemStack(SurvivalReimaginedModItems.STEEL_SWORD.get()).copy();
				_setstack6.setCount(1);
				_menu.getSlots().get(3).set(_setstack6);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_PICKAXE_HEAD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack13 = new ItemStack(SurvivalReimaginedModItems.STEEL_PICKAXE.get()).copy();
				_setstack13.setCount(1);
				_menu.getSlots().get(3).set(_setstack13);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_AXE_HEAD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack20 = new ItemStack(SurvivalReimaginedModItems.STEEL_AXE.get()).copy();
				_setstack20.setCount(1);
				_menu.getSlots().get(3).set(_setstack20);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_SHOVEL_HEAD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack27 = new ItemStack(SurvivalReimaginedModItems.STEEL_SHOVEL.get()).copy();
				_setstack27.setCount(1);
				_menu.getSlots().get(3).set(_setstack27);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_HOE_BLADE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack34 = new ItemStack(SurvivalReimaginedModItems.STEEL_HOE.get()).copy();
				_setstack34.setCount(1);
				_menu.getSlots().get(3).set(_setstack34);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_SAW_BLADE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack41 = new ItemStack(SurvivalReimaginedModItems.STEEL_SAW.get()).copy();
				_setstack41.setCount(1);
				_menu.getSlots().get(3).set(_setstack41);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_HAMMER_HEAD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack48 = new ItemStack(SurvivalReimaginedModItems.STEEL_HAMMER.get()).copy();
				_setstack48.setCount(1);
				_menu.getSlots().get(3).set(_setstack48);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.SMALL_BRONZE_HANDLE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == SurvivalReimaginedModItems.STEEL_KNIFE_BLADE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack55 = new ItemStack(SurvivalReimaginedModItems.STEEL_KNIFE.get()).copy();
				_setstack55.setCount(1);
				_menu.getSlots().get(3).set(_setstack55);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}