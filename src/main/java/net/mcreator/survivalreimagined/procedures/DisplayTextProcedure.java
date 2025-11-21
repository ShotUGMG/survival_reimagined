package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

public class DisplayTextProcedure {
	public static String execute() {
		if (!ModList.get().isLoaded("biomesoplenty")) {
			return "\u00A74 Requires Biomes 'o' Plenty";
		}
		return "\n";
	}
}
