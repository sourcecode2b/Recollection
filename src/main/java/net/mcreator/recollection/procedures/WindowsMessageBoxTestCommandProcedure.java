package net.mcreator.recollection.procedures;

import net.minecraft.commands.CommandSourceStack;

import net.mcreator.recollection.WindowsMessageBox;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

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