package net.mcreator.survivalreimagined.block;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.procedures.DarkCinderOnRandomClientDisplayTickProcedure;

public class DarkCinderBlock extends Block {
	public DarkCinderBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(0.3f));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
		super.animateTick(blockstate, world, pos, random);
		DarkCinderOnRandomClientDisplayTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}