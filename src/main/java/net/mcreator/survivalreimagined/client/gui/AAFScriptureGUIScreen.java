package net.mcreator.survivalreimagined.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.world.inventory.AAFScriptureGUIMenu;
import net.mcreator.survivalreimagined.procedures.PreviousPageButtonDisplayProcedure;
import net.mcreator.survivalreimagined.procedures.Page2Procedure;
import net.mcreator.survivalreimagined.procedures.Page1Procedure;
import net.mcreator.survivalreimagined.procedures.NextPageButtonDisplayProcedure;
import net.mcreator.survivalreimagined.network.AAFScriptureGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AAFScriptureGUIScreen extends AbstractContainerScreen<AAFScriptureGUIMenu> {
	private final static HashMap<String, Object> guistate = AAFScriptureGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_next_page_button_unhovered;
	ImageButton imagebutton_previous_page_button_unhovered;

	public AAFScriptureGUIScreen(AAFScriptureGUIMenu container, Inventory inventory, Component text) {
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
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (NextPageButtonDisplayProcedure.execute(entity))
			if (mouseX > leftPos + 206 && mouseX < leftPos + 222 && mouseY > topPos + 150 && mouseY < topPos + 166)
				guiGraphics.renderTooltip(font, Component.translatable("gui.survival_reimagined.aaf_scripture_gui.tooltip_next_page"), mouseX, mouseY);
		if (PreviousPageButtonDisplayProcedure.execute(entity))
			if (mouseX > leftPos + -51 && mouseX < leftPos + -35 && mouseY > topPos + 150 && mouseY < topPos + 166)
				guiGraphics.renderTooltip(font, Component.translatable("gui.survival_reimagined.aaf_scripture_gui.tooltip_previous_page"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/book_cover.png"), this.leftPos + -66, this.topPos + -12, 0, 0, 304, 192, 304, 192);

		if (Page1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/book_page1.png"), this.leftPos + -66, this.topPos + -11, 0, 0, 304, 192, 304, 192);
		}
		if (Page1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/titanium_text.png"), this.leftPos + 97, this.topPos + 140, 0, 0, 32, 32, 32, 32);
		}
		if (Page1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/uranium_rod_text.png"), this.leftPos + 97, this.topPos + 82, 0, 0, 64, 32, 64, 32);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/book_page2.png"), this.leftPos + -66, this.topPos + -11, 0, 0, 304, 192, 304, 192);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text1.png"), this.leftPos + -46, this.topPos + 8, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text2.png"), this.leftPos + -47, this.topPos + 38, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text3.png"), this.leftPos + -46, this.topPos + 66, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text4.png"), this.leftPos + 91, this.topPos + 8, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text5.png"), this.leftPos + -45, this.topPos + 96, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text6.png"), this.leftPos + 94, this.topPos + 20, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text7.png"), this.leftPos + 94, this.topPos + 49, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text8.png"), this.leftPos + 91, this.topPos + 78, 0, 0, 128, 24, 128, 24);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text9.png"), this.leftPos + 91, this.topPos + 104, 0, 0, 128, 8, 128, 8);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text10.png"), this.leftPos + 91, this.topPos + 114, 0, 0, 128, 16, 128, 16);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text12.png"), this.leftPos + 91, this.topPos + 131, 0, 0, 56, 32, 56, 32);
		}
		if (Page2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text13.png"), this.leftPos + -45, this.topPos + 124, 0, 0, 136, 32, 136, 32);
		}
		if (Page1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/page_2_text14.png"), this.leftPos + -50, this.topPos + 16, 0, 0, 136, 16, 136, 16);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_next_page_button_unhovered = new ImageButton(this.leftPos + 206, this.topPos + 150, 16, 16,
				new WidgetSprites(ResourceLocation.parse("survival_reimagined:textures/screens/next_page_button_unhovered.png"), ResourceLocation.parse("survival_reimagined:textures/screens/next_page_button.png")), e -> {
					if (NextPageButtonDisplayProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new AAFScriptureGUIButtonMessage(0, x, y, z));
						AAFScriptureGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (NextPageButtonDisplayProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_next_page_button_unhovered", imagebutton_next_page_button_unhovered);
		this.addRenderableWidget(imagebutton_next_page_button_unhovered);
		imagebutton_previous_page_button_unhovered = new ImageButton(this.leftPos + -51, this.topPos + 150, 16, 16,
				new WidgetSprites(ResourceLocation.parse("survival_reimagined:textures/screens/previous_page_button_unhovered.png"), ResourceLocation.parse("survival_reimagined:textures/screens/previous_page_button.png")), e -> {
					if (PreviousPageButtonDisplayProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new AAFScriptureGUIButtonMessage(1, x, y, z));
						AAFScriptureGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (PreviousPageButtonDisplayProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_previous_page_button_unhovered", imagebutton_previous_page_button_unhovered);
		this.addRenderableWidget(imagebutton_previous_page_button_unhovered);
	}
}
