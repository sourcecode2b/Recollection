package net.mcreator.recollection;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = "recollection", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ScreenShakeHandler {

	private static int shakeTicks = 0;
	private static int maxShakeTicks = 0;
	private static float shakeIntensity = 0f;

	private static final Random RANDOM = new Random();

	public static void shake(int durationTicks, float intensity) {
		shakeTicks = durationTicks;
		maxShakeTicks = durationTicks;
		shakeIntensity = intensity;
	}

	public static void stop() {
		shakeTicks = 0;
		maxShakeTicks = 0;
	}

	public static boolean isShaking() {
		return shakeTicks > 0;
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.END && shakeTicks > 0) {
			shakeTicks--;
		}
	}

	@SubscribeEvent
	public static void onCameraAngles(ViewportEvent.ComputeCameraAngles event) {
		if (shakeTicks <= 0 || maxShakeTicks <= 0)
			return;

		float fade = (float) shakeTicks / (float) maxShakeTicks;
		float strength = shakeIntensity * fade;

		float randYaw = (RANDOM.nextFloat() * 2f - 1f) * strength;
		float randPitch = (RANDOM.nextFloat() * 2f - 1f) * strength * 0.6f;
		float randRoll = (RANDOM.nextFloat() * 2f - 1f) * strength * 0.3f;

		event.setYaw(event.getYaw() + randYaw);
		event.setPitch(event.getPitch() + randPitch);
		event.setRoll(event.getRoll() + randRoll);
	}
}