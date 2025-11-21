package net.mcreator.survivalreimagined.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber(modid = SurvivalReimaginedMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SurvivalReimaginedModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("survival_reimagined").get().registerConfig(ModConfig.Type.COMMON, SurvivalReimaginedConfigConfiguration.SPEC, "srconfig.toml");
		});
	}
}
