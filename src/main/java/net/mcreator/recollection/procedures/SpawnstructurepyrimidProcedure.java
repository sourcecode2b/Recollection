package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class SpawnstructurepyrimidProcedure {
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
		if (Math.random() > 0.9999999) {
			if (world.getLevelData().getGameRules().getBoolean(RecollectionModGameRules.GRACEFUL) == false) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("recollection", "purimid"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - Mth.nextInt(RandomSource.create(), -500, 500), y - Mth.nextInt(RandomSource.create(), -300, 300), z - Mth.nextInt(RandomSource.create(), -500, 500)),
								BlockPos.containing(x - Mth.nextInt(RandomSource.create(), -500, 500), y - Mth.nextInt(RandomSource.create(), -300, 300), z - Mth.nextInt(RandomSource.create(), -500, 500)),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
			}
		}
	}
}