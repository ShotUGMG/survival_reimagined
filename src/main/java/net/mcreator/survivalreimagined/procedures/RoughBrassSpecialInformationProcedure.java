package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

public class RoughBrassSpecialInformationProcedure {
	public static String execute() {
		if (!ModList.get().isLoaded("create")) {
			return "\u00A74Requires Create";
		}
		return "\n";
	}
}
