package net.mcreator.recollection.client.gui;

import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.Util;

import net.mcreator.recollection.world.inventory.UnknownActivityMenu;
import net.mcreator.recollection.network.UnknownActivityButtonMessage;
import net.mcreator.recollection.init.RecollectionModScreens;
import net.mcreator.recollection.RecollectionMod;

import com.mojang.blaze3d.systems.RenderSystem;

import java.util.Random;

public class UnknownActivityScreen extends AbstractContainerScreen<UnknownActivityMenu> implements RecollectionModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_cancel;
	Button button_proceed;

	private final Random rng = new Random();
	private boolean glitching = false;
	private float glitchIntensity = 0f;
	private final float[] bandOffsets = new float[16];
	private float colorR = 1f, colorG = 1f, colorB = 1f;
	private long nextGlitchAt = 0L;

	private static final ResourceLocation texture = ResourceLocation.parse("recollection:textures/screens/unknown_activity.png");

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

	private void tickGlitch() {
		long now = Util.getMillis();

		if (now >= nextGlitchAt) {
			glitching = rng.nextFloat() < 0.50f;

			if (glitching) {
				glitchIntensity = 4f + rng.nextFloat() * 12f;

				if (rng.nextFloat() < 0.55f) {
					colorR = 0.85f + rng.nextFloat() * 0.45f;
					colorG = 0.65f + rng.nextFloat() * 0.25f;
					colorB = 0.60f + rng.nextFloat() * 0.20f;
				} else {
					colorR = colorG = colorB = 1f;
				}

				nextGlitchAt = now + 50 + rng.nextInt(160);
			} else {
				glitchIntensity = 0f;
				colorR = colorG = colorB = 1f;
				nextGlitchAt = now + 200 + rng.nextInt(700);
			}
		}

		if (glitching) {
			for (int i = 0; i < bandOffsets.length; i++) {
				if (rng.nextFloat() < 0.35f) {
					bandOffsets[i] = rng.nextFloat() < 0.4f ? (rng.nextFloat() - 0.5f) * 2f * glitchIntensity : 0f;
				}
			}
		} else {
			for (int i = 0; i < bandOffsets.length; i++) {
				bandOffsets[i] = Mth.lerp(0.2f, bandOffsets[i], 0f);
			}
		}
	}

	private void blitBanded(GuiGraphics g, ResourceLocation tex, int xBase, int yBase, int w, int h) {
		for (int i = 0; i < bandOffsets.length; i++) {
			int v0 = i * h / bandOffsets.length;
			int v1 = (i == bandOffsets.length - 1) ? h : (i + 1) * h / bandOffsets.length;
			int segH = v1 - v0;
			int xOff = glitching ? (int) bandOffsets[i] : 0;
			g.blit(tex, xBase + xOff, yBase + v0, 0, v0, w, segH, w, h);
		}
	}

	private void renderScanlineNoise(GuiGraphics g) {
		if (!glitching)
			return;
		for (int i = 0; i < 1 + rng.nextInt(5); i++) {
			if (rng.nextFloat() > 0.6f)
				continue;
			int ny = this.topPos + rng.nextInt(this.imageHeight);
			int nh = 1 + rng.nextInt(3);
			int alpha = 30 + rng.nextInt(130);
			int color = rng.nextBoolean() ? ((alpha << 24) | 0xFFFFFF) : ((alpha << 24) | 0x000000);
			g.fill(this.leftPos, ny, this.leftPos + this.imageWidth, ny + nh, color);
		}
	}

	private void renderSubtleStatic(GuiGraphics g) {
		if (rng.nextFloat() > 0.35f)
			return;
		for (int i = 0; i < 1 + rng.nextInt(3); i++) {
			int nx = this.leftPos + rng.nextInt(this.imageWidth);
			int ny = this.topPos + rng.nextInt(this.imageHeight);
			int sz = 1 + rng.nextInt(2);
			int alpha = 15 + rng.nextInt(55);
			g.fill(nx, ny, nx + sz, ny + sz, (alpha << 24) | 0xFFFFFF);
		}
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		tickGlitch();
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		float alpha = (glitching && rng.nextFloat() < 0.12f) ? 0.80f + rng.nextFloat() * 0.15f : 1f;

		RenderSystem.setShaderColor(colorR, colorG, colorB, alpha);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		blitBanded(guiGraphics, texture, this.leftPos, this.topPos, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderColor(colorR, colorG, colorB, alpha);
		blitBanded(guiGraphics, ResourceLocation.parse("recollection:textures/screens/end_poem_background.png"), this.leftPos + 11, this.topPos + 3, 427, 240);

		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		guiGraphics.blit(ResourceLocation.parse("recollection:textures/screens/13530476-cover_xl.png"), this.leftPos - 66, this.topPos - 527, 0, 0, -1, -1, -1, -1);

		renderScanlineNoise(guiGraphics);
		renderSubtleStatic(guiGraphics);

		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
	}

	private String corruptText(String input) {
		if (!glitching || rng.nextFloat() > 0.5f)
			return input;
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (rng.nextFloat() < 0.12f)
				chars[i] = (char) (rng.nextInt(94) + 33);
		}
		return new String(chars);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.recollection.unknown_activity.label_empty"), 33, 20, -1, false);

		String rawBody = Component.translatable("gui.recollection.unknown_activity.label_is_it_true_you_wish_to_proceed").getString();
		guiGraphics.drawString(this.font, Component.literal(corruptText(rawBody)), 33, 38, -1, false);
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
	public void init() {
		super.init();
		button_cancel = Button.builder(Component.translatable("gui.recollection.unknown_activity.button_cancel"), e -> {
			int x = UnknownActivityScreen.this.x;
			int y = UnknownActivityScreen.this.y;
			if (true) {
				RecollectionMod.PACKET_HANDLER.sendToServer(new UnknownActivityButtonMessage(0, x, y, z));
				UnknownActivityButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 210, 56, 20).build();
		this.addRenderableWidget(button_cancel);

		button_proceed = Button.builder(Component.translatable("gui.recollection.unknown_activity.button_proceed"), e -> {
			int x = UnknownActivityScreen.this.x;
			int y = UnknownActivityScreen.this.y;
			if (true) {
				RecollectionMod.PACKET_HANDLER.sendToServer(new UnknownActivityButtonMessage(1, x, y, z));
				UnknownActivityButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 352, this.topPos + 210, 77, 20).build();
		this.addRenderableWidget(button_proceed);
	}
}