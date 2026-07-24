package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class DeepslatePyrolusiteOreBlock extends Block {
	public DeepslatePyrolusiteOreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(4.5f, 3f).requiresCorrectToolForDrops());
	}
}