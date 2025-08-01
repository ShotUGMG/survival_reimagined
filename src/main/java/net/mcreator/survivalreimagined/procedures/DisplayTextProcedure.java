package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

public class DisplayTextProcedure {
	public static String execute() {
		if (!ModList.get().isLoaded("biomesoplenty")) {
			return "Requires Biomes 'o' Plenty";
		}
		return "\n";
	}
}
