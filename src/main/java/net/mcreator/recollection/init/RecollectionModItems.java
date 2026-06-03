/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.recollection.RecollectionMod;

public class RecollectionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RecollectionMod.MODID);
	public static final RegistryObject<Item> VOIDE = block(RecollectionModBlocks.VOIDE);
	public static final RegistryObject<Item> COLLECTED = block(RecollectionModBlocks.COLLECTED);
	public static final RegistryObject<Item> SEEKER_SPAWN_EGG = REGISTRY.register("seeker_spawn_egg", () -> new ForgeSpawnEggItem(RecollectionModEntities.SEEKER, -16777216, -1, new Item.Properties()));
	public static final RegistryObject<Item> HEART = block(RecollectionModBlocks.HEART);
	public static final RegistryObject<Item> SNOWED_IN_SPAWN_EGG = REGISTRY.register("snowed_in_spawn_egg", () -> new ForgeSpawnEggItem(RecollectionModEntities.SNOWED_IN, -1, -16750849, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}