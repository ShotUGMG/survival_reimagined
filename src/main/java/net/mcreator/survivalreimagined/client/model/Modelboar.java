package net.mcreator.survivalreimagined.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
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

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelboar<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "modelboar"), "main");
	public final ModelPart body;
	public final ModelPart bone2;
	public final ModelPart bone;
	public final ModelPart bone10;
	public final ModelPart bone11;
	public final ModelPart bone12;
	public final ModelPart head;
	public final ModelPart bone3;
	public final ModelPart bone8;
	public final ModelPart bone9;
	public final ModelPart leg1;
	public final ModelPart bone4;
	public final ModelPart bone5;
	public final ModelPart leg2;
	public final ModelPart bone6;
	public final ModelPart bone7;
	public final ModelPart leg3;
	public final ModelPart leg4;

	public Modelboar(ModelPart root) {
		this.body = root.getChild("body");
		this.bone2 = this.body.getChild("bone2");
		this.bone = this.bone2.getChild("bone");
		this.bone10 = this.bone2.getChild("bone10");
		this.bone11 = this.bone2.getChild("bone11");
		this.bone12 = this.bone2.getChild("bone12");
		this.head = root.getChild("head");
		this.bone3 = this.head.getChild("bone3");
		this.bone8 = this.head.getChild("bone8");
		this.bone9 = this.head.getChild("bone9");
		this.leg1 = root.getChild("leg1");
		this.bone4 = this.leg1.getChild("bone4");
		this.bone5 = this.bone4.getChild("bone5");
		this.leg2 = root.getChild("leg2");
		this.bone6 = this.leg2.getChild("bone6");
		this.bone7 = this.bone6.getChild("bone7");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -10.0F, -7.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -0.5F, -4.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -4.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition bone = bone2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition bone10 = bone2.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(32, 18).mirror().addBox(-3.5F, -2.0F, -0.75F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 2.25F, 2.5F, 0.2618F, 0.0F, 0.0F));
		PartDefinition bone11 = bone2.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(32, 26).mirror().addBox(-3.0F, -2.0F, -0.75F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, 0.0F, 2.75F, 0.4363F, 0.0F, 0.0F));
		PartDefinition bone12 = bone2.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(32, 26).addBox(-3.0F, -2.0F, -0.75F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -2.5F, 2.75F, 0.4363F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 32).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(16, 43).addBox(-1.5F, 1.75F, -8.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, -8.0F));
		PartDefinition bone3 = head.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 43).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 50).addBox(-1.5F, -2.25F, -3.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 49)
						.addBox(1.25F, -3.25F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 49).addBox(-2.25F, -3.25F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.75F, -5.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition bone8 = head.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(1, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -2.0F, -2.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition bone9 = head.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(1, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.0F, -2.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(50, 38).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 42).addBox(-1.0F, 4.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 15.0F, 5.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition bone4 = leg1.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(51, 41).addBox(-0.5F, 0.0F, -2.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(50, 36).addBox(-0.5F, 1.0F, -2.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.5F, 0.1745F, 0.0F, 0.0F));
		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(50, 38).addBox(-0.5F, -1.0F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -0.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(50, 38).mirror().addBox(-1.0F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(52, 42).mirror()
				.addBox(-1.0F, 4.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 15.0F, 5.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition bone6 = leg2.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(51, 41).mirror().addBox(-0.5F, 0.0F, -2.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(50, 36).mirror()
				.addBox(-0.5F, 1.0F, -2.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.0F, 0.5F, 0.1745F, 0.0F, 0.0F));
		PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(50, 38).mirror().addBox(-0.5F, -1.0F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 5.0F, -0.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(49, 37).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(51, 36)
				.addBox(-0.5F, 4.0F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(51, 40).addBox(-0.5F, 8.0F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, -6.0F));
		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(50, 35).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(50, 37)
				.addBox(-0.5F, 4.0F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(51, 41).addBox(-0.5F, 8.0F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 15.0F, -6.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}