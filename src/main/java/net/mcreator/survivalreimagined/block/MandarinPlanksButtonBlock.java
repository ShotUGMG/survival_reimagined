package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class MandarinPlanksButtonBlock extends ButtonBlock {
	public MandarinPlanksButtonBlock() {
		super(BlockSetType.OAK, 30, BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f));
	}
}