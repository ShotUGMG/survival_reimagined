package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class EmbeddedObsidianBlock extends Block {
	public EmbeddedObsidianBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(5f).requiresCorrectToolForDrops());
	}
}