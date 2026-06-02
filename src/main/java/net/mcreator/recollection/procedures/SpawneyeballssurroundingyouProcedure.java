package net.mcreator.recollection.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.recollection.init.RecollectionModParticleTypes;

public class SpawneyeballssurroundingyouProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), x, y, (z + 10), 1, 0, 0, 0, 0);
	}
}