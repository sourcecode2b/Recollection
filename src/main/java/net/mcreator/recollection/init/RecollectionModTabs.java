/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.recollection.RecollectionMod;

public class RecollectionModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RecollectionMod.MODID);
	public static final RegistryObject<CreativeModeTab> RECOLLECTION = REGISTRY.register("recollection",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.recollection.recollection")).icon(() -> new ItemStack(RecollectionModBlocks.VOIDE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RecollectionModBlocks.VOIDE.get().asItem());
				tabData.accept(RecollectionModItems.SEEKER_SPAWN_EGG.get());
			}).build());
}