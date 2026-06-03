/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.recollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.recollection.entity.SnowedInEntity;
import net.mcreator.recollection.entity.SeekerEntity;
import net.mcreator.recollection.RecollectionMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecollectionModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RecollectionMod.MODID);
	public static final RegistryObject<EntityType<SnowedInEntity>> SNOWED_IN = register("snowed_in",
			EntityType.Builder.<SnowedInEntity>of(SnowedInEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SnowedInEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SeekerEntity>> SEEKER = register("seeker",
			EntityType.Builder.<SeekerEntity>of(SeekerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SeekerEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SnowedInEntity.init();
			SeekerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SNOWED_IN.get(), SnowedInEntity.createAttributes().build());
		event.put(SEEKER.get(), SeekerEntity.createAttributes().build());
	}
}