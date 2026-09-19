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

import net.mcreator.survivalreimagined.world.inventory.RMIScriptureGUIMenu;
import net.mcreator.survivalreimagined.procedures.PreviousPageButtonDisplayRMIProcedure;
import net.mcreator.survivalreimagined.procedures.PreviousPageButtonDisplayProcedure;
import net.mcreator.survivalreimagined.procedures.NextPageButtonDisplayRMIProcedure;
import net.mcreator.survivalreimagined.procedures.NextPageButtonDisplayProcedure;
import net.mcreator.survivalreimagined.network.RMIScriptureGUIButtonMessage;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RMIScriptureGUIScreen extends AbstractContainerScreen<RMIScriptureGUIMenu> implements SurvivalReimaginedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_next_page_button_unhovered;
	private ImageButton imagebutton_previous_page_button_unhovered;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("survival_reimagined:textures/screens/book_cover_rmi.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("survival_reimagined:textures/screens/book_page2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("survival_reimagined:textures/screens/diamond_text.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("survival_reimagined:textures/screens/rune_text.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("survival_reimagined:textures/screens/rune_icon.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("survival_reimagined:textures/screens/diamond_icon.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("survival_reimagined:textures/screens/sword_icon.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("survival_reimagined:textures/screens/pickaxe_icon.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("survival_reimagined:textures/screens/armor_icon.png");

	public RMIScriptureGUIScreen(RMIScriptureGUIMenu container, Inventory inventory, Component text) {
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
		if (NextPageButtonDisplayRMIProcedure.execute(entity))
			if (mouseX > leftPos + 206 && mouseX < leftPos + 230 && mouseY > topPos + 150 && mouseY < topPos + 174) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.survival_reimagined.rmi_scripture_gui.tooltip_next_page"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (PreviousPageButtonDisplayRMIProcedure.execute(entity))
			if (mouseX > leftPos + -51 && mouseX < leftPos + -27 && mouseY > topPos + 150 && mouseY < topPos + 174) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.survival_reimagined.rmi_scripture_gui.tooltip_previous_page"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -66, this.topPos + -12, 0, 0, 304, 192, 304, 192);
		guiGraphics.blit(IMAGE_1, this.leftPos + -66, this.topPos + -11, 0, 0, 304, 192, 304, 192);
		guiGraphics.blit(IMAGE_2, this.leftPos + -33, this.topPos + 16, 0, 0, 48, 16, 48, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 26, this.topPos + 17, 0, 0, 32, 16, 32, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 44, this.topPos + 128, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_5, this.leftPos + 52, this.topPos + 134, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_6, this.leftPos + -39, this.topPos + 43, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_7, this.leftPos + 1, this.topPos + 43, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_8, this.leftPos + 40, this.topPos + 43, 0, 0, 32, 32, 32, 32);
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
				new WidgetSprites(ResourceLocation.parse("survival_reimagined:textures/screens/next_page_button.png"), ResourceLocation.parse("survival_reimagined:textures/screens/next_page_button.png")), e -> {
					int x = RMIScriptureGUIScreen.this.x;
					int y = RMIScriptureGUIScreen.this.y;
					if (NextPageButtonDisplayProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new RMIScriptureGUIButtonMessage(0, x, y, z));
						RMIScriptureGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = RMIScriptureGUIScreen.this.x;
				int y = RMIScriptureGUIScreen.this.y;
				if (NextPageButtonDisplayProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_next_page_button_unhovered);
		imagebutton_previous_page_button_unhovered = new ImageButton(this.leftPos + -51, this.topPos + 150, 16, 16,
				new WidgetSprites(ResourceLocation.parse("survival_reimagined:textures/screens/previous_page_button.png"), ResourceLocation.parse("survival_reimagined:textures/screens/previous_page_button.png")), e -> {
					int x = RMIScriptureGUIScreen.this.x;
					int y = RMIScriptureGUIScreen.this.y;
					if (PreviousPageButtonDisplayProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new RMIScriptureGUIButtonMessage(1, x, y, z));
						RMIScriptureGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = RMIScriptureGUIScreen.this.x;
				int y = RMIScriptureGUIScreen.this.y;
				if (PreviousPageButtonDisplayProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_previous_page_button_unhovered);
	}
}