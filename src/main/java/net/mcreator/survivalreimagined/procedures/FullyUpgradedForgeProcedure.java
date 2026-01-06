package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.world.inventory.AdvancedAlloyForgeGUIMenu;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FullyUpgradedForgeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof AdvancedAlloyForgeGUIMenu) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:adv_forge_upgrades")))
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:adv_forge_upgrades")))
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:adv_forge_upgrades")))
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(7).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:adv_forge_upgrades")))) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:fully_upgrade_forge"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
	}
}