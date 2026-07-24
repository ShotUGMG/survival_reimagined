package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfAmberBlock extends Block {
	public BlockOfAmberBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5f, 6f));
	}
}