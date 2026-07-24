package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfTinBlock extends Block {
	public BlockOfTinBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.COPPER).strength(4f, 3f).requiresCorrectToolForDrops());
	}
}