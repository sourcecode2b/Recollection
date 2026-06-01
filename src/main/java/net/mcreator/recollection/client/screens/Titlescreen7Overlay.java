package net.mcreator.recollection.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.recollection.procedures.TitlescreenoverlayshowProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class Titlescreen7Overlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof TitleScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			if (TitlescreenoverlayshowProcedure.execute()) {
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.recollection.titlescreen_7.label_leave_the_game"), w - 402, 82, -65536, false);
			}
		}
	}
}