package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import org.joml.Matrix4f;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Camera;

import net.mcreator.survivalreimagined.SurvivalReimaginedModPlayerAnimationAPI;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {
	private String master = null;
	private Minecraft mc = Minecraft.getInstance();

	@Inject(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z"))
	private void fakeThirdPersonMode(DeltaTracker deltaTracker, boolean bl, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo ci) {
		if (master == null) {
			if (!SurvivalReimaginedModPlayerAnimationAPI.animations.isEmpty())
				master = "survival_reimagined";
			else
				return;
		}
		if (!master.equals("survival_reimagined")) {
			return;
		}
		if (camera.getEntity() instanceof Player player && player.getPersistentData().getBoolean("FirstPersonAnimation") && mc.player == player && (mc.screen == null || mc.screen instanceof ChatScreen)) {
			((CameraAccessor) camera).setDetached(true);
		}
	}

	@Inject(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z", shift = At.Shift.AFTER))
	private void resetThirdPerson(DeltaTracker deltaTracker, boolean bl, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo ci) {
		if (master == null) {
			if (!SurvivalReimaginedModPlayerAnimationAPI.animations.isEmpty())
				master = "survival_reimagined";
			else
				return;
		}
		if (!master.equals("survival_reimagined")) {
			return;
		}
		((CameraAccessor) camera).setDetached(false);
	}
}