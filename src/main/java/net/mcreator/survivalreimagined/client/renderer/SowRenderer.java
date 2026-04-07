package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.survivalreimagined.entity.SowEntity;
import net.mcreator.survivalreimagined.client.model.Modelsow;

import com.mojang.blaze3d.vertex.PoseStack;

public class SowRenderer extends MobRenderer<SowEntity, Modelsow<SowEntity>> {
	public SowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsow<SowEntity>(context.bakeLayer(Modelsow.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(SowEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.1f, 1.1f, 1.1f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(SowEntity entity) {
		return ResourceLocation.parse("survival_reimagined:textures/entities/baor.png");
	}
}