package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SnowedInOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.996) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}