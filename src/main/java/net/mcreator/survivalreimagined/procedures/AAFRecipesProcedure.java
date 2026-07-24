package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class AAFRecipesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy")))
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy")))) {
			AAFPlatedDiamondProcedure.execute(world, x, y, z);
			AAFNetheriteProcedure.execute(world, x, y, z);
			AAFTuraniteProcedure.execute(world, x, y, z);
			AAFBronzeProcedure.execute(world, x, y, z);
			AAFStealProcedure.execute(world, x, y, z);
		}
		if (ModList.get().isLoaded("create")) {
			AAFBrassProcedure.execute(world, x, y, z);
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()) {
			AAFManganeseBlockProcedure.execute(world, x, y, z);
			AAFRedstoneBlockProcedure.execute(world, x, y, z);
			AAFUraniniteBlockProcedure.execute(world, x, y, z);
			AAFTitaniumBlockProcedure.execute(world, x, y, z);
			AAFCopperBlockProcedure.execute(world, x, y, z);
			AAFGoldBlockProcedure.execute(world, x, y, z);
			AAFIronBlockProcedure.execute(world, x, y, z);
			AAFTinBlockProcedure.execute(world, x, y, z);
			assert Boolean.TRUE; //#dbg:AAFRecipes:Alloys
			AAFPlatedDiamondBlockProcedure.execute(world, x, y, z);
			AAFNetheriteBlockProcedure.execute(world, x, y, z);
			AAFBronzeBlockProcedure.execute(world, x, y, z);
			AAFTuraniteBlockProcedure.execute(world, x, y, z);
			AAFSteelBlockProcedure.execute(world, x, y, z);
			if (ModList.get().isLoaded("create")) {
				AAFBrassBlockProcedure.execute(world, x, y, z);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots")))) {
			AAFIngotsRecipeProcedure.execute(world, x, y, z);
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}