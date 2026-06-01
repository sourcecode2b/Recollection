package net.mcreator.recollection.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.recollection.init.RecollectionModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnvoidstructureProcedure {
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
			world.setBlock(BlockPos.containing(x, y, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 2, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 3, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 4, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 5, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 6, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 7, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 8, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 9, z + 30), RecollectionModBlocks.VOIDE.get().defaultBlockState(), 3);
		}
	}
}