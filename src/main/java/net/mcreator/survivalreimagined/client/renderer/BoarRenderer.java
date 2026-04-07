package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.survivalreimagined.entity.BoarEntity;
import net.mcreator.survivalreimagined.client.model.Modelboar;

import com.mojang.blaze3d.vertex.PoseStack;

public class BoarRenderer extends MobRenderer<BoarEntity, Modelboar<BoarEntity>> {
	public BoarRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelboar<BoarEntity>(context.bakeLayer(Modelboar.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(BoarEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.25f, 1.25f, 1.25f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(BoarEntity entity) {
		return ResourceLocation.parse("survival_reimagined:textures/entities/baor.png");
	}
}