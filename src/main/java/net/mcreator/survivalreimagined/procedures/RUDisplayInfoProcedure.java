package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

public class RUDisplayInfoProcedure {
	public static String execute() {
		if (!ModList.get().isLoaded("regions_unexplored")) {
			return "\u00A74 Requires Regions Unexplored";
		}
		return "\n";
	}
}
