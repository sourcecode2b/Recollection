package net.mcreator.recollection.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.recollection.init.RecollectionModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Spawnstructuresign23Procedure {
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
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("recollection", "youbetrayedus"));
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