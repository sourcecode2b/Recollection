/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecollectionModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> GRACEFUL = GameRules.register("graceful", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
}