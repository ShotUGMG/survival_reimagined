
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

import net.mcreator.survivalreimagined.entity.AlphaCrimsonArachnidEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AlphaCrimsonArachnidRenderer extends MobRenderer<AlphaCrimsonArachnidEntity, SpiderModel<AlphaCrimsonArachnidEntity>> {
	public AlphaCrimsonArachnidRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<AlphaCrimsonArachnidEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new RenderLayer<AlphaCrimsonArachnidEntity, SpiderModel<AlphaCrimsonArachnidEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("survival_reimagined:textures/entities/bloodmoon_spider_emission.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AlphaCrimsonArachnidEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(AlphaCrimsonArachnidEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.2f, 1.2f, 1.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(AlphaCrimsonArachnidEntity entity) {
		return ResourceLocation.parse("survival_reimagined:textures/entities/bloodmoon_spider.png");
	}
}
