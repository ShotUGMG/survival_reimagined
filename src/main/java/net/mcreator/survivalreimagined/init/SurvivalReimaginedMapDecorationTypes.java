/*package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SurvivalReimaginedMapDecorationTypes {
	private static final DeferredRegister<MapDecorationType> DECORATION_TYPES = DeferredRegister.create(Registries.MAP_DECORATION_TYPE, SurvivalReimaginedMod.MODID);
	public static final Holder<MapDecorationType> BUNKER_MAP_DECORATION = DECORATION_TYPES.register("bunker", () -> new MapDecorationType(SurvivalReimaginedMod.asResource("bunker"), true, -1, false, true));

	public static void register(IEventBus modEventBus) {
		DECORATION_TYPES.register(modEventBus);
	}
}*/