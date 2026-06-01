package net.mcreator.recollection;

import com.sun.jna.Native;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinDef.HWND;

import javax.swing.*;

public class WindowsMessageBox {

	private interface User32 extends com.sun.jna.Library {
		User32 INSTANCE = Native.load("user32", User32.class);

		int MessageBoxW(HWND hWnd, WString text, WString caption, int uType);
	}

	private static final int MB_OK = 0x00000000;
	private static final int MB_ICONINFORMATION = 0x00000040;
	private static final int MB_ICONWARNING = 0x00000030;
	private static final int MB_ICONERROR = 0x00000010;

	public static void show(String title, String message) {
		open(title, message, MB_OK | MB_ICONINFORMATION);
	}

	public static void warn(String title, String message) {
		open(title, message, MB_OK | MB_ICONWARNING);
	}

	public static void error(String title, String message) {
		open(title, message, MB_OK | MB_ICONERROR);
	}

	private static void open(String title, String message, int flags) {
		Thread t = new Thread(() -> {
			if (isWindows()) {
				try {
					User32.INSTANCE.MessageBoxW(null, new WString(message), new WString(title), flags);
					return;
				} catch (Throwable ignored) {
				}
			}
			swingFallback(title, message, flags);
		}, "recollection-dialog");
		t.setDaemon(true);
		t.start();
	}

	private static void swingFallback(String title, String message, int flags) {
		int type;
		if ((flags & MB_ICONWARNING) != 0) {
			type = JOptionPane.WARNING_MESSAGE;
		} else if ((flags & MB_ICONERROR) != 0) {
			type = JOptionPane.ERROR_MESSAGE;
		} else {
			type = JOptionPane.INFORMATION_MESSAGE;
		}
		JOptionPane.showMessageDialog(null, message, title, type);
	}

	private static boolean isWindows() {
		return System.getProperty("os.name", "").toLowerCase().contains("win");
	}
}