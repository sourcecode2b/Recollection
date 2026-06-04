package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SnowedInOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (Math.random() > 0.8) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}