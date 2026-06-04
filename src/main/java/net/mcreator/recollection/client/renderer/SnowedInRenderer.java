package net.mcreator.recollection.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.recollection.entity.SnowedInEntity;
import net.mcreator.recollection.client.model.Modelsnowedvictim;

public class SnowedInRenderer extends MobRenderer<SnowedInEntity, Modelsnowedvictim<SnowedInEntity>> {
	public SnowedInRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsnowedvictim<SnowedInEntity>(context.bakeLayer(Modelsnowedvictim.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SnowedInEntity entity) {
		return ResourceLocation.parse("recollection:textures/entities/snowy-steve-with-eyes_2.png");
	}

	@Override
	protected boolean isShaking(SnowedInEntity entity) {
		return true;
	}
}