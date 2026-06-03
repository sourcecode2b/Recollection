package net.mcreator.recollection.client.screens;

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

			if (

			TitlescreenoverlayshowProcedure.execute()

			) {

				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.recollection.titlescreen_7.label_leave_the_game"), w - 402, 82, -65536, false);

			}

		}
	}

}