/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.world.inventory.*;
import net.mcreator.survivalreimagined.network.MenuStateUpdateMessage;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import java.util.Map;

public class SurvivalReimaginedModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<ForgeGUIMenu>> FORGE_GUI = REGISTRY.register("forge_gui", () -> IMenuTypeExtension.create(ForgeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MetalRefiningTableGUIMenu>> METAL_REFINING_TABLE_GUI = REGISTRY.register("metal_refining_table_gui", () -> IMenuTypeExtension.create(MetalRefiningTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MPTGUIMenu>> MPTGUI = REGISTRY.register("mptgui", () -> IMenuTypeExtension.create(MPTGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackGUIMenu>> BACKPACK_GUI = REGISTRY.register("backpack_gui", () -> IMenuTypeExtension.create(BackpackGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdvancedAlloyForgeGUIMenu>> ADVANCED_ALLOY_FORGE_GUI = REGISTRY.register("advanced_alloy_forge_gui", () -> IMenuTypeExtension.create(AdvancedAlloyForgeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AAFScriptureGUIMenu>> AAF_SCRIPTURE_GUI = REGISTRY.register("aaf_scripture_gui", () -> IMenuTypeExtension.create(AAFScriptureGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RMIMenu>> RMI = REGISTRY.register("rmi", () -> IMenuTypeExtension.create(RMIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SmallTroughGUIMenu>> SMALL_TROUGH_GUI = REGISTRY.register("small_trough_gui", () -> IMenuTypeExtension.create(SmallTroughGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MillstoneGUIMenu>> MILLSTONE_GUI = REGISTRY.register("millstone_gui", () -> IMenuTypeExtension.create(MillstoneGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CampfireGUIMenu>> CAMPFIRE_GUI = REGISTRY.register("campfire_gui", () -> IMenuTypeExtension.create(CampfireGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DryingRackGUIMenu>> DRYING_RACK_GUI = REGISTRY.register("drying_rack_gui", () -> IMenuTypeExtension.create(DryingRackGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TanningBarrelGUIMenu>> TANNING_BARREL_GUI = REGISTRY.register("tanning_barrel_gui", () -> IMenuTypeExtension.create(TanningBarrelGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof SurvivalReimaginedModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}