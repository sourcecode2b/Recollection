package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class ListentothebadguyProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(ResourceLocation.parse("recollection:him"))).isDone()) == false) {
			RecollectionMod.queueServerWork(8000, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7c?su evas ot tnaw uoy od"), false);
			});
			RecollectionMod.queueServerWork(8100, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7ctraeh eht yortsed si od ot deen uoy lla"), false);
			});
			RecollectionMod.queueServerWork(8500, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cdetrats uoy erehw ot kcab og"), false);
			});
			RecollectionMod.queueServerWork(320, () -> {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 3, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 4, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 5, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 6, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 7, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 8, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 9, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 10, z), Blocks.COBBLESTONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 11, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - 50, z), RecollectionModBlocks.HEART.get().defaultBlockState(), 3);
				RecollectionMod.queueServerWork(8600, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cskcolb 05 nwod gid dna"), false);
				});
				RecollectionMod.queueServerWork(8650, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7couy rof ti dekram i"), false);
				});
				RecollectionMod.queueServerWork(8700, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7ctraeh eht kaerb ot deen lliw uoy neht"), false);
				});
				RecollectionMod.queueServerWork(8800, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7csu evas dna"), false);
				});
				RecollectionMod.queueServerWork(360, () -> {
					WindowsMessageBox.show("???", "break the heart.");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:notification")), SoundSource.MUSIC, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("recollection:notification")), SoundSource.MUSIC, 1, 1, false);
						}
					}
				});
			});
		} else {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(1);
		}
	}
}