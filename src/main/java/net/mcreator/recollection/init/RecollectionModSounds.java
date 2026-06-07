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
	public static final RegistryObject<SoundEvent> SEEKERSCREAM = REGISTRY.register("seekerscream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("recollection", "seekerscream")));
	public static final RegistryObject<SoundEvent> SNOWABEINCE = REGISTRY.register("snowabeince", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("recollection", "snowabeince")));
}