package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class WindowShakeTestCommandProcedure {
	public static void execute() {
		WindowShakeHandler.shake(20, 15f);
	}
}