package net.mcreator.recollection.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.recollection.world.inventory.UnknownActivityMenu;
import net.mcreator.recollection.network.UnknownActivityButtonMessage;
import net.mcreator.recollection.init.RecollectionModScreens;
import net.mcreator.recollection.RecollectionMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class UnknownActivityScreen extends AbstractContainerScreen<UnknownActivityMenu> implements RecollectionModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_cancel;
	Button button_proceed;

	public UnknownActivityScreen(UnknownActivityMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 450;
		this.imageHeight = 247;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("recollection:textures/screens/unknown_activity.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("recollection:textures/screens/end_poem_background.png"), this.leftPos + 11, this.topPos + 3, 0, 0, 427, 240, 427, 240);
		guiGraphics.blit(ResourceLocation.parse("recollection:textures/screens/red-blood-cells.jpg.png"), this.leftPos + -68, this.topPos + 237, 0, 0, 760, 536, 760, 536);
		guiGraphics.blit(ResourceLocation.parse("recollection:textures/screens/red-blood-cells.jpg.png"), this.leftPos + 432, this.topPos + -57, 0, 0, 760, 536, 760, 536);
		guiGraphics.blit(ResourceLocation.parse("recollection:textures/screens/red-blood-cells.jpg.png"), this.leftPos + -66, this.topPos + -527, 0, 0, 760, 536, 760, 536);
		guiGraphics.blit(ResourceLocation.parse("recollection:textures/screens/red-blood-cells.jpg.png"), this.leftPos + -743, this.topPos + -33, 0, 0, 760, 536, 760, 536);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.recollection.unknown_activity.label_empty"), 33, 20, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.recollection.unknown_activity.label_is_it_true_you_wish_to_proceed"), 33, 38, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_cancel = Button.builder(Component.translatable("gui.recollection.unknown_activity.button_cancel"), e -> {
			int x = UnknownActivityScreen.this.x;
			int y = UnknownActivityScreen.this.y;
			if (true) {
				RecollectionMod.PACKET_HANDLER.sendToServer(new UnknownActivityButtonMessage(0, x, y, z));
				UnknownActivityButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 371, this.topPos + 213, 56, 20).build();
		this.addRenderableWidget(button_cancel);
		button_proceed = Button.builder(Component.translatable("gui.recollection.unknown_activity.button_proceed"), e -> {
			int x = UnknownActivityScreen.this.x;
			int y = UnknownActivityScreen.this.y;
			if (true) {
				RecollectionMod.PACKET_HANDLER.sendToServer(new UnknownActivityButtonMessage(1, x, y, z));
				UnknownActivityButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 31, this.topPos + 210, 77, 20).build();
		this.addRenderableWidget(button_proceed);
	}
}