package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.survivalreimagined.entity.BloodMoonZombieEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class BloodMoonZombieRenderer extends HumanoidMobRenderer<BloodMoonZombieEntity, HumanoidModel<BloodMoonZombieEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("survival_reimagined:textures/entities/bloodmoonzombie.png");

	public BloodMoonZombieRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<BloodMoonZombieEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	protected void scale(BloodMoonZombieEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.5f, 1.5f, 1.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BloodMoonZombieEntity entity) {
		return entityTexture;
	}
}