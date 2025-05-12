package net.mcreator.survivalreimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.world.inventory.MPTGUIMenu;
import net.mcreator.survivalreimagined.procedures.MPTTooltipDisplayProcedure;
import net.mcreator.survivalreimagined.procedures.MPTGUIValueProcedure;
import net.mcreator.survivalreimagined.procedures.MPTGUIRedstoneValueProcedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTickProcedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick9Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick8Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick7Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick6Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick5Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick4Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick3Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick2Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick1Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick14Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick13Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick12Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick11Procedure;
import net.mcreator.survivalreimagined.procedures.MPTDisplayTick10Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MPTGUIScreen extends AbstractContainerScreen<MPTGUIMenu> {
	private final static HashMap<String, Object> guistate = MPTGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

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

	private static final ResourceLocation texture = ResourceLocation.parse("survival_reimagined:textures/screens/mptgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (MPTTooltipDisplayProcedure.execute(entity))
			if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 31 && mouseY < topPos + 55)
				guiGraphics.renderTooltip(font, Component.literal(MPTGUIValueProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + 59 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.literal(MPTGUIRedstoneValueProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (MPTDisplayTickProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow2.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow3.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow4.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow5.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow6.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow7.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow8.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow9.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow10.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow11.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow12.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow13.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow14.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (MPTDisplayTick14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/arrow15.png"), this.leftPos + 80, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/item_thingy.png"), this.leftPos + 80, this.topPos + 62, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/redstome.png"), this.leftPos + 8, this.topPos + 63, 0, 0, 16, 16, 16, 16);

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
