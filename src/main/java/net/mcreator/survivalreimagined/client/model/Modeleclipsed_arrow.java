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

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeleclipsed_arrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "modeleclipsed_arrow"), "main");
	public final ModelPart back;
	public final ModelPart cross_1;
	public final ModelPart cross_2;

	public Modeleclipsed_arrow(ModelPart root) {
		this.back = root.getChild("back");
		this.cross_1 = root.getChild("cross_1");
		this.cross_2 = root.getChild("cross_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 20.5F, -7.0F, -2.3562F, 1.5708F, 0.0F));
		PartDefinition cross_1 = partdefinition.addOrReplaceChild("cross_1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -3.0F, -0.5F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 20.5F, 4.0F, 0.0F, -1.5708F, 2.3562F));
		PartDefinition cross_2 = partdefinition.addOrReplaceChild("cross_2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -3.0F, 0.5F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 20.5F, 4.0F, 0.0F, -1.5708F, -2.3562F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		cross_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		cross_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}