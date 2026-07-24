package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

public class DisablePlacementFavorFarmersDelightProcedure {
	public static boolean execute() {
		if (ModList.get().isLoaded("farmersdelight") == true) {
			return false;
		}
		return true;
	}
}