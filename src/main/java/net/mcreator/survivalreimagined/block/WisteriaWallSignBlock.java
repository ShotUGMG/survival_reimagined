package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class WisteriaWallSignBlock extends WallSignBlock {
	public WisteriaWallSignBlock() {
		super(SurvivalReimaginedModWoodTypes.WISTERIA_SIGN_WOOD_TYPE,
				BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).noCollission().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn().dropsLike(SurvivalReimaginedModBlocks.WISTERIA_SIGN.get()));
	}
}