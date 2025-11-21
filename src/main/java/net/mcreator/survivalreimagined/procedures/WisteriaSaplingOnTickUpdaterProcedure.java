package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class WisteriaSaplingOnTickUpdaterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double TreeType = 0;
		TreeType = Mth.nextInt(RandomSource.create(), 1, 4);
		if (Math.random() < 0.2) {
			if (TreeType == 1) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_tree_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y, z - 3), BlockPos.containing(x - 8, y, z - 3), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				});
			} else if (TreeType == 2) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_tree_2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 3), BlockPos.containing(x - 6, y, z - 3), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				});
			} else if (TreeType == 3) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_tree_3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y, z - 5), BlockPos.containing(x - 3, y, z - 5), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				});
			} else if (TreeType == 4) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "wisteria_tree_4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y, z - 3), BlockPos.containing(x - 6, y, z - 3), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				});
			}
		}
	}
}
