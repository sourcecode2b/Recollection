package net.mcreator.recollection.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.recollection.entity.SeekerEntity;
import net.mcreator.recollection.RecollectionMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DetectifseekeristhereProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(SeekerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(15 / 2d), e -> true).isEmpty()) {
			RecollectionMod.queueServerWork(60, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			});
			RecollectionMod.queueServerWork(60, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			});
			RecollectionMod.queueServerWork(60, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			});
			RecollectionMod.queueServerWork(60, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + Mth.nextInt(RandomSource.create(), -10, 10), z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:seekerscream")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			});
		}
	}
}