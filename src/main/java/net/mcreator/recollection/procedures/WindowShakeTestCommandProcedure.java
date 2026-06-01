package net.mcreator.recollection.procedures;

import net.mcreator.recollection.WindowShakeHandler;

public class WindowShakeTestCommandProcedure {
	public static void execute() {
		WindowShakeHandler.shake(20, 15f);
	}
}