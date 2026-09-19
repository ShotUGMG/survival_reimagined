package net.mcreator.survivalreimagined.mixin;

import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(WorldOpenFlows.class)
public class HideExperimentalWarningMixin {
	@ModifyVariable(
		method = "confirmWorldCreation",
		at = @At("HEAD"),
		argsOnly = true,
		ordinal = 0
	)
	private static boolean bypassExperimentalWarning(boolean bypassWarnings) {
		return true;
	}
}
