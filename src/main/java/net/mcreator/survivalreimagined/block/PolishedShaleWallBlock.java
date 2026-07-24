package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;

public class PolishedShaleWallBlock extends WallBlock {
	public PolishedShaleWallBlock() {
		super(BlockBehaviour.Properties.of().strength(1.5f, 6f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}
}