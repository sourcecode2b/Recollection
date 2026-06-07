package net.mcreator.recollection.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ColdMobEffect extends MobEffect {
	public ColdMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16737844);
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}