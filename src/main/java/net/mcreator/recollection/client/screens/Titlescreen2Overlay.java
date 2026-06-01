package net.mcreator.recollection.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.recollection.procedures.TitlescreenoverlayshowProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class Titlescreen2Overlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
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
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.recollection.titlescreen_2.label_leave_the_game"), 4, h - 13, -65536, false);
		}
	}
}