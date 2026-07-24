package net.mcreator.survivalreimagined.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;

import com.mojang.serialization.MapCodec;

public class NitrePowderBlock extends FallingBlock {
	public static final MapCodec<NitrePowderBlock> CODEC = simpleCodec(properties -> new NitrePowderBlock());

	public MapCodec<NitrePowderBlock> codec() {
		return CODEC;
	}

	public NitrePowderBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(0.5f));
	}
}