package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class WindowsMessageBoxTestCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if ((StringArgumentType.getString(arguments, "windows_message_box")).equals("show")) {
			WindowsMessageBox.show("Recollection", "This is a normal test.");
		} else if ((StringArgumentType.getString(arguments, "windows_message_box")).equals("warn")) {
			WindowsMessageBox.warn("Recollection", "This is a warn test.");
		} else if ((StringArgumentType.getString(arguments, "windows_message_box")).equals("error")) {
			WindowsMessageBox.error("Recollection", "This is a error test.");
		}
	}
}