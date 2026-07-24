package net.mcreator.survivalreimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.world.inventory.MPTGUIMenu;
import net.mcreator.survivalreimagined.procedures.*;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class MPTGUIScreen extends AbstractContainerScreen<MPTGUIMenu> implements SurvivalReimaginedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("survival_reimagined:textures/screens/mptgui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow3.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow4.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow5.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow6.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow7.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow8.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow9.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow10.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow11.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow12.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow13.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow14.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow15.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("survival_reimagined:textures/screens/item_thingy.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("survival_reimagined:textures/screens/redstome.png");

	public MPTGUIScreen(MPTGUIMenu container, Inventory inventory, Component text) {
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
		boolean customTooltipShown = false;
		if (MPTTooltipDisplayProcedure.execute(entity))
			if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 31 && mouseY < topPos + 55) {
				String hoverText = MPTGUIValueProcedure.execute(world, x, y, z, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + 59 && mouseY < topPos + 83) {
			String hoverText = MPTGUIRedstoneValueProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (MPTDisplayTickProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		guiGraphics.blit(IMAGE_15, this.leftPos + 80, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_16, this.leftPos + 8, this.topPos + 63, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.survival_reimagined.mptgui.label_mineral_processing_table"), 24, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}