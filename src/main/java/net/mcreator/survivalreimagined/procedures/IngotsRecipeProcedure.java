package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.ModList;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class IngotsRecipeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack Result = ItemStack.EMPTY;
		if (new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).getCount();
				}
				return 0;
			}
		}.getAmount(world, BlockPos.containing(x, y, z), 3) < 64) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots"))) && (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == SurvivalReimaginedModBlocks.INGOT_MOLD.get().asItem() || (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots"))) && (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == SurvivalReimaginedModBlocks.INGOT_MOLD.get().asItem()) {
				if (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 3) == 0 || (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 3)).getItem() == Result.getItem()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("FuelMeter", ((new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "FuelMeter")) - 0.1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("BurnTime", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "BurnTime") + 2));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (ModList.get().isLoaded("create")) {
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/zinc"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/zinc")))) {
							Result = new ItemStack(
									(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/zinc"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
									.copy();
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/brass"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/brass")))) {
							Result = new ItemStack(
									(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:ingots/brass"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
									.copy();
						}
					} else if (ModList.get().isLoaded("minecraft")) {
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/copper"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/copper")))) {
							Result = new ItemStack(Items.COPPER_INGOT).copy();
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/iron"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/iron")))) {
							Result = new ItemStack(Items.IRON_INGOT).copy();
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/gold"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/gold")))) {
							Result = new ItemStack(Items.GOLD_INGOT).copy();
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/redstone"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/redstone")))) {
							Result = new ItemStack(SurvivalReimaginedModItems.REDSTONE_INGOT.get()).copy();
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/netherite"))) || (new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/netherite")))) {
							Result = new ItemStack(Items.NETHERITE_INGOT).copy();
						}
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/titanium"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/titanium")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.TITANIUM_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/uranium"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/uranium")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.URANIUM_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/manganese"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/manganese")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.MANGANESE_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/tin"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/tin")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.TIN_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/silver"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/silver")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.SILVER_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/bronze"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/bronze")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.BRONZE_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/steel"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/steel")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.STEEL_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/turanite"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/turanite")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.TURANITE_INGOT.get()).copy();
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/diamond"))) || (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots/diamond")))) {
						Result = new ItemStack(SurvivalReimaginedModItems.DIAMOND_PLATED_INGOT.get()).copy();
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "BurnTime") == 60) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("BurnTime", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = Result.copy();
							_setstack.setCount((int) (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).getCount();
									}
									return 0;
								}
							}.getAmount(world, BlockPos.containing(x, y, z), 3) + 1));
							_itemHandlerModifiable.setStackInSlot(3, _setstack);
						}
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 0)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots")))) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 0;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
						} else if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).is(ItemTags.create(ResourceLocation.parse("c:rough_ingots")))) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 1;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
						}
					}
				}
			}
		}
	}
}
