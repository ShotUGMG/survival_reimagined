
package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class DeepslateUranophaneOreBlock extends FallingBlock {
	public static final MapCodec<DeepslateUranophaneOreBlock> CODEC = simpleCodec(properties -> new DeepslateUranophaneOreBlock());

	public MapCodec<DeepslateUranophaneOreBlock> codec() {
		return CODEC;
	}

	public DeepslateUranophaneOreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(4.5f, 3f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
