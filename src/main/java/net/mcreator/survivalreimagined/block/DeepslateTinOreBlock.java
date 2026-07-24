package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class DeepslateTinOreBlock extends Block {
	public DeepslateTinOreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(3.5f, 2f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}