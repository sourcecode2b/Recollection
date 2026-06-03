package net.mcreator.recollection.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.recollection.init.RecollectionModParticleTypes;
import net.mcreator.recollection.init.RecollectionModBlocks;
import net.mcreator.recollection.RecollectionMod;

public class SpawneyeballssurroundingyouProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.ADVENTURE);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cdid uoy tahw ta kool"), false);
		entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 500, 1));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 50));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 500, 1));
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