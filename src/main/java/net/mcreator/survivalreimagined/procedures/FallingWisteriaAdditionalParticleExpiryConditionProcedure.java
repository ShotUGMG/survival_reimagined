package net.mcreator.survivalreimagined.procedures;

public class FallingWisteriaAdditionalParticleExpiryConditionProcedure {
	public static boolean execute(boolean onGround) {
		if (onGround == true) {
			return true;
		}
		return false;
	}
}
