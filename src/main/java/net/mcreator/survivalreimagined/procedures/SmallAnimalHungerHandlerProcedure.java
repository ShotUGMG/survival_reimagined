package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SmallAnimalHungerHandlerProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:animals/eat_small"))) == true) {
			if (entity.getPersistentData().getBoolean("Hungry") == false) {
				if (entity.getPersistentData().getDouble("HungerClock") < 750) {
					entity.getPersistentData().putDouble("HungerClockDelay", (entity.getPersistentData().getDouble("HungerClockDelay") - 1));
					if (entity.getPersistentData().getDouble("HungerClockDelay") <= 0) {
						entity.getPersistentData().putDouble("HungerClockDelay", 20);
						entity.getPersistentData().putDouble("HungerClock", (entity.getPersistentData().getDouble("HungerClock") + 1));
					}
					if (entity.getPersistentData().getDouble("HungerClock") == 750) {
						{
							SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
							_vars.Hungry = true;
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
		if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Hungry == true) {
			entity.getPersistentData().putDouble("EatDelay", (entity.getPersistentData().getDouble("EatDelay") + 1));
			entity.getPersistentData().putDouble("EatDelayGrass", (entity.getPersistentData().getDouble("EatDelayGrass") + 1));
			sx = -8;
			for (int index179 = 0; index179 < 16; index179++) {
				sy = -8;
				for (int index180 = 0; index180 < 16; index180++) {
					sz = -8;
					for (int index181 = 0; index181 < 16; index181++) {
						sz = sz + 1;
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == SurvivalReimaginedModBlocks.SMALL_TROUGH.get()) {
							entity.getPersistentData().putDouble("HungerClock", 0);
							entity.getPersistentData().putBoolean("FoundTrough", true);
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo((x + sx), (y + sy), (z + sz), 0.8);
							if (entity.getPersistentData().getDouble("EatDelay") == 60) {
								entity.getPersistentData().putDouble("EatDelay", 0);
								if (itemFromBlockInventory(world, BlockPos.containing(x + sx, y + sy, z + sz), 0).getCount() > 0) {
									entity.getPersistentData().putDouble("EatDelayGrass", 0);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x + sx, y + sy, z + sz), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										int _slotid = 0;
										ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
										_stk.shrink(1);
										_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
									}
									SurvivalReimaginedMod.queueServerWork(1, () -> {
										{
											SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
											_vars.Hungry = false;
											_vars.markSyncDirty();
										}
										entity.getPersistentData().putDouble("PortionsEaten", (entity.getPersistentData().getDouble("PortionsEaten") + 1));
									});
								}
							}
						}
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (entity.getPersistentData().getDouble("EatDelayGrass") == 120) {
				entity.getPersistentData().putDouble("EatDelayGrass", 0);
				entity.getPersistentData().putDouble("EatDelay", 0);
				if ((world.getBlockState(BlockPos.containing(x, entity.getY() - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Hungry = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putDouble("HungerClock", 0);
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						{
							BlockPos _bp = BlockPos.containing(x, entity.getY() - 1, z);
							BlockState _bs = Blocks.DIRT.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						world.levelEvent(2001, BlockPos.containing(x, entity.getY() - 1, z), Block.getId(Blocks.GRASS_BLOCK.defaultBlockState()));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")), SoundSource.VOICE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")), SoundSource.VOICE, 1, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, entity.getY() - 1, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crop.break")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (entity.getY() - 1), z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crop.break")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
				} else {
					entity.getPersistentData().putDouble("HungerClock", 0);
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.Hungry = false;
						_vars.markSyncDirty();
					}
				}
			}
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