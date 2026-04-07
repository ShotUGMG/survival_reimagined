/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.survivalreimagined.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
public class SurvivalReimaginedModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(SurvivalReimaginedModMenus.FORGE_GUI.get(), ForgeGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.METAL_REFINING_TABLE_GUI.get(), MetalRefiningTableGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.MPTGUI.get(), MPTGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.BACKPACK_GUI.get(), BackpackGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.ADVANCED_ALLOY_FORGE_GUI.get(), AdvancedAlloyForgeGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.AAF_SCRIPTURE_GUI.get(), AAFScriptureGUIScreen::new);
		event.register(SurvivalReimaginedModMenus.RMI.get(), RMIScreen::new);
		event.register(SurvivalReimaginedModMenus.SMALL_TROUGH_GUI.get(), SmallTroughGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}