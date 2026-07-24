package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import org.objectweb.asm.Opcodes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.SurvivalReimaginedModPlayerAnimationAPI;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {
	private String master = null;
	private Minecraft mc = Minecraft.getInstance();

	@ModifyExpressionValue(method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;layers:Ljava/util/List;", opcode = Opcodes.GETFIELD))
	private List<Object> filterLayers(List<Object> originalLayers, LivingEntity entity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
		if (master == null) {
			if (!SurvivalReimaginedModPlayerAnimationAPI.animations.isEmpty())
				master = "survival_reimagined";
			else
				return originalLayers;
		}
		if (!master.equals("survival_reimagined")) {
			return originalLayers;
		}
		if (entity instanceof Player player && mc.options.getCameraType().isFirstPerson()) {
			if (mc.player == player && (mc.screen == null || mc.screen instanceof ChatScreen)) {
				CompoundTag playerData = player.getPersistentData();
				if (playerData.getBoolean("FirstPersonAnimation")) {
					playerData.putInt("setNullRender", 1);
					return originalLayers.stream().filter(layer -> layer instanceof PlayerItemInHandLayer).toList();
				} else if (playerData.contains("setNullRender")) {
					if (playerData.getInt("setNullRender") <= 0) {
						playerData.remove("setNullRender");
					} else {
						playerData.putInt("setNullRender", playerData.getInt("setNullRender") - 1);
						return List.of();
					}
				}
			}
		}
		return originalLayers;
	}
}