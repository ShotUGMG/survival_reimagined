package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.multiplayer.ClientLevel;

import org.joml.Vector3fc;
import org.joml.Vector3f;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.apache.logging.log4j.core.net.Priority;
import net.minecraft.world.effect.MobEffects;


@Mixin(LightTexture.class)
public abstract class CaveDarknessMixin {	
	@ModifyArg(
		method = "updateLightTexture",
		at = @At(
			value = "INVOKE",
			target = "Lorg/joml/Vector3f;lerp(Lorg/joml/Vector3fc;F)Lorg/joml/Vector3f;"
		),
		index = 0
	)
	
	private Vector3fc removeAmbientLight(Vector3fc vec) {
		Minecraft mc = Minecraft.getInstance();

		if (mc.player != null && mc.player.hasEffect(MobEffects.NIGHT_VISION) || mc.player.hasEffect(MobEffects.CONDUIT_POWER)) {
			return vec;
		}
		
		if (vec.x() == 0.75F && vec.y() == 0.75F && vec.z() == 0.75F) {
			return new Vector3f(0.0F, 0.0F, 0.0F);
		}
		return vec;
	}
}