package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TinOreBlock extends Block {
	public TinOreBlock() {
		super(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}