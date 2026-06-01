package net.mcreator.recollection.procedures;

import net.mcreator.recollection.ScreenShakeHandler;

public class ScreenShakeTestCommandProcedure {
	public static void execute() {
		ScreenShakeHandler.shake(20, 2.0f);
	}
}