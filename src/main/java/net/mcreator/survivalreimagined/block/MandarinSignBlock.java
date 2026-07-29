package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;

public class MandarinSignBlock extends StandingSignBlock {
	public MandarinSignBlock() {
		super(SurvivalReimaginedModWoodTypes.MANDARIN_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.CHERRY_WOOD).strength(2f, 3f).forceSolidOn());
	}
}