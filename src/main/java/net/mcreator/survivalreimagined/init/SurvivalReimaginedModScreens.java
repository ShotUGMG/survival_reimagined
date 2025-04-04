
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.survivalreimagined.client.gui.MetalRefiningTableGUIScreen;
import net.mcreator.survivalreimagined.client.gui.MPTGUIScreen;
import net.mcreator.survivalreimagined.client.gui.ForgeGUIScreen;
import net.mcreator.survivalreimagined.client.gui.BackpackGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SurvivalReimaginedModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(SurvivalReimaginedModMenus.FORGE_GUI.get(), ForgeGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.METAL_REFINING_TABLE_GUI.get(), MetalRefiningTableGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.MPTGUI.get(), MPTGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.BACKPACK_GUI.get(), BackpackGUIScreen::new);
	}
}
