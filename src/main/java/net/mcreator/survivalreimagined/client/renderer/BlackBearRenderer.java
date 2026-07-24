package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.survivalreimagined.entity.BlackBearEntity;
import net.mcreator.survivalreimagined.client.model.Modelbear;

import com.mojang.blaze3d.vertex.PoseStack;

public class BlackBearRenderer extends MobRenderer<BlackBearEntity, Modelbear<BlackBearEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("survival_reimagined:textures/entities/black_bear.png");

	public BlackBearRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbear<BlackBearEntity>(context.bakeLayer(Modelbear.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(BlackBearEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.2f, 1.2f, 1.2f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(BlackBearEntity entity) {
		return entityTexture;
	}
}