package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class NitreBlockBlock extends Block {
	public NitreBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(1.5f, 6f));
	}
}