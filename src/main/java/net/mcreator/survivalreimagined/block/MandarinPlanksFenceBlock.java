package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class MandarinPlanksFenceBlock extends FenceBlock {
	public MandarinPlanksFenceBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).forceSolidOn());
	}
}