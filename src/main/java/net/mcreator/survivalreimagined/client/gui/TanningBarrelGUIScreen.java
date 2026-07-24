package net.mcreator.survivalreimagined.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.world.inventory.TanningBarrelGUIMenu;
import net.mcreator.survivalreimagined.procedures.*;
import net.mcreator.survivalreimagined.network.TanningBarrelGUIButtonMessage;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TanningBarrelGUIScreen extends AbstractContainerScreen<TanningBarrelGUIMenu> implements SurvivalReimaginedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_seal_button_active;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("survival_reimagined:textures/screens/tanning_barrel_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("survival_reimagined:textures/screens/seal_button_noclick.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("survival_reimagined:textures/screens/tanning_barrel_fluid_tank.png");
	private static final ResourceLocation SPRITE_1 = ResourceLocation.parse("survival_reimagined:textures/screens/water_barrel_0.5.png");
	private static final ResourceLocation SPRITE_2 = ResourceLocation.parse("survival_reimagined:textures/screens/water_barrel_1.png");
	private static final ResourceLocation SPRITE_3 = ResourceLocation.parse("survival_reimagined:textures/screens/water_barrel_1.5.png");
	private static final ResourceLocation SPRITE_4 = ResourceLocation.parse("survival_reimagined:textures/screens/water_barrel_2.png");
	private static final ResourceLocation SPRITE_5 = ResourceLocation.parse("survival_reimagined:textures/screens/water_barrel_2.5.png");
	private static final ResourceLocation SPRITE_6 = ResourceLocation.parse("survival_reimagined:textures/screens/water_barrel_3.png");
	private static final ResourceLocation SPRITE_7 = ResourceLocation.parse("survival_reimagined:textures/screens/lime_water_barrel_0.5.png");
	private static final ResourceLocation SPRITE_8 = ResourceLocation.parse("survival_reimagined:textures/screens/lime_water_barrel_1.png");
	private static final ResourceLocation SPRITE_9 = ResourceLocation.parse("survival_reimagined:textures/screens/lime_water_barrel_1.5.png");
	private static final ResourceLocation SPRITE_10 = ResourceLocation.parse("survival_reimagined:textures/screens/lime_water_barrel_2.png");
	private static final ResourceLocation SPRITE_11 = ResourceLocation.parse("survival_reimagined:textures/screens/lime_water_barrel_2.5.png");
	private static final ResourceLocation SPRITE_12 = ResourceLocation.parse("survival_reimagined:textures/screens/lime_water_barrel.png");
	private static final ResourceLocation SPRITE_13 = ResourceLocation.parse("survival_reimagined:textures/screens/tannin_0.5.png");
	private static final ResourceLocation SPRITE_14 = ResourceLocation.parse("survival_reimagined:textures/screens/tannin_1.png");
	private static final ResourceLocation SPRITE_15 = ResourceLocation.parse("survival_reimagined:textures/screens/tannin_1.5.png");
	private static final ResourceLocation SPRITE_16 = ResourceLocation.parse("survival_reimagined:textures/screens/tannin_2.png");
	private static final ResourceLocation SPRITE_17 = ResourceLocation.parse("survival_reimagined:textures/screens/tannin_2.5.png");
	private static final ResourceLocation SPRITE_18 = ResourceLocation.parse("survival_reimagined:textures/screens/tannin_3.png");

	public TanningBarrelGUIScreen(TanningBarrelGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 72, this.topPos + 59, 0, 0, 32, 16, 32, 16);
		guiGraphics.blit(SPRITE_0, this.leftPos + 8, this.topPos + 15, 0, 0, 16, 49, 16, 49);
		if (Sprite1000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_1, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (Sprite2000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_2, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (Sprite3000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_3, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (Sprite4000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_4, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (Sprite5000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_5, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (Sprite6000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_6, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (LimeSprite1000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_7, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (LimeSprite2000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_8, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (LimeSprite3000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_9, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (LimeSprite4000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_10, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (LimeSprite5000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_11, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (LimeSprite6000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_12, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (TanninSprite1000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_13, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (TanninSprite2000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_14, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (TanninSprite3000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_15, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (TanninSprite4000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_16, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (TanninSprite5000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_17, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		if (TanninSprite6000Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_18, this.leftPos + 8, this.topPos + 15, 0, Mth.clamp((int) SpriteIndexProcedure.execute(world, x, y, z) * 48, 0, 1488), 16, 48, 16, 1536);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.survival_reimagined.tanning_barrel_gui.label_tanning_barrel"), 51, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_seal_button_active = new ImageButton(this.leftPos + 71, this.topPos + 58, 34, 18,
				new WidgetSprites(ResourceLocation.parse("survival_reimagined:textures/screens/seal_button_active.png"), ResourceLocation.parse("survival_reimagined:textures/screens/seal_button_selected.png")), e -> {
					int x = TanningBarrelGUIScreen.this.x;
					int y = TanningBarrelGUIScreen.this.y;
					if (SealButtonDisplayProcedure.execute(world, x, y, z)) {
						PacketDistributor.sendToServer(new TanningBarrelGUIButtonMessage(0, x, y, z));
						TanningBarrelGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = TanningBarrelGUIScreen.this.x;
				int y = TanningBarrelGUIScreen.this.y;
				if (SealButtonDisplayProcedure.execute(world, x, y, z))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_seal_button_active);
	}
}