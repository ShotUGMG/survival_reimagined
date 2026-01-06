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

import net.mcreator.survivalreimagined.world.inventory.RMIMenu;
import net.mcreator.survivalreimagined.procedures.DisplayButtonProcedure;
import net.mcreator.survivalreimagined.network.RMIButtonMessage;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RMIScreen extends AbstractContainerScreen<RMIMenu> implements SurvivalReimaginedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_rmi_button;

	public RMIScreen(RMIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("survival_reimagined:textures/screens/rmi.png");

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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/rune_putline.png"), this.leftPos + 80, this.topPos + 41, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/lapis_outline.png"), this.leftPos + 116, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("survival_reimagined:textures/screens/rmi_unpressable.png"), this.leftPos + 72, this.topPos + 61, 0, 0, 32, 16, 32, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.survival_reimagined.rmi.label_rune_magic_infuser"), 39, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_rmi_button = new ImageButton(this.leftPos + 72, this.topPos + 61, 32, 16,
				new WidgetSprites(ResourceLocation.parse("survival_reimagined:textures/screens/rmi_button.png"), ResourceLocation.parse("survival_reimagined:textures/screens/rmi_hovered.png")), e -> {
					int x = RMIScreen.this.x;
					int y = RMIScreen.this.y;
					if (DisplayButtonProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new RMIButtonMessage(0, x, y, z));
						RMIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = RMIScreen.this.x;
				int y = RMIScreen.this.y;
				if (DisplayButtonProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_rmi_button);
	}
}