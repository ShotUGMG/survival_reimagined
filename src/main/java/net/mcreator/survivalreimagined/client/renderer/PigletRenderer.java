package net.mcreator.survivalreimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.survivalreimagined.entity.PigletEntity;
import net.mcreator.survivalreimagined.client.model.Modelpiglet;

public class PigletRenderer extends MobRenderer<PigletEntity, Modelpiglet<PigletEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("survival_reimagined:textures/entities/piglet.png");

	public PigletRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpiglet<PigletEntity>(context.bakeLayer(Modelpiglet.LAYER_LOCATION)), 0.25f);
	}

	@Override
	public ResourceLocation getTextureLocation(PigletEntity entity) {
		return entityTexture;
	}
}