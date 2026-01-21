package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class HempBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:farmland"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.HEMP.get())) {
			return true;
		}
		return false;
	}
}