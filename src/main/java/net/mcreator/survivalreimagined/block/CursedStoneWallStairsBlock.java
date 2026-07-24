package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;

public class CursedStoneWallStairsBlock extends StairBlock {
	public CursedStoneWallStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().strength(-1, 3600000));
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}
}