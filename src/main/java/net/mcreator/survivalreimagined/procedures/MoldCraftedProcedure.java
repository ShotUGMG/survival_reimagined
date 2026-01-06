package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MoldCraftedProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity(), event.getCrafting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:clay_molds")))) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:molds"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (itemstack.getItem() == SurvivalReimaginedModItems.HEART_OF_THE_BLOOD_MOON.get()) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:heart_bloodmoon"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (itemstack.getItem() == Items.ENDER_EYE) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:eye_of_ender"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:adv_forge_upgrades")))) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:a_forge_upgrade"));
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