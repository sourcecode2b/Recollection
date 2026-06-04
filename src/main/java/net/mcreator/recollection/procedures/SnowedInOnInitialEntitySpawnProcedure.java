package net.mcreator.recollection.procedures;

import net.minecraft.world.entity.Entity;

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