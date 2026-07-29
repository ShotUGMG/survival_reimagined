package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class MandarinPlanksSlabBlock extends SlabBlock {
	public MandarinPlanksSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f));
	}
}