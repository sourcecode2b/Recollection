package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TitlescreenoverlayshowProcedure {
	public static boolean execute() {
		if (Math.random() > 0.99) {
			return true;
		}
		return false;
	}
}