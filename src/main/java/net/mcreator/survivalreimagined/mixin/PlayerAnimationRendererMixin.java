package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.phys.Vec3;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.SurvivalReimaginedModPlayerAnimationAPI;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(PlayerRenderer.class)
public abstract class PlayerAnimationRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
	private String master = null;
	private Minecraft mc = Minecraft.getInstance();

	public PlayerAnimationRendererMixin(EntityRendererProvider.Context context, PlayerModel<AbstractClientPlayer> entityModel, float f) {
		super(context, entityModel, f);
	}

	@Inject(method = "render(Lnet/minecraft/client/player/AbstractClientPlayer;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"))
	private void hideBonesInFirstPerson(AbstractClientPlayer entity, float f, float g, PoseStack poseStack, MultiBufferSource bufferSource, int light, CallbackInfo ci) {
		if (master == null) {
			if (!SurvivalReimaginedModPlayerAnimationAPI.animations.isEmpty())
				master = "survival_reimagined";
			else
				return;
		}
		if (!master.equals("survival_reimagined")) {
			return;
		}
		CompoundTag data = entity.getPersistentData();
		if ((data.getBoolean("FirstPersonAnimation") || data.contains("setNullRender")) && mc.options.getCameraType().isFirstPerson() && entity == mc.player && (mc.screen == null || mc.screen instanceof ChatScreen)) {
			this.model.head.visible = false;
			this.model.body.visible = false;
			this.model.leftLeg.visible = false;
			this.model.rightLeg.visible = false;
			this.model.hat.visible = false;
			this.model.leftPants.visible = false;
			this.model.rightPants.visible = false;
			this.model.jacket.visible = false;
		}
	}

	@Inject(method = "Lnet/minecraft/client/renderer/entity/player/PlayerRenderer;setupRotations(Lnet/minecraft/client/player/AbstractClientPlayer;Lcom/mojang/blaze3d/vertex/PoseStack;FFFF)V", at = @At("RETURN"))
	private void setupRotations(AbstractClientPlayer player, PoseStack poseStack, float f, float bodyYaw, float deltaTick, float g, CallbackInfo ci) {
		if (master == null) {
			if (!SurvivalReimaginedModPlayerAnimationAPI.animations.isEmpty())
				master = "survival_reimagined";
			else
				return;
		}
		if (!master.equals("survival_reimagined")) {
			return;
		}
		SurvivalReimaginedModPlayerAnimationAPI.PlayerAnimation animation = SurvivalReimaginedModPlayerAnimationAPI.active_animations.get(player);
		if (animation == null)
			return;
		SurvivalReimaginedModPlayerAnimationAPI.PlayerBone bone = animation.bones.get("body");
		boolean firstPerson = player.getPersistentData().getBoolean("FirstPersonAnimation") && mc.options.getCameraType().isFirstPerson() && player == mc.player && (mc.screen == null || mc.screen instanceof ChatScreen);
		if (bone == null && !firstPerson)
			return;
		if (bone != null) {
			float animationProgress = player.getPersistentData().getFloat("PlayerAnimationProgress");
			Vec3 scale = SurvivalReimaginedModPlayerAnimationAPI.PlayerBone.interpolate(bone.scales, animationProgress, player);
			if (scale != null) {
				poseStack.scale((float) scale.x, (float) scale.y, (float) scale.z);
			}
			Vec3 position = SurvivalReimaginedModPlayerAnimationAPI.PlayerBone.interpolate(bone.positions, animationProgress, player);
			if (position != null) {
				if (!firstPerson)
					poseStack.translate((float) -position.x * 0.0625f, (float) (position.y * 0.0625f) + 0.75f, (float) position.z * 0.0625f);
			}
			Vec3 rotation = SurvivalReimaginedModPlayerAnimationAPI.PlayerBone.interpolate(bone.rotations, animationProgress, player);
			if (rotation != null) {
				if (!firstPerson)
					poseStack.mulPose(Axis.ZP.rotationDegrees((float) rotation.z));
				poseStack.mulPose(Axis.YP.rotationDegrees((float) -rotation.y));
				if (!firstPerson)
					poseStack.mulPose(Axis.XP.rotationDegrees((float) -rotation.x));
			}
			if (position != null) {
				if (!firstPerson)
					poseStack.translate(0, -0.75f, 0);
			}
		}
		if (firstPerson && g != 69) {
			poseStack.mulPose(Axis.YP.rotationDegrees(bodyYaw - player.getYRot()));
			poseStack.translate(0, 1.5f, 0);
			poseStack.mulPose(Axis.XP.rotationDegrees(-player.getXRot()));
			poseStack.translate(0, -1.5f, 0);
		}
	}
}