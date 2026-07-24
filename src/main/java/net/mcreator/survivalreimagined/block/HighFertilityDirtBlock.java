package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class HighFertilityDirtBlock extends Block {
	public HighFertilityDirtBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(0.5f));
	}
}