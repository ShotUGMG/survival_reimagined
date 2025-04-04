
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.world.inventory.MetalRefiningTableGUIMenu;
import net.mcreator.survivalreimagined.world.inventory.MPTGUIMenu;
import net.mcreator.survivalreimagined.world.inventory.ForgeGUIMenu;
import net.mcreator.survivalreimagined.world.inventory.BackpackGUIMenu;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SurvivalReimaginedModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<ForgeGUIMenu>> FORGE_GUI = REGISTRY.register("forge_gui", () -> IMenuTypeExtension.create(ForgeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MetalRefiningTableGUIMenu>> METAL_REFINING_TABLE_GUI = REGISTRY.register("metal_refining_table_gui", () -> IMenuTypeExtension.create(MetalRefiningTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MPTGUIMenu>> MPTGUI = REGISTRY.register("mptgui", () -> IMenuTypeExtension.create(MPTGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackGUIMenu>> BACKPACK_GUI = REGISTRY.register("backpack_gui", () -> IMenuTypeExtension.create(BackpackGUIMenu::new));
}
