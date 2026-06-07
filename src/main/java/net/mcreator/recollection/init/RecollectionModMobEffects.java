/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.recollection.potion.ColdMobEffect;
import net.mcreator.recollection.RecollectionMod;

public class RecollectionModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RecollectionMod.MODID);
	public static final RegistryObject<MobEffect> COLD = REGISTRY.register("cold", () -> new ColdMobEffect());
}