package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ScreenShakeTestCommandProcedure {
	public static void execute() {
		ScreenShakeHandler.shake(20, 2.0f);
	}
}