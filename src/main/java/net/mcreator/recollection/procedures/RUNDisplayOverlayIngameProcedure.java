package net.mcreator.recollection.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.recollection.entity.SeekerEntity;

public class RUNDisplayOverlayIngameProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(SeekerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(15 / 2d), e -> true).isEmpty()) {
			if (Math.random() > 0.99) {
				return true;
			}
		}
		return false;
	}
}