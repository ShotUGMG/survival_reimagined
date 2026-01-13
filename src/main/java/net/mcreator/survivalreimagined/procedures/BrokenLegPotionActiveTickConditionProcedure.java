package net.mcreator.survivalreimagined.procedures;

public class BrokenLegPotionActiveTickConditionProcedure {
	public static boolean execute(double amplifier, double duration) {
		double baseRate = 0;
		double rateWithAmplifier = 0;
		baseRate = 100;
		rateWithAmplifier = baseRate / Math.pow(2, amplifier);
		if (Math.floor(rateWithAmplifier) > 0) {
			return duration % Math.floor(rateWithAmplifier) == 0;
		}
		return true;
	}
}