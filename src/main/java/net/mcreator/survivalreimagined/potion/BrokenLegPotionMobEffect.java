package net.mcreator.survivalreimagined.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class BrokenLegPotionMobEffect extends MobEffect {
	public BrokenLegPotionMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:limb_remove")));
	}
}