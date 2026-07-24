package net.mcreator.survivalreimagined.procedures;

import java.util.EnumMap;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Markings;
import net.minecraft.world.entity.animal.horse.Variant;
import net.minecraft.world.item.Item;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.registries.DeferredItem;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;


@EventBusSubscriber
public final class HorseCarcassDrops {

	private HorseCarcassDrops() {}

	private static final EnumMap<Variant, EnumMap<Markings, DeferredItem<Item>>> DROPS = new EnumMap<>(Variant.class);

	static {
		// White
		add(Variant.WHITE, Markings.NONE, SurvivalReimaginedModItems.WHITE_HORSE);
		add(Variant.WHITE, Markings.WHITE, SurvivalReimaginedModItems.WHITE_HORSE_STOCKING);
		add(Variant.WHITE, Markings.WHITE_FIELD, SurvivalReimaginedModItems.WHITE_HORSE_FIELD);
		add(Variant.WHITE, Markings.WHITE_DOTS, SurvivalReimaginedModItems.WHITE_HORSE_WHITE_DOTS);
		add(Variant.WHITE, Markings.BLACK_DOTS, SurvivalReimaginedModItems.WHITE_HORSE_BLACK_DOTS);
		// Creamy
		add(Variant.CREAMY, Markings.NONE, SurvivalReimaginedModItems.CREAMY_HORSE);
		add(Variant.CREAMY, Markings.WHITE, SurvivalReimaginedModItems.CREAMY_HORSE_STOCKINGS);
		add(Variant.CREAMY, Markings.WHITE_FIELD, SurvivalReimaginedModItems.CREAMY_HORSE_FIELD);
		add(Variant.CREAMY, Markings.WHITE_DOTS, SurvivalReimaginedModItems.CREAMY_HORSE_WHITE_DOTS);
		add(Variant.CREAMY, Markings.BLACK_DOTS, SurvivalReimaginedModItems.CREAMY_HORSE_BLACK_DOTS);
		// ChestNut
		add(Variant.CHESTNUT, Markings.NONE, SurvivalReimaginedModItems.CHESTNUT_HORSE);
		add(Variant.CHESTNUT, Markings.WHITE, SurvivalReimaginedModItems.CHESTNUT_HORSE_STOCKINGS);
		add(Variant.CHESTNUT, Markings.WHITE_FIELD, SurvivalReimaginedModItems.CHESTNUT_HORSE_FIELD);
		add(Variant.CHESTNUT, Markings.WHITE_DOTS, SurvivalReimaginedModItems.CHESTNUT_HORSE_WHITE_DOTS);
		add(Variant.CHESTNUT, Markings.BLACK_DOTS, SurvivalReimaginedModItems.CHESTNUT_HORSE_BLACK_DOTS);
		// Brown
		add(Variant.BROWN, Markings.NONE, SurvivalReimaginedModItems.BROWN_HORSE);
		add(Variant.BROWN, Markings.WHITE, SurvivalReimaginedModItems.BROWN_HORSE_STOCKINGS);
		add(Variant.BROWN, Markings.WHITE_FIELD, SurvivalReimaginedModItems.BROWN_HORSE_FIELD);
		add(Variant.BROWN, Markings.WHITE_DOTS, SurvivalReimaginedModItems.BROWN_HORSE_WHITE_DOTS);
		add(Variant.BROWN, Markings.BLACK_DOTS, SurvivalReimaginedModItems.BROWN_HORSE_BLACK_DOTS);
		// Black
		add(Variant.BLACK, Markings.NONE, SurvivalReimaginedModItems.BLACK_HORSE);
		add(Variant.BLACK, Markings.WHITE, SurvivalReimaginedModItems.BLACK_HORSE_STOCKINGS);
		add(Variant.BLACK, Markings.WHITE_FIELD, SurvivalReimaginedModItems.BLACK_HORSE_FIELD);
		add(Variant.BLACK, Markings.WHITE_DOTS, SurvivalReimaginedModItems.BLACK_HORSE_WHITE_DOTS);
		add(Variant.BLACK, Markings.BLACK_DOTS, SurvivalReimaginedModItems.BLACK_HORSE_BLACK_DOTS);
		// Gray
		add(Variant.GRAY, Markings.NONE, SurvivalReimaginedModItems.GRAY_HORSE);
		add(Variant.GRAY, Markings.WHITE, SurvivalReimaginedModItems.GRAY_HORSE_STOCKINGS);
		add(Variant.GRAY, Markings.WHITE_FIELD, SurvivalReimaginedModItems.GRAY_HORSE_FIELD);
		add(Variant.GRAY, Markings.WHITE_DOTS, SurvivalReimaginedModItems.GRAY_HORSE_WHITE_DOTS);
		add(Variant.GRAY, Markings.BLACK_DOTS, SurvivalReimaginedModItems.GRAY_HORSE_BLACK_DOTS);
		// Dark Brown
		add(Variant.DARK_BROWN, Markings.NONE, SurvivalReimaginedModItems.DARK_BROWN_HORSE);
		add(Variant.DARK_BROWN, Markings.WHITE, SurvivalReimaginedModItems.DARK_BROWN_HORSE_STOCKINGS);
		add(Variant.DARK_BROWN, Markings.WHITE_FIELD, SurvivalReimaginedModItems.DARK_BROWN_HORSE_FIELD);
		add(Variant.DARK_BROWN, Markings.WHITE_DOTS, SurvivalReimaginedModItems.DARK_BROWN_HORSE_WHITE_DOTS);
		add(Variant.DARK_BROWN, Markings.BLACK_DOTS, SurvivalReimaginedModItems.DARK_BROWN_HORSE_BLACK_DOTS);
	}

	private static void add(Variant Variant, Markings markings, DeferredItem<Item> item) {
		DROPS.computeIfAbsent(Variant, v -> new EnumMap<>(Markings.class)).put(markings, item);
	}

	private static DeferredItem<Item> getDrop(Horse horse) {
		EnumMap<Markings, DeferredItem<Item>> markings = DROPS.get(horse.getVariant());

		if (markings == null)
			return null;
		return markings.get(horse.getMarkings());
	}

	@SubscribeEvent
	public static void onLivingDrops(LivingDropsEvent event) {
		if (!(event.getEntity() instanceof Horse horse))
			return;

		DeferredItem<Item> item = getDrop(horse);

		if (item == null)
			return;

		horse.spawnAtLocation(item.get());
	}
}	