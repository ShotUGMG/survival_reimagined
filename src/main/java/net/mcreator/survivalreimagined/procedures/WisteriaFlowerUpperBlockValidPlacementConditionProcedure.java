package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class WisteriaFlowerUpperBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.WISTERIA_FLOWER_UPPER.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.WISTERIA_FLOWER_LOWER.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
			return true;
		}
		return false;
	}
}
