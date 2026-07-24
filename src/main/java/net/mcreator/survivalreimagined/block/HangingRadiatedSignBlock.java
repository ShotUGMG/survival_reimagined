package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.CeilingHangingSignBlock;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;

public class HangingRadiatedSignBlock extends CeilingHangingSignBlock {
	public HangingRadiatedSignBlock() {
		super(SurvivalReimaginedModWoodTypes.HANGING_RADIATED_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.NETHER_WOOD_HANGING_SIGN).strength(2f, 3f).noCollission().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}
}