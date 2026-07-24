package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BasaltHematiteOreBlock extends Block {
	public BasaltHematiteOreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(1.25f, 4.2f).requiresCorrectToolForDrops());
	}
}