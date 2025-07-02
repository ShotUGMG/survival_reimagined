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

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelboat2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "modelboat_2"), "main");
	public final ModelPart front;
	public final ModelPart front2;
	public final ModelPart sides;
	public final ModelPart sides2;
	public final ModelPart base;
	public final ModelPart paddle_left;
	public final ModelPart paddle_right;
	public final ModelPart bottom_no_water;
	public final ModelPart left;
	public final ModelPart right;
	public final ModelPart back;
	public final ModelPart bottom;

	public Modelboat2(ModelPart root) {
		this.front = root.getChild("front");
		this.front2 = this.front.getChild("front2");
		this.sides = this.front.getChild("sides");
		this.sides2 = this.sides.getChild("sides2");
		this.base = this.front.getChild("base");
		this.paddle_left = root.getChild("paddle_left");
		this.paddle_right = root.getChild("paddle_right");
		this.bottom_no_water = root.getChild("bottom_no_water");
		this.left = root.getChild("left");
		this.right = root.getChild("right");
		this.back = root.getChild("back");
		this.bottom = root.getChild("bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition front = partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 19).addBox(-9.0F, -7.0F, 18.0F, 18.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 22.0F, 5.5F, 0.0F, 3.1416F, 0.0F));
		PartDefinition front2 = front.addOrReplaceChild("front2", CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -3.0F, -0.5F, 16.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, -10.5F, 0.0F, 3.1416F, 0.0F));
		PartDefinition sides = front.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(0, 35).addBox(0.5F, -31.0F, -7.0F, 28.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.0F, 24.0F, -10.5F, 0.0F, -1.5708F, 0.0F));
		PartDefinition sides2 = sides.addOrReplaceChild("sides2", CubeListBuilder.create().texOffs(0, 43).addBox(-13.5F, -3.0F, -1.0F, 28.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, -28.0F, -24.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition base = front.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-13.5F, -8.0F, -2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 1.5708F, 1.5708F, 0.0F));
		PartDefinition paddle_left = partdefinition.addOrReplaceChild("paddle_left",
				CubeListBuilder.create().texOffs(62, 0).addBox(-28.0F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(62, 0).addBox(-28.01F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(13.5F, 18.0F, -4.0F));
		PartDefinition paddle_right = partdefinition.addOrReplaceChild("paddle_right",
				CubeListBuilder.create().texOffs(62, 20).addBox(26.0F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(62, 20).addBox(27.01F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-13.5F, 18.0F, -4.0F));
		PartDefinition bottom_no_water = partdefinition.addOrReplaceChild("bottom_no_water", CubeListBuilder.create().texOffs(60, 40).addBox(-14.0F, -9.0F, -6.0F, 28.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 35.0F, 3.5F));
		PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition bottom = partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		front.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		paddle_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		paddle_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bottom_no_water.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
