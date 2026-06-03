/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.recollection.block.VoideBlock;
import net.mcreator.recollection.block.HeartBlock;
import net.mcreator.recollection.block.CollectedBlock;
import net.mcreator.recollection.RecollectionMod;

public class RecollectionModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RecollectionMod.MODID);
	public static final RegistryObject<Block> VOIDE = REGISTRY.register("voide", () -> new VoideBlock());
	public static final RegistryObject<Block> COLLECTED = REGISTRY.register("collected", () -> new CollectedBlock());
	public static final RegistryObject<Block> HEART = REGISTRY.register("heart", () -> new HeartBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}