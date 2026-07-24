package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class HangingRadiatedWallSignBlock extends WallHangingSignBlock {
	public HangingRadiatedWallSignBlock() {
		super(SurvivalReimaginedModWoodTypes.HANGING_RADIATED_SIGN_WOOD_TYPE,
				BlockBehaviour.Properties.of().sound(SoundType.NETHER_WOOD_HANGING_SIGN).strength(2f, 3f).noCollission().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn().dropsLike(SurvivalReimaginedModBlocks.HANGING_RADIATED_SIGN.get()));
	}
}