package net.mcreator.survivalreimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.survivalreimagined.world.inventory.ForgeGUIMenu;
import net.mcreator.survivalreimagined.procedures.*;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ForgeGUIScreen extends AbstractContainerScreen<ForgeGUIMenu> implements SurvivalReimaginedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("survival_reimagined:textures/screens/forge_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_0.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_1.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_2.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_3.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_4.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_5.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_6.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_7.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_8.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_9.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_10.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_11.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_12.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_13.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("survival_reimagined:textures/screens/fuel_meter_14.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow2.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow3.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow4.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow5.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow6.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow7.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow8.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow9.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow10.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow11.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow12.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow13.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow14.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("survival_reimagined:textures/screens/arrow15.png");

	public ForgeGUIScreen(ForgeGUIMenu container, Inventory inventory, Component text) {
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
		if (DisplayTick14FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick13FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick12FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick11FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick10FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick9FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick8FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick7FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick6FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick5FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick4FuelTimerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick3FuelMeterProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick2FuelMeterProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick1FuelMeterProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick0FuelMeterProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 12, this.topPos + 50, 0, 0, 8, 29, 8, 29);
		}
		if (DisplayTick0BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick1BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick2BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick3BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick4BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick5BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick6BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick7BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick8BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick9BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick10BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick11BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick12BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick13BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTick14BurnTimeProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 112, this.topPos + 35, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.survival_reimagined.forge_gui.label_forge"), 75, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}