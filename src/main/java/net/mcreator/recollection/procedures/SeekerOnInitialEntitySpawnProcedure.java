package net.mcreator.recollection.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.recollection.init.RecollectionModGameRules;

public class SeekerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.995) {
			if (world.getLevelData().getGameRules().getBoolean(RecollectionModGameRules.GRACEFUL) == false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeAllEffects();
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}