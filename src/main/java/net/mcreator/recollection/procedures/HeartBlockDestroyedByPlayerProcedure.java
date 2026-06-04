package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class HeartBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		WindowsMessageBox.warn("lost souls", "your grace has been lost");
		world.getLevelData().getGameRules().getRule(RecollectionModGameRules.HEARTNEEDTOBE_DESTROYIED).set(false, world.getServer());
		world.getLevelData().getGameRules().getRule(RecollectionModGameRules.GRACEFUL).set(false, world.getServer());
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.ADVENTURE);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7did uoy tahw ta kool"), false);
		entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 1));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 50));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 300, 1));
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, (z + 10)));
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), x, y, (z + 10), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 1), y, (z + 9), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 2), y, (z + 8), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 3), y, (z + 7), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 4), y, (z + 6), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 5), y, (z + 5), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 6), y, (z + 4), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 7), y, (z + 3), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 8), y, (z + 2), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 9), y, (z + 1), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x - 10), y, (z + 0), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), x, y, (z + 10), 1, 0, 1, 2, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 1), y, (z + 9), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 2), y, (z + 8), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 3), y, (z + 7), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 4), y, (z + 6), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 5), y, (z + 5), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 6), y, (z + 4), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 7), y, (z + 3), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 8), y, (z + 2), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 9), y, (z + 1), 1, 0, 2, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (RecollectionModParticleTypes.EYEBALL.get()), (x + 10), y, (z + 0), 1, 0, 2, 0, 0);
		RecollectionMod.queueServerWork(100, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7ceciohc gnorw eht edam"), false);
		});
		RecollectionMod.queueServerWork(110, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(120, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(130, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			world.setBlock(BlockPos.containing(x, y - 3, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 3, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 3, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 3, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 3, z - 1), Blocks.AIR.defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(140, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			world.setBlock(BlockPos.containing(x, y - 4, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 4, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 4, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 4, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 4, z - 1), Blocks.AIR.defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(150, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			world.setBlock(BlockPos.containing(x, y - 5, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 5, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 5, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 5, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 5, z - 1), Blocks.AIR.defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(160, () -> {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			world.setBlock(BlockPos.containing(x, y - 6, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 6, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 6, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 6, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 6, z - 1), Blocks.AIR.defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(170, () -> {
			world.setBlock(BlockPos.containing(x, y - 6, z), RecollectionModBlocks.COLLECTED.get().defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(170, () -> {
			world.setBlock(BlockPos.containing(x + 1, y - 6, z), RecollectionModBlocks.COLLECTED.get().defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(170, () -> {
			world.setBlock(BlockPos.containing(x - 1, y - 6, z), RecollectionModBlocks.COLLECTED.get().defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(170, () -> {
			world.setBlock(BlockPos.containing(x, y - 6, z + 1), RecollectionModBlocks.COLLECTED.get().defaultBlockState(), 3);
		});
		RecollectionMod.queueServerWork(170, () -> {
			world.setBlock(BlockPos.containing(x, y - 6, z - 1), RecollectionModBlocks.COLLECTED.get().defaultBlockState(), 3);
		});
	}
}