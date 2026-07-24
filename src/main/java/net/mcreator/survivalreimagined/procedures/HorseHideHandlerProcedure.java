package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class HorseHideHandlerProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		// White
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WHITE_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.WHITE_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WHITE_HORSE_STOCKING.get()) {
			return new ItemStack(SurvivalReimaginedModItems.WHITE_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WHITE_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.WHITE_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WHITE_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.WHITE_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WHITE_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.WHITE_HORSE_HIDE_BLACK_DOTS.get());
		}
		// Creamy
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CREAMY_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CREAMY_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CREAMY_HORSE_STOCKINGS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CREAMY_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CREAMY_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CREAMY_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CREAMY_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CREAMY_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CREAMY_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CREAMY_HORSE_HIDE_BLACK_DOTS.get());
		}
		// Chestnut
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CHESTNUT_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CHESTNUT_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CHESTNUT_HORSE_STOCKINGS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CHESTNUT_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CHESTNUT_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CHESTNUT_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CHESTNUT_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CHESTNUT_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CHESTNUT_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.CHESTNUT_HORSE_HIDE_BLACK_DOTS.get());
		}
		// Brown
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BROWN_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BROWN_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BROWN_HORSE_STOCKINGS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BROWN_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BROWN_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BROWN_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BROWN_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BROWN_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BROWN_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BROWN_HORSE_HIDE_BLACK_DOTS.get());
		}
		// Dark Brown
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.DARK_BROWN_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.DARK_BROWN_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_STOCKINGS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.DARK_BROWN_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.DARK_BROWN_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.DARK_BROWN_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.DARK_BROWN_HORSE_HIDE_BLACK_DOTS.get());
		}
		// Gray
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.GRAY_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.GRAY_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.GRAY_HORSE_STOCKINGS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.GRAY_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.GRAY_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.GRAY_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.GRAY_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.GRAY_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.GRAY_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.GRAY_HORSE_HIDE_BLACK_DOTS.get());
		}
		// Black
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLACK_HORSE.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BLACK_HORSE_HIDE.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLACK_HORSE_STOCKINGS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BLACK_HORSE_HIDE_STOCKINGS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLACK_HORSE_FIELD.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BLACK_HORSE_HIDE_FIELD.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLACK_HORSE_WHITE_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BLACK_HORSE_HIDE_WHITE_DOTS.get());
		}
		else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLACK_HORSE_BLACK_DOTS.get()) {
			return new ItemStack(SurvivalReimaginedModItems.BLACK_HORSE_HIDE_BLACK_DOTS.get());
		}
		return ItemStack.EMPTY;
	}
}