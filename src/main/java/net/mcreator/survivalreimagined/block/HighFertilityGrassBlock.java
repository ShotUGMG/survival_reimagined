package net.mcreator.survivalreimagined.block;

import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.GrassColor;
import net.minecraft.client.renderer.BiomeColors;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class HighFertilityGrassBlock extends Block {
	public HighFertilityGrassBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.5f));
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
		}, SurvivalReimaginedModBlocks.HIGH_FERTILITY_GRASS.get());
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return GrassColor.get(0.5D, 1.0D);
		}, SurvivalReimaginedModBlocks.HIGH_FERTILITY_GRASS.get());
	}
}