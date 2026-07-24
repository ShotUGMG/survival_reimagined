package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class SandSaltDepositBlock extends Block {
	public SandSaltDepositBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.ROOTED_DIRT).strength(0.7f));
	}
}