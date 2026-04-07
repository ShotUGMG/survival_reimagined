// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCustomModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custommodel"), "main");
	private final ModelPart root;
	private final ModelPart leaf;
	private final ModelPart leaf2;
	private final ModelPart leaf3;
	private final ModelPart leaf4;
	private final ModelPart leaf5;
	private final ModelPart leaf6;
	private final ModelPart leaf7;
	private final ModelPart leaf8;
	private final ModelPart leaf9;
	private final ModelPart leaf10;
	private final ModelPart leaf11;
	private final ModelPart leaf12;
	private final ModelPart leaf13;
	private final ModelPart leaf14;
	private final ModelPart leaf15;
	private final ModelPart leaf16;

	public ModelCustomModel(ModelPart root) {
		this.root = root.getChild("root");
		this.leaf = this.root.getChild("leaf");
		this.leaf2 = this.root.getChild("leaf2");
		this.leaf3 = this.root.getChild("leaf3");
		this.leaf4 = this.root.getChild("leaf4");
		this.leaf5 = this.root.getChild("leaf5");
		this.leaf6 = this.root.getChild("leaf6");
		this.leaf7 = this.root.getChild("leaf7");
		this.leaf8 = this.root.getChild("leaf8");
		this.leaf9 = this.root.getChild("leaf9");
		this.leaf10 = this.root.getChild("leaf10");
		this.leaf11 = this.root.getChild("leaf11");
		this.leaf12 = this.root.getChild("leaf12");
		this.leaf13 = this.root.getChild("leaf13");
		this.leaf14 = this.root.getChild("leaf14");
		this.leaf15 = this.root.getChild("leaf15");
		this.leaf16 = this.root.getChild("leaf16");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(42, 17).addBox(
				-3.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition leaf = root.addOrReplaceChild("leaf", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r1 = leaf
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = leaf
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf2 = root.addOrReplaceChild("leaf2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 1.1781F, -0.3491F));

		PartDefinition cube_r3 = leaf2
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = leaf2
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf3 = root.addOrReplaceChild("leaf3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1113F, -1.3695F, -2.7769F));

		PartDefinition cube_r5 = leaf3
				.addOrReplaceChild("cube_r5",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r6 = leaf3
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf4 = root.addOrReplaceChild("leaf4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.5076F, -0.4656F, 3.0668F));

		PartDefinition cube_r7 = leaf4
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r8 = leaf4
				.addOrReplaceChild("cube_r8",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf5 = root.addOrReplaceChild("leaf5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.9778F, 0.579F, 3.0617F));

		PartDefinition cube_r9 = leaf5
				.addOrReplaceChild("cube_r9",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r10 = leaf5
				.addOrReplaceChild("cube_r10",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf6 = root.addOrReplaceChild("leaf6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8085F, -0.2959F, -3.0998F));

		PartDefinition cube_r11 = leaf6
				.addOrReplaceChild("cube_r11",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r12 = leaf6
				.addOrReplaceChild("cube_r12",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf7 = root.addOrReplaceChild("leaf7", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.0277F, -0.8387F, -3.0696F));

		PartDefinition cube_r13 = leaf7
				.addOrReplaceChild("cube_r13",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r14 = leaf7
				.addOrReplaceChild("cube_r14",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf8 = root.addOrReplaceChild("leaf8", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1892F, -0.8564F, -0.1009F));

		PartDefinition cube_r15 = leaf8
				.addOrReplaceChild("cube_r15",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r16 = leaf8
				.addOrReplaceChild("cube_r16",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf9 = root.addOrReplaceChild("leaf9", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1008F, 0.7499F, 0.0586F));

		PartDefinition cube_r17 = leaf9
				.addOrReplaceChild("cube_r17",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r18 = leaf9
				.addOrReplaceChild("cube_r18",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf10 = root.addOrReplaceChild("leaf10", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.2576F, 1.1611F, -2.8434F));

		PartDefinition cube_r19 = leaf10
				.addOrReplaceChild("cube_r19",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r20 = leaf10
				.addOrReplaceChild("cube_r20",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf11 = root.addOrReplaceChild("leaf11", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.9784F, 1.1611F, -2.8434F));

		PartDefinition cube_r21 = leaf11
				.addOrReplaceChild("cube_r21",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r22 = leaf11
				.addOrReplaceChild("cube_r22",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf12 = root.addOrReplaceChild("leaf12", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0058F, 1.3797F, 0.7899F));

		PartDefinition cube_r23 = leaf12
				.addOrReplaceChild("cube_r23",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r24 = leaf12
				.addOrReplaceChild("cube_r24",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf13 = root.addOrReplaceChild("leaf13", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8807F, -0.8517F, -0.0894F));

		PartDefinition cube_r25 = leaf13
				.addOrReplaceChild("cube_r25",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r26 = leaf13
				.addOrReplaceChild("cube_r26",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf14 = root.addOrReplaceChild("leaf14", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2641F, -1.5214F, -0.4995F));

		PartDefinition cube_r27 = leaf14
				.addOrReplaceChild("cube_r27",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r28 = leaf14
				.addOrReplaceChild("cube_r28",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf15 = root.addOrReplaceChild("leaf15", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4454F, -0.208F, 0.0739F));

		PartDefinition cube_r29 = leaf15
				.addOrReplaceChild("cube_r29",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r30 = leaf15
				.addOrReplaceChild("cube_r30",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leaf16 = root.addOrReplaceChild("leaf16", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7513F, -1.4525F, -2.3169F));

		PartDefinition cube_r31 = leaf16
				.addOrReplaceChild("cube_r31",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r32 = leaf16
				.addOrReplaceChild("cube_r32",
						CubeListBuilder.create().texOffs(0, -36).addBox(0.0F, -5.0F, 0.0F, 0.0F, 12.0F, 38.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 80, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}