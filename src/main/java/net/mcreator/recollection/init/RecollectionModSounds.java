/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.recollection.RecollectionMod;

public class RecollectionModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RecollectionMod.MODID);
	public static final RegistryObject<SoundEvent> NOTIFICATION = REGISTRY.register("notification", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("recollection", "notification")));
}