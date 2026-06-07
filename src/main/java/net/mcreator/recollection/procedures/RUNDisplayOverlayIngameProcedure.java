package net.mcreator.recollection.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.recollection.entity.SeekerEntity;

public class RUNDisplayOverlayIngameProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(SeekerEntity.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (Math.random() > 0.99) {
				return true;
			}
		}
		return false;
	}
}