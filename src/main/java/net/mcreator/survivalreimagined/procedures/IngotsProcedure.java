package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class IngotsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.ROUGH_COPPER
				.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack4 = new ItemStack(Items.COPPER_INGOT).copy();
				_setstack4.setCount(1);
				_menu.getSlots().get(3).set(_setstack4);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.ROUGH_IRON.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack9 = new ItemStack(Items.IRON_INGOT).copy();
				_setstack9.setCount(1);
				_menu.getSlots().get(3).set(_setstack9);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.ROUGH_GOLD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack14 = new ItemStack(Items.GOLD_INGOT).copy();
				_setstack14.setCount(1);
				_menu.getSlots().get(3).set(_setstack14);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.ROUGH_TIN.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:tools/hammer")))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				ItemStack _setstack19 = new ItemStack(SurvivalReimaginedModItems.TIN_INGOT.get()).copy();
				_setstack19.setCount(1);
				_menu.getSlots().get(3).set(_setstack19);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(3).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}