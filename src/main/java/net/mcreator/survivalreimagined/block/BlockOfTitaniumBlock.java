package net.mcreator.survivalreimagined.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class BlockOfTitaniumBlock extends Block {
	public BlockOfTitaniumBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:block/steel_step"))))
				.strength(3f, 6f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}