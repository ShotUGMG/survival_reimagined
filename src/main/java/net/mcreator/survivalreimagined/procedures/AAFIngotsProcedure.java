package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class AAFIngotsProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/bronze")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/bronze")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/bronze"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/steel")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/steel")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/steel"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/diamond")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/diamond")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/diamond"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/netherite")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/netherite")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/netherite"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/turanite")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/turanite")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/turanite"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/iron")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/iron")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/iron"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/gold")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/gold")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/gold"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/redstone")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/redstone")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/redstone"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/manganese")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/manganese")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/manganese"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/tin")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/tin")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/tin"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/copper")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/copper")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/copper"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/titanium")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/titanium")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/titanium"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/uranium")))
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/uranium")))) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/uranium"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		}
		if (ModList.get().isLoaded("create")) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/brass")))
					^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/brass")))) {
				return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/brass"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
			}
		}
		return ItemStack.EMPTY;
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