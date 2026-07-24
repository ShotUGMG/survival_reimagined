package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class PureSaltBlockBlock extends Block {
	public PureSaltBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(2f).requiresCorrectToolForDrops());
	}
}