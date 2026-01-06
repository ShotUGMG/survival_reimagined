package net.mcreator.survivalreimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.world.inventory.AdvancedAlloyForgeGUIMenu;
import net.mcreator.survivalreimagined.procedures.*;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdvancedAlloyForgeGUIScreen extends AbstractContainerScreen<AdvancedAlloyForgeGUIMenu> implements SurvivalReimaginedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public AdvancedAlloyForgeGUIScreen(AdvancedAlloyForgeGUIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("survival_reimagined:textures/screens/advanced_alloy_forge_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 8 && mouseX < leftPos + 22 && mouseY > topPos + 5 && mouseY < topPos + 54) {
			String hoverText = AdvancedAlloyForgeGUIValueProcedure.execute(world, x, y, z);
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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/alloy_forge_upgrades.png"), this.leftPos + 178, this.topPos + 0, 0, 0, 72, 75, 72, 75);
		if (FC0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_empty.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 14, 49);
		}
		if (ST1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow2.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow3.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow4.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow5.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow6.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow7.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow8.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow9.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow10.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow11.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow12.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow13.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow14.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (ST15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow15.png"), this.leftPos + 111, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/rod_texture.png"), this.leftPos + 8, this.topPos + 57, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/upgrade_texture.png"), this.leftPos + 197, this.topPos + 19, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/upgrade_texture.png"), this.leftPos + 215, this.topPos + 19, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/upgrade_texture.png"), this.leftPos + 197, this.topPos + 37, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/upgrade_texture.png"), this.leftPos + 215, this.topPos + 37, 0, 0, 16, 16, 16, 16);
		if (FuelCover0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/capacity_marker.png"), this.leftPos + 23, this.topPos + 35, 0, 0, 7, 5, 7, 5);
		}
		if (FuelCover1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/capacity_marker.png"), this.leftPos + 23, this.topPos + 19, 0, 0, 7, 5, 7, 5);
		}
		if (FuelCover2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/capacity_marker.png"), this.leftPos + 23, this.topPos + 3, 0, 0, 7, 5, 7, 5);
		}
		if (XDisplayTickProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_x.png"), this.leftPos + 114, this.topPos + 43, 0, 0, 8, 8, 8, 8);
		}
		if (FC12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_12.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_11.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_10.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_9.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_8.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_7.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_6.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_5.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_4.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_3.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_2.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
		}
		if (FC1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/aaf_1.png"), this.leftPos + 8, this.topPos + 5, 0, 0, 14, 49, 84, 49);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.survival_reimagined.advanced_alloy_forge_gui.label_advanced_alloy_forge"), 52, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.survival_reimagined.advanced_alloy_forge_gui.label_upgrades"), 190, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}