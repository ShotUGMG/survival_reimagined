package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;

public class RMIWhileThisGUIIsOpenTickProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean HasGoldRune = false;
		boolean HasSilverRune = false;
		boolean HasLapis = false;
		boolean CanInfuse = false;
		boolean HasTool = false;
		boolean HasWeapon = false;
		boolean HasArmor = false;
		boolean IsSapphireRune = false;
		boolean Infused = false;
		boolean IsAmberRune = false;
		boolean IsDiamondRune = false;
		boolean IsRubyRune = false;
		boolean IsSpinelRune = false;
		boolean IsEmeraldRune = false;
		boolean IsLapisRune = false;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true
				^ (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
			Infused = true;
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:gem_runes"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		} else {
			Infused = false;
		}
		if (Infused == false) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/tool")))) {
				HasTool = true;
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/weapon")))) {
				HasWeapon = true;
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/armor")))) {
				HasArmor = true;
			} else {
				HasTool = false;
				HasArmor = false;
				HasWeapon = false;
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:rmi_runes/gold")))) {
			HasGoldRune = true;
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:rmi_runes/silver")))) {
			HasSilverRune = true;
		} else {
			HasGoldRune = false;
			HasSilverRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/sapphire")))) {
			IsSapphireRune = true;
		} else {
			IsSapphireRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/amber")))) {
			IsAmberRune = true;
		} else {
			IsAmberRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/diamond")))) {
			IsDiamondRune = true;
		} else {
			IsDiamondRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/emerald")))) {
			IsEmeraldRune = true;
		} else {
			IsEmeraldRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/ruby")))) {
			IsRubyRune = true;
		} else {
			IsRubyRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/lapis")))) {
			IsLapisRune = true;
		} else {
			IsLapisRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/spinel")))) {
			IsSpinelRune = true;
		} else {
			IsSpinelRune = false;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.LAPIS_LAZULI) {
			HasLapis = true;
		} else {
			HasLapis = false;
		}
		if ((HasSilverRune == true && getAmountInGUISlot(entity, 2) >= 2 || HasGoldRune == true && getAmountInGUISlot(entity, 2) >= 3) && (HasArmor == true || HasWeapon == true || HasTool == true) && HasLapis == true
				&& (IsSapphireRune == true || IsAmberRune == true || IsDiamondRune == true || IsEmeraldRune == true || IsRubyRune == true || IsLapisRune == true || IsSpinelRune == true)) {
			CanInfuse = true;
			return true;
		} else {
			CanInfuse = false;
		}
		return false;
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}