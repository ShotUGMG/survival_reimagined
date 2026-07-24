package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModWoodTypes;

public class RadiatedSignBlock extends StandingSignBlock {
	public RadiatedSignBlock() {
		super(SurvivalReimaginedModWoodTypes.RADIATED_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.NETHER_WOOD).strength(2f, 3f).noCollission().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}
}