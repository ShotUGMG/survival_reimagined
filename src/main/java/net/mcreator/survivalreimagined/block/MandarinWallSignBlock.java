package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class MandarinWallSignBlock extends WallSignBlock {
	public MandarinWallSignBlock() {
		super(SurvivalReimaginedModWoodTypes.MANDARIN_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).forceSolidOn().dropsLike(SurvivalReimaginedModBlocks.MANDARIN_SIGN.get()));
	}
}