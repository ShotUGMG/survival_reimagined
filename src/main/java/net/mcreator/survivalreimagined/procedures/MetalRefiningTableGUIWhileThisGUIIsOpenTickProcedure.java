package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

public class MetalRefiningTableGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		BronzeGearRecipesProcedure.execute(entity);
		SteelGearRecipesProcedure.execute(entity);
		DiamondGearRecipesProcedure.execute(entity);
		IngotsProcedure.execute(entity);
	}
}
