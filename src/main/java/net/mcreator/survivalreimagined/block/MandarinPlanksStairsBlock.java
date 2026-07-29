package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class MandarinPlanksStairsBlock extends StairBlock {
	public MandarinPlanksStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f));
	}

	@Override
	public float getExplosionResistance() {
		return 3f;
	}
}