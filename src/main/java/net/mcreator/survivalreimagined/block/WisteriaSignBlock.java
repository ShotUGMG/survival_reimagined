package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;

public class WisteriaSignBlock extends StandingSignBlock {
	public WisteriaSignBlock() {
		super(SurvivalReimaginedModWoodTypes.WISTERIA_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).noCollission().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}
}