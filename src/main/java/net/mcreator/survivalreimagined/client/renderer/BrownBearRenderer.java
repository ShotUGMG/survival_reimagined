package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.survivalreimagined.entity.BrownBearEntity;
import net.mcreator.survivalreimagined.client.model.Modelbear;

import com.mojang.blaze3d.vertex.PoseStack;

public class BrownBearRenderer extends MobRenderer<BrownBearEntity, Modelbear<BrownBearEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("survival_reimagined:textures/entities/brown_bear.png");

	public BrownBearRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbear<BrownBearEntity>(context.bakeLayer(Modelbear.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(BrownBearEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.6f, 1.6f, 1.6f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(BrownBearEntity entity) {
		return entityTexture;
	}
}