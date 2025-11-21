
package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.survivalreimagined.entity.CrimsonArachnidEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonArachnidRenderer extends MobRenderer<CrimsonArachnidEntity, SpiderModel<CrimsonArachnidEntity>> {
	public CrimsonArachnidRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<CrimsonArachnidEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new RenderLayer<CrimsonArachnidEntity, SpiderModel<CrimsonArachnidEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("survival_reimagined:textures/entities/bloodmoon_spider_emission.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CrimsonArachnidEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(CrimsonArachnidEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.6f, 0.6f, 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(CrimsonArachnidEntity entity) {
		return ResourceLocation.parse("survival_reimagined:textures/entities/bloodmoon_spider.png");
	}
}
