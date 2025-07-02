package net.mcreator.survivalreimagined.procedures;

public class RadiatedSaplingBoneMealSuccessConditionProcedure {
	public static boolean execute() {
		if (Math.random() < 0.4) {
			return true;
		}
		return false;
	}
}
