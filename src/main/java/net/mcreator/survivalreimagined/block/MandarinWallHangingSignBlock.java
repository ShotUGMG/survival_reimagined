package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class MandarinWallHangingSignBlock extends WallHangingSignBlock {
	public MandarinWallHangingSignBlock() {
		super(SurvivalReimaginedModWoodTypes.MANDARIN_HANGING_SIGN_WOOD_TYPE,
				BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn().dropsLike(SurvivalReimaginedModBlocks.MANDARIN_HANGING_SIGN.get()));
	}
}