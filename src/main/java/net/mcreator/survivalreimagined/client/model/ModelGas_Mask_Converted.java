package net.mcreator.survivalreimagined.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelGas_Mask_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "model_gas_mask_converted"), "main");
	public final ModelPart gas_mask;

	public ModelGas_Mask_Converted(ModelPart root) {
		this.gas_mask = root.getChild("gas_mask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition gas_mask = partdefinition.addOrReplaceChild("gas_mask", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)).texOffs(5, 17)
				.addBox(3.0F, -5.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)).texOffs(5, 17).addBox(-4.0F, -5.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 24.0F, 2.0F));
		PartDefinition string3_r1 = gas_mask.addOrReplaceChild("string3_r1", CubeListBuilder.create().texOffs(5, 17).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(-2.0F, -4.0F, 3.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition betterfilter_r1 = gas_mask.addOrReplaceChild("betterfilter_r1", CubeListBuilder.create().texOffs(12, 13).addBox(0.0F, 1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).texOffs(12, 10)
				.addBox(-4.0F, 1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).texOffs(0, 10).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5F, -3.0F, -4.0F, 0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 24, 24);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		gas_mask.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}
