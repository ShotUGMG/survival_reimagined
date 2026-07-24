package net.mcreator.survivalreimagined.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.survivalreimagined.procedures.DisablePlacementFavorFarmersDelightProcedure;

public class WildBeetrootFeature extends RandomPatchFeature {
	public WildBeetrootFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!DisablePlacementFavorFarmersDelightProcedure.execute())
			return false;
		return super.place(context);
	}
}