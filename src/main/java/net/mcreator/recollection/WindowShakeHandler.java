package net.mcreator.recollection;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import java.util.Random;

@Mod.EventBusSubscriber(modid = "recollection", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WindowShakeHandler {

	private static int shakeTicks = 0;
	private static int maxShakeTicks = 0;
	private static float shakeIntensity = 0f;

	private static int originalX = 0;
	private static int originalY = 0;
	private static boolean positionSaved = false;

	private static final Random RANDOM = new Random();

	public static void shake(int durationTicks, float intensityPixels) {
		if (!positionSaved) {
			savePosition();
		}
		shakeTicks = durationTicks;
		maxShakeTicks = durationTicks;
		shakeIntensity = intensityPixels;
	}

	public static void stop() {
		shakeTicks = 0;
		maxShakeTicks = 0;
		restorePosition();
	}

	public static boolean isShaking() {
		return shakeTicks > 0;
	}

	private static void savePosition() {
		long handle = getHandle();
		int[] x = new int[1], y = new int[1];
		GLFW.glfwGetWindowPos(handle, x, y);
		originalX = x[0];
		originalY = y[0];
		positionSaved = true;
	}

	private static void restorePosition() {
		if (positionSaved) {
			GLFW.glfwSetWindowPos(getHandle(), originalX, originalY);
			positionSaved = false;
		}
	}

	private static long getHandle() {
		return Minecraft.getInstance().getWindow().getWindow();
	}

	@SubscribeEvent
	public static void onRenderTick(TickEvent.RenderTickEvent event) {
		if (event.phase != TickEvent.Phase.START)
			return;
		if (shakeTicks <= 0 || maxShakeTicks <= 0)
			return;

		float fade = (float) shakeTicks / (float) maxShakeTicks;
		float strength = shakeIntensity * fade;

		int offsetX = Math.round((RANDOM.nextFloat() * 2f - 1f) * strength);
		int offsetY = Math.round((RANDOM.nextFloat() * 2f - 1f) * strength);

		GLFW.glfwSetWindowPos(getHandle(), originalX + offsetX, originalY + offsetY);
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		if (shakeTicks <= 0)
			return;

		shakeTicks--;
		if (shakeTicks == 0) {
			restorePosition();
		}
	}
}