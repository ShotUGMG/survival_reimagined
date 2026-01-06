package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class RadiatedSaplingBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 0.5, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.RADIATED_SAPLING.get())) {
			return true;
		}
		return false;
	}
}