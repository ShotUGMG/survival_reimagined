package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class MediumFertilityDirtBlock extends Block {
	public MediumFertilityDirtBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(0.5f));
	}
}