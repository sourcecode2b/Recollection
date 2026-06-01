package net.mcreator.recollection.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.recollection.init.RecollectionModGameRules;
import net.mcreator.recollection.init.RecollectionModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnvcollectedportalProcedure {
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
		if (Math.random() > 0.99999999) {
			if (world.getLevelData().getGameRules().getBoolean(RecollectionModGameRules.GRACEFUL) == false) {
				world.setBlock(BlockPos.containing(x - Mth.nextInt(RandomSource.create(), -500, 500), y - Mth.nextInt(RandomSource.create(), -300, 300), z - Mth.nextInt(RandomSource.create(), -500, 500)),
						RecollectionModBlocks.COLLECTED.get().defaultBlockState(), 3);
			} else {
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 1));
			}
		}
	}
}