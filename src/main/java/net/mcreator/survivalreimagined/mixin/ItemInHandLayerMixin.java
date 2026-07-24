package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.survivalreimagined.SurvivalReimaginedModPlayerAnimationAPI;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(ItemInHandLayer.class)
public abstract class ItemInHandLayerMixin {
	private String master = null;

	@Inject(method = "renderArmWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"))
	private void animateItem(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext transformType, HumanoidArm arm, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
		if (master == null) {
			if (!SurvivalReimaginedModPlayerAnimationAPI.animations.isEmpty())
				master = "survival_reimagined";
			else
				return;
		}
		if (!master.equals("survival_reimagined")) {
			return;
		}
		if (livingEntity instanceof Player player) {
			SurvivalReimaginedModPlayerAnimationAPI.PlayerAnimation animation = SurvivalReimaginedModPlayerAnimationAPI.active_animations.get(player);
			if (animation == null)
				return;
			SurvivalReimaginedModPlayerAnimationAPI.PlayerBone bone = animation.bones.get(arm == HumanoidArm.LEFT ? "left_item" : "right_item");
			if (bone == null)
				return;
			float animationProgress = player.getPersistentData().getFloat("PlayerAnimationProgress");
			Vec3 scale = SurvivalReimaginedModPlayerAnimationAPI.PlayerBone.interpolate(bone.scales, animationProgress, player);
			if (scale != null) {
				poseStack.scale((float) scale.x, (float) scale.y, (float) scale.z);
			}
			Vec3 position = SurvivalReimaginedModPlayerAnimationAPI.PlayerBone.interpolate(bone.positions, animationProgress, player);
			if (position != null) {
				poseStack.translate((float) -position.x * 0.0625f, (float) -position.z * 0.0625f, (float) position.y * 0.0625f);
			}
			Vec3 rotation = SurvivalReimaginedModPlayerAnimationAPI.PlayerBone.interpolate(bone.rotations, animationProgress, player);
			if (rotation != null) {
				poseStack.mulPose(Axis.ZP.rotationDegrees((float) rotation.y));
				poseStack.mulPose(Axis.YP.rotationDegrees((float) -rotation.z));
				poseStack.mulPose(Axis.XP.rotationDegrees((float) -rotation.x));
			}
		}
	}
}