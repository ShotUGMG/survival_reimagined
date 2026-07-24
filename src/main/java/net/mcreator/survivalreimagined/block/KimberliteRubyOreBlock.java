package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class KimberliteRubyOreBlock extends Block {
	public KimberliteRubyOreBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 7f).requiresCorrectToolForDrops());
	}
}