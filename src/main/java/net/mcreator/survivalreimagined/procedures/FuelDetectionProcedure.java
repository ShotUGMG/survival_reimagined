package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.ModList;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FuelDetectionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelMeter") > 0) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("c:raw_blocks")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:raw_blocks")))) {
				RawBlocksProcedure.execute(world, x, y, z);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("c:molds")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:molds")))) {
				BronzeToolsProcedure.execute(world, x, y, z);
				DiamondToolsProcedure.execute(world, x, y, z);
				IngotsRecipeProcedure.execute(world, x, y, z);
				PlatesRecipeProcedure.execute(world, x, y, z);
				RunesProcedure.execute(world, x, y, z);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("c:melt_items")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:melt_items")))) {
				IronMeltProcedure.execute(world, x, y, z);
				GoldMeltProcedure.execute(world, x, y, z);
				SteelMeltProcedure.execute(world, x, y, z);
				BronzeMeltProcedure.execute(world, x, y, z);
				DiamondMeltProcedure.execute(world, x, y, z);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy")))) {
				BronzeRecipeProcedure.execute(world, x, y, z);
				SteelIngotRecipeProcedure.execute(world, x, y, z);
				DiamondIngotRecipeProcedure.execute(world, x, y, z);
				NetherteRecipeProcedure.execute(world, x, y, z);
				TuraniteRecipeProcedure.execute(world, x, y, z);
				LimeRecipeProcedure.execute(world, x, y, z);
				if (ModList.get().isLoaded("create")) {
					BrassRecipeProcedure.execute(world, x, y, z);
					AndesiteAlloyRecipeProcedure.execute(world, x, y, z);
				}
			}
			EmptyRecipeProcedure.execute(world, x, y, z);
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelMeter") == 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BurnTime") != 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BurnTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BurnTime") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
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