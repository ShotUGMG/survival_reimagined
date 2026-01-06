package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class RadiatedSaplingOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.holderOrThrow(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse("survival_reimagined:radiated_tree"))).value().place(_level, _level.getChunkSource().getGenerator(), _level.getRandom(),
						BlockPos.containing(x, y, z));
		}
	}
}