package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.CeilingHangingSignBlock;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;

public class HangingWisteriaSignBlock extends CeilingHangingSignBlock {
	public HangingWisteriaSignBlock() {
		super(SurvivalReimaginedModWoodTypes.HANGING_WISTERIA_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).noCollission().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}
}