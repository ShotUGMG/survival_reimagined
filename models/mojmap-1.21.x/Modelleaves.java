// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelleaves<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "leaves"), "main");
	private final ModelPart root;
	private final ModelPart frond;
	private final ModelPart frond2;
	private final ModelPart frond3;
	private final ModelPart frond4;
	private final ModelPart frond97;
	private final ModelPart frond98;
	private final ModelPart frond99;
	private final ModelPart frond100;
	private final ModelPart frond119;
	private final ModelPart frond120;
	private final ModelPart frond121;
	private final ModelPart frond122;
	private final ModelPart frond123;
	private final ModelPart frond124;
	private final ModelPart frond125;
	private final ModelPart frond126;
	private final ModelPart frond127;
	private final ModelPart frond128;
	private final ModelPart frond129;
	private final ModelPart frond130;
	private final ModelPart frond131;
	private final ModelPart frond132;
	private final ModelPart frond133;
	private final ModelPart frond134;
	private final ModelPart frond135;
	private final ModelPart frond136;
	private final ModelPart frond137;
	private final ModelPart frond138;
	private final ModelPart frond139;
	private final ModelPart frond140;
	private final ModelPart frond141;
	private final ModelPart frond142;
	private final ModelPart frond143;
	private final ModelPart frond144;
	private final ModelPart frond145;
	private final ModelPart frond146;
	private final ModelPart frond147;
	private final ModelPart frond148;
	private final ModelPart frond149;
	private final ModelPart frond150;
	private final ModelPart frond151;
	private final ModelPart frond152;
	private final ModelPart frond153;
	private final ModelPart frond154;
	private final ModelPart frond155;
	private final ModelPart frond156;
	private final ModelPart frond157;
	private final ModelPart frond158;
	private final ModelPart frond159;
	private final ModelPart frond160;
	private final ModelPart frond161;
	private final ModelPart frond162;
	private final ModelPart frond163;
	private final ModelPart frond164;
	private final ModelPart frond165;
	private final ModelPart frond166;
	private final ModelPart frond167;
	private final ModelPart frond168;
	private final ModelPart frond169;
	private final ModelPart frond170;
	private final ModelPart frond115;
	private final ModelPart frond116;
	private final ModelPart frond117;
	private final ModelPart frond118;
	private final ModelPart frond101;
	private final ModelPart frond105;
	private final ModelPart frond109;
	private final ModelPart frond110;
	private final ModelPart frond111;
	private final ModelPart frond112;
	private final ModelPart frond113;
	private final ModelPart frond114;
	private final ModelPart frond5;
	private final ModelPart frond6;
	private final ModelPart frond7;
	private final ModelPart frond8;
	private final ModelPart frond9;
	private final ModelPart frond10;
	private final ModelPart frond11;
	private final ModelPart frond12;
	private final ModelPart frond13;
	private final ModelPart frond14;
	private final ModelPart frond15;
	private final ModelPart frond16;
	private final ModelPart frond17;
	private final ModelPart frond18;
	private final ModelPart frond19;
	private final ModelPart frond20;
	private final ModelPart frond21;
	private final ModelPart frond22;
	private final ModelPart frond23;
	private final ModelPart frond24;
	private final ModelPart frond25;
	private final ModelPart frond26;
	private final ModelPart frond27;
	private final ModelPart frond28;
	private final ModelPart frond29;
	private final ModelPart frond30;
	private final ModelPart frond31;
	private final ModelPart frond32;
	private final ModelPart frond33;
	private final ModelPart frond34;
	private final ModelPart frond35;
	private final ModelPart frond36;
	private final ModelPart frond37;
	private final ModelPart frond38;
	private final ModelPart frond39;
	private final ModelPart frond40;
	private final ModelPart frond41;
	private final ModelPart frond42;
	private final ModelPart frond43;
	private final ModelPart frond44;
	private final ModelPart frond45;
	private final ModelPart frond46;
	private final ModelPart frond47;
	private final ModelPart frond48;
	private final ModelPart frond49;
	private final ModelPart frond50;
	private final ModelPart frond51;
	private final ModelPart frond52;
	private final ModelPart frond53;
	private final ModelPart frond54;
	private final ModelPart frond55;
	private final ModelPart frond56;
	private final ModelPart frond57;
	private final ModelPart frond58;
	private final ModelPart frond59;
	private final ModelPart frond60;
	private final ModelPart frond61;
	private final ModelPart frond62;
	private final ModelPart frond63;
	private final ModelPart frond64;
	private final ModelPart frond65;
	private final ModelPart frond66;
	private final ModelPart frond67;
	private final ModelPart frond68;
	private final ModelPart frond69;
	private final ModelPart frond70;
	private final ModelPart frond71;
	private final ModelPart frond72;
	private final ModelPart frond73;
	private final ModelPart frond74;
	private final ModelPart frond75;
	private final ModelPart frond76;
	private final ModelPart frond77;
	private final ModelPart frond78;
	private final ModelPart frond79;
	private final ModelPart frond80;
	private final ModelPart frond81;
	private final ModelPart frond82;
	private final ModelPart frond83;
	private final ModelPart frond84;
	private final ModelPart frond85;
	private final ModelPart frond86;
	private final ModelPart frond87;
	private final ModelPart frond88;
	private final ModelPart frond89;
	private final ModelPart frond90;
	private final ModelPart frond91;
	private final ModelPart frond92;
	private final ModelPart frond93;
	private final ModelPart frond94;
	private final ModelPart frond95;
	private final ModelPart frond96;

	public Modelleaves(ModelPart root) {
		this.root = root.getChild("root");
		this.frond = this.root.getChild("frond");
		this.frond2 = this.frond.getChild("frond2");
		this.frond3 = this.frond2.getChild("frond3");
		this.frond4 = this.frond3.getChild("frond4");
		this.frond97 = this.root.getChild("frond97");
		this.frond98 = this.frond97.getChild("frond98");
		this.frond99 = this.frond98.getChild("frond99");
		this.frond100 = this.frond99.getChild("frond100");
		this.frond119 = this.root.getChild("frond119");
		this.frond120 = this.frond119.getChild("frond120");
		this.frond121 = this.frond120.getChild("frond121");
		this.frond122 = this.frond121.getChild("frond122");
		this.frond123 = this.root.getChild("frond123");
		this.frond124 = this.frond123.getChild("frond124");
		this.frond125 = this.frond124.getChild("frond125");
		this.frond126 = this.frond125.getChild("frond126");
		this.frond127 = this.root.getChild("frond127");
		this.frond128 = this.frond127.getChild("frond128");
		this.frond129 = this.frond128.getChild("frond129");
		this.frond130 = this.frond129.getChild("frond130");
		this.frond131 = this.root.getChild("frond131");
		this.frond132 = this.frond131.getChild("frond132");
		this.frond133 = this.frond132.getChild("frond133");
		this.frond134 = this.frond133.getChild("frond134");
		this.frond135 = this.root.getChild("frond135");
		this.frond136 = this.frond135.getChild("frond136");
		this.frond137 = this.frond136.getChild("frond137");
		this.frond138 = this.frond137.getChild("frond138");
		this.frond139 = this.root.getChild("frond139");
		this.frond140 = this.frond139.getChild("frond140");
		this.frond141 = this.frond140.getChild("frond141");
		this.frond142 = this.frond141.getChild("frond142");
		this.frond143 = this.root.getChild("frond143");
		this.frond144 = this.frond143.getChild("frond144");
		this.frond145 = this.frond144.getChild("frond145");
		this.frond146 = this.frond145.getChild("frond146");
		this.frond147 = this.root.getChild("frond147");
		this.frond148 = this.frond147.getChild("frond148");
		this.frond149 = this.frond148.getChild("frond149");
		this.frond150 = this.frond149.getChild("frond150");
		this.frond151 = this.root.getChild("frond151");
		this.frond152 = this.frond151.getChild("frond152");
		this.frond153 = this.frond152.getChild("frond153");
		this.frond154 = this.frond153.getChild("frond154");
		this.frond155 = this.root.getChild("frond155");
		this.frond156 = this.frond155.getChild("frond156");
		this.frond157 = this.frond156.getChild("frond157");
		this.frond158 = this.frond157.getChild("frond158");
		this.frond159 = this.root.getChild("frond159");
		this.frond160 = this.frond159.getChild("frond160");
		this.frond161 = this.frond160.getChild("frond161");
		this.frond162 = this.frond161.getChild("frond162");
		this.frond163 = this.root.getChild("frond163");
		this.frond164 = this.frond163.getChild("frond164");
		this.frond165 = this.frond164.getChild("frond165");
		this.frond166 = this.frond165.getChild("frond166");
		this.frond167 = this.root.getChild("frond167");
		this.frond168 = this.frond167.getChild("frond168");
		this.frond169 = this.frond168.getChild("frond169");
		this.frond170 = this.frond169.getChild("frond170");
		this.frond115 = this.root.getChild("frond115");
		this.frond116 = this.frond115.getChild("frond116");
		this.frond117 = this.frond116.getChild("frond117");
		this.frond118 = this.frond117.getChild("frond118");
		this.frond101 = this.root.getChild("frond101");
		this.frond105 = this.frond101.getChild("frond105");
		this.frond109 = this.frond105.getChild("frond109");
		this.frond110 = this.frond109.getChild("frond110");
		this.frond111 = this.root.getChild("frond111");
		this.frond112 = this.frond111.getChild("frond112");
		this.frond113 = this.frond112.getChild("frond113");
		this.frond114 = this.frond113.getChild("frond114");
		this.frond5 = this.root.getChild("frond5");
		this.frond6 = this.frond5.getChild("frond6");
		this.frond7 = this.frond6.getChild("frond7");
		this.frond8 = this.frond7.getChild("frond8");
		this.frond9 = this.root.getChild("frond9");
		this.frond10 = this.frond9.getChild("frond10");
		this.frond11 = this.frond10.getChild("frond11");
		this.frond12 = this.frond11.getChild("frond12");
		this.frond13 = this.root.getChild("frond13");
		this.frond14 = this.frond13.getChild("frond14");
		this.frond15 = this.frond14.getChild("frond15");
		this.frond16 = this.frond15.getChild("frond16");
		this.frond17 = this.root.getChild("frond17");
		this.frond18 = this.frond17.getChild("frond18");
		this.frond19 = this.frond18.getChild("frond19");
		this.frond20 = this.frond19.getChild("frond20");
		this.frond21 = this.root.getChild("frond21");
		this.frond22 = this.frond21.getChild("frond22");
		this.frond23 = this.frond22.getChild("frond23");
		this.frond24 = this.frond23.getChild("frond24");
		this.frond25 = this.root.getChild("frond25");
		this.frond26 = this.frond25.getChild("frond26");
		this.frond27 = this.frond26.getChild("frond27");
		this.frond28 = this.frond27.getChild("frond28");
		this.frond29 = this.root.getChild("frond29");
		this.frond30 = this.frond29.getChild("frond30");
		this.frond31 = this.frond30.getChild("frond31");
		this.frond32 = this.frond31.getChild("frond32");
		this.frond33 = this.root.getChild("frond33");
		this.frond34 = this.frond33.getChild("frond34");
		this.frond35 = this.frond34.getChild("frond35");
		this.frond36 = this.frond35.getChild("frond36");
		this.frond37 = this.root.getChild("frond37");
		this.frond38 = this.frond37.getChild("frond38");
		this.frond39 = this.frond38.getChild("frond39");
		this.frond40 = this.frond39.getChild("frond40");
		this.frond41 = this.root.getChild("frond41");
		this.frond42 = this.frond41.getChild("frond42");
		this.frond43 = this.frond42.getChild("frond43");
		this.frond44 = this.frond43.getChild("frond44");
		this.frond45 = this.root.getChild("frond45");
		this.frond46 = this.frond45.getChild("frond46");
		this.frond47 = this.frond46.getChild("frond47");
		this.frond48 = this.frond47.getChild("frond48");
		this.frond49 = this.root.getChild("frond49");
		this.frond50 = this.frond49.getChild("frond50");
		this.frond51 = this.frond50.getChild("frond51");
		this.frond52 = this.frond51.getChild("frond52");
		this.frond53 = this.root.getChild("frond53");
		this.frond54 = this.frond53.getChild("frond54");
		this.frond55 = this.frond54.getChild("frond55");
		this.frond56 = this.frond55.getChild("frond56");
		this.frond57 = this.root.getChild("frond57");
		this.frond58 = this.frond57.getChild("frond58");
		this.frond59 = this.frond58.getChild("frond59");
		this.frond60 = this.frond59.getChild("frond60");
		this.frond61 = this.root.getChild("frond61");
		this.frond62 = this.frond61.getChild("frond62");
		this.frond63 = this.frond62.getChild("frond63");
		this.frond64 = this.frond63.getChild("frond64");
		this.frond65 = this.root.getChild("frond65");
		this.frond66 = this.frond65.getChild("frond66");
		this.frond67 = this.frond66.getChild("frond67");
		this.frond68 = this.frond67.getChild("frond68");
		this.frond69 = this.root.getChild("frond69");
		this.frond70 = this.frond69.getChild("frond70");
		this.frond71 = this.frond70.getChild("frond71");
		this.frond72 = this.frond71.getChild("frond72");
		this.frond73 = this.root.getChild("frond73");
		this.frond74 = this.frond73.getChild("frond74");
		this.frond75 = this.frond74.getChild("frond75");
		this.frond76 = this.frond75.getChild("frond76");
		this.frond77 = this.root.getChild("frond77");
		this.frond78 = this.frond77.getChild("frond78");
		this.frond79 = this.frond78.getChild("frond79");
		this.frond80 = this.frond79.getChild("frond80");
		this.frond81 = this.root.getChild("frond81");
		this.frond82 = this.frond81.getChild("frond82");
		this.frond83 = this.frond82.getChild("frond83");
		this.frond84 = this.frond83.getChild("frond84");
		this.frond85 = this.root.getChild("frond85");
		this.frond86 = this.frond85.getChild("frond86");
		this.frond87 = this.frond86.getChild("frond87");
		this.frond88 = this.frond87.getChild("frond88");
		this.frond89 = this.root.getChild("frond89");
		this.frond90 = this.frond89.getChild("frond90");
		this.frond91 = this.frond90.getChild("frond91");
		this.frond92 = this.frond91.getChild("frond92");
		this.frond93 = this.root.getChild("frond93");
		this.frond94 = this.frond93.getChild("frond94");
		this.frond95 = this.frond94.getChild("frond95");
		this.frond96 = this.frond95.getChild("frond96");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition frond = root
				.addOrReplaceChild("frond",
						CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition frond2 = frond.addOrReplaceChild("frond2",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond3 = frond2.addOrReplaceChild("frond3",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond4 = frond3.addOrReplaceChild("frond4",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond97 = root
				.addOrReplaceChild("frond97",
						CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frond98 = frond97.addOrReplaceChild("frond98",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond99 = frond98.addOrReplaceChild("frond99",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond100 = frond99.addOrReplaceChild("frond100",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond119 = root.addOrReplaceChild("frond119",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3652F, 0.5648F, -0.0555F));

		PartDefinition frond120 = frond119.addOrReplaceChild("frond120",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond121 = frond120.addOrReplaceChild("frond121",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond122 = frond121.addOrReplaceChild("frond122",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond123 = root.addOrReplaceChild("frond123",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5768F, 0.9146F, -0.0853F));

		PartDefinition frond124 = frond123.addOrReplaceChild("frond124",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond125 = frond124.addOrReplaceChild("frond125",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond126 = frond125.addOrReplaceChild("frond126",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond127 = root.addOrReplaceChild("frond127",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1119F, -1.1826F, -0.2465F));

		PartDefinition frond128 = frond127.addOrReplaceChild("frond128",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond129 = frond128.addOrReplaceChild("frond129",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond130 = frond129.addOrReplaceChild("frond130",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond131 = root.addOrReplaceChild("frond131",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7505F, -1.0147F, 3.1371F));

		PartDefinition frond132 = frond131.addOrReplaceChild("frond132",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond133 = frond132.addOrReplaceChild("frond133",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond134 = frond133.addOrReplaceChild("frond134",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond135 = root.addOrReplaceChild("frond135",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8044F, 0.4755F, 3.1403F));

		PartDefinition frond136 = frond135.addOrReplaceChild("frond136",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond137 = frond136.addOrReplaceChild("frond137",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond138 = frond137.addOrReplaceChild("frond138",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond139 = root.addOrReplaceChild("frond139",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.9344F, 0.9109F, -3.0109F));

		PartDefinition frond140 = frond139.addOrReplaceChild("frond140",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond141 = frond140.addOrReplaceChild("frond141",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond142 = frond141.addOrReplaceChild("frond142",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond143 = root.addOrReplaceChild("frond143",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3687F, 0.0904F, 3.1155F));

		PartDefinition frond144 = frond143.addOrReplaceChild("frond144",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond145 = frond144.addOrReplaceChild("frond145",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond146 = frond145.addOrReplaceChild("frond146",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond147 = root.addOrReplaceChild("frond147",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3659F, -1.0421F, -3.113F));

		PartDefinition frond148 = frond147.addOrReplaceChild("frond148",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond149 = frond148.addOrReplaceChild("frond149",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond150 = frond149.addOrReplaceChild("frond150",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond151 = root.addOrReplaceChild("frond151",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4837F, -0.6315F, -0.0159F));

		PartDefinition frond152 = frond151.addOrReplaceChild("frond152",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond153 = frond152.addOrReplaceChild("frond153",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond154 = frond153.addOrReplaceChild("frond154",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond155 = root.addOrReplaceChild("frond155",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0473F, -0.6315F, -0.0159F));

		PartDefinition frond156 = frond155.addOrReplaceChild("frond156",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond157 = frond156.addOrReplaceChild("frond157",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond158 = frond157.addOrReplaceChild("frond158",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond159 = root.addOrReplaceChild("frond159",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.0363F, -1.1987F, 2.9996F));

		PartDefinition frond160 = frond159.addOrReplaceChild("frond160",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond161 = frond160.addOrReplaceChild("frond161",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond162 = frond161.addOrReplaceChild("frond162",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond163 = root.addOrReplaceChild("frond163",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1026F, -0.1969F, 3.0901F));

		PartDefinition frond164 = frond163.addOrReplaceChild("frond164",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond165 = frond164.addOrReplaceChild("frond165",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond166 = frond165.addOrReplaceChild("frond166",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond167 = root.addOrReplaceChild("frond167",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1013F, 0.3263F, 3.1106F));

		PartDefinition frond168 = frond167.addOrReplaceChild("frond168",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond169 = frond168.addOrReplaceChild("frond169",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond170 = frond169.addOrReplaceChild("frond170",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond115 = root.addOrReplaceChild("frond115",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.3054F));

		PartDefinition frond116 = frond115.addOrReplaceChild("frond116",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond117 = frond116.addOrReplaceChild("frond117",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond118 = frond117.addOrReplaceChild("frond118",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond101 = root.addOrReplaceChild("frond101",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.3054F));

		PartDefinition frond105 = frond101.addOrReplaceChild("frond105",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond109 = frond105.addOrReplaceChild("frond109",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond110 = frond109.addOrReplaceChild("frond110",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond111 = root.addOrReplaceChild("frond111",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8351F, -0.0832F, -3.1153F));

		PartDefinition frond112 = frond111.addOrReplaceChild("frond112",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond113 = frond112.addOrReplaceChild("frond113",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond114 = frond113.addOrReplaceChild("frond114",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond5 = root.addOrReplaceChild("frond5",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.5672F));

		PartDefinition frond6 = frond5.addOrReplaceChild("frond6",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond7 = frond6.addOrReplaceChild("frond7",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond8 = frond7.addOrReplaceChild("frond8",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond9 = root.addOrReplaceChild("frond9",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.5744F, 0.0F, 3.1416F));

		PartDefinition frond10 = frond9.addOrReplaceChild("frond10",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond11 = frond10.addOrReplaceChild("frond11",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond12 = frond11.addOrReplaceChild("frond12",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond13 = root.addOrReplaceChild("frond13",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.4399F, -0.5672F));

		PartDefinition frond14 = frond13.addOrReplaceChild("frond14",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond15 = frond14.addOrReplaceChild("frond15",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond16 = frond15.addOrReplaceChild("frond16",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond17 = root.addOrReplaceChild("frond17",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.5912F, -0.6912F, 2.9951F));

		PartDefinition frond18 = frond17.addOrReplaceChild("frond18",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond19 = frond18.addOrReplaceChild("frond19",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond20 = frond19.addOrReplaceChild("frond20",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond21 = root.addOrReplaceChild("frond21",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, -0.7854F, 0.0F));

		PartDefinition frond22 = frond21.addOrReplaceChild("frond22",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond23 = frond22.addOrReplaceChild("frond23",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond24 = frond23.addOrReplaceChild("frond24",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond25 = root.addOrReplaceChild("frond25",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7266F, 0.8774F, 0.1384F));

		PartDefinition frond26 = frond25.addOrReplaceChild("frond26",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond27 = frond26.addOrReplaceChild("frond27",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond28 = frond27.addOrReplaceChild("frond28",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond29 = root.addOrReplaceChild("frond29",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3998F, 0.7854F, 3.1416F));

		PartDefinition frond30 = frond29.addOrReplaceChild("frond30",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond31 = frond30.addOrReplaceChild("frond31",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond32 = frond31.addOrReplaceChild("frond32",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond33 = root.addOrReplaceChild("frond33",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0508F, 0.0F, 3.1416F));

		PartDefinition frond34 = frond33.addOrReplaceChild("frond34",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond35 = frond34.addOrReplaceChild("frond35",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond36 = frond35.addOrReplaceChild("frond36",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond37 = root.addOrReplaceChild("frond37",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0508F, 0.7854F, 3.1416F));

		PartDefinition frond38 = frond37.addOrReplaceChild("frond38",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond39 = frond38.addOrReplaceChild("frond39",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond40 = frond39.addOrReplaceChild("frond40",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond41 = root.addOrReplaceChild("frond41",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1117F, 1.3759F, -0.0133F));

		PartDefinition frond42 = frond41.addOrReplaceChild("frond42",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond43 = frond42.addOrReplaceChild("frond43",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond44 = frond43.addOrReplaceChild("frond44",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond45 = root.addOrReplaceChild("frond45",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0908F, 0.7854F, 0.0F));

		PartDefinition frond46 = frond45.addOrReplaceChild("frond46",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond47 = frond46.addOrReplaceChild("frond47",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond48 = frond47.addOrReplaceChild("frond48",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond49 = root
				.addOrReplaceChild("frond49",
						CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0908F, 0.0F, 0.0F));

		PartDefinition frond50 = frond49.addOrReplaceChild("frond50",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond51 = frond50.addOrReplaceChild("frond51",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond52 = frond51.addOrReplaceChild("frond52",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond53 = root.addOrReplaceChild("frond53",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0908F, -0.7854F, 0.0F));

		PartDefinition frond54 = frond53.addOrReplaceChild("frond54",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond55 = frond54.addOrReplaceChild("frond55",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond56 = frond55.addOrReplaceChild("frond56",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond57 = root.addOrReplaceChild("frond57",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F));

		PartDefinition frond58 = frond57.addOrReplaceChild("frond58",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond59 = frond58.addOrReplaceChild("frond59",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond60 = frond59.addOrReplaceChild("frond60",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond61 = root.addOrReplaceChild("frond61",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.002F, -0.9021F, -3.0815F));

		PartDefinition frond62 = frond61.addOrReplaceChild("frond62",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond63 = frond62.addOrReplaceChild("frond63",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond64 = frond63.addOrReplaceChild("frond64",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond65 = root.addOrReplaceChild("frond65",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.789F, -0.3491F, -3.1416F));

		PartDefinition frond66 = frond65.addOrReplaceChild("frond66",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond67 = frond66.addOrReplaceChild("frond67",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond68 = frond67.addOrReplaceChild("frond68",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond69 = root.addOrReplaceChild("frond69",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.789F, 0.4363F, -3.1416F));

		PartDefinition frond70 = frond69.addOrReplaceChild("frond70",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond71 = frond70.addOrReplaceChild("frond71",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond72 = frond71.addOrReplaceChild("frond72",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond73 = root.addOrReplaceChild("frond73",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.789F, 1.2217F, -3.1416F));

		PartDefinition frond74 = frond73.addOrReplaceChild("frond74",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond75 = frond74.addOrReplaceChild("frond75",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond76 = frond75.addOrReplaceChild("frond76",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond77 = root.addOrReplaceChild("frond77",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2138F, 1.0677F, 0.1576F));

		PartDefinition frond78 = frond77.addOrReplaceChild("frond78",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond79 = frond78.addOrReplaceChild("frond79",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond80 = frond79.addOrReplaceChild("frond80",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond81 = root.addOrReplaceChild("frond81",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.6144F, 0.3491F, 0.0F));

		PartDefinition frond82 = frond81.addOrReplaceChild("frond82",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond83 = frond82.addOrReplaceChild("frond83",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond84 = frond83.addOrReplaceChild("frond84",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond85 = root.addOrReplaceChild("frond85",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3526F, -0.4363F, 0.0F));

		PartDefinition frond86 = frond85.addOrReplaceChild("frond86",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond87 = frond86.addOrReplaceChild("frond87",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond88 = frond87.addOrReplaceChild("frond88",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond89 = root.addOrReplaceChild("frond89",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3526F, -1.2217F, 0.0F));

		PartDefinition frond90 = frond89.addOrReplaceChild("frond90",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond91 = frond90.addOrReplaceChild("frond91",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond92 = frond91.addOrReplaceChild("frond92",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition frond93 = root.addOrReplaceChild("frond93",
				CubeListBuilder.create().texOffs(81, 0).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.6335F, -1.1559F, -2.8277F));

		PartDefinition frond94 = frond93.addOrReplaceChild("frond94",
				CubeListBuilder.create().texOffs(81, 16).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition frond95 = frond94.addOrReplaceChild("frond95",
				CubeListBuilder.create().texOffs(81, 32).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition frond96 = frond95.addOrReplaceChild("frond96",
				CubeListBuilder.create().texOffs(81, 48).addBox(-7.5F, 0.0F, -16.0F, 15.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, 0.7418F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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