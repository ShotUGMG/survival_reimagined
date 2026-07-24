package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class KimberliteDiamondOreBlock extends Block {
	public KimberliteDiamondOreBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 7f).requiresCorrectToolForDrops());
	}
}