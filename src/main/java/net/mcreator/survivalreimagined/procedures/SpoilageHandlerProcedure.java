package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SpoilageHandlerProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:wooden_containers")))) {
			if (world instanceof ILevelExtension levelExt) {
				IItemHandler handler = levelExt.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null);
				if (handler instanceof IItemHandlerModifiable modifiable) {
					int slotCount = modifiable.getSlots();
					for (int i = 0; i < slotCount; i++) {
						ItemStack itemstackiterator = modifiable.getStackInSlot(i);
						int numberiterator = i;
						if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("c:food/can_rot")))) {
							{
								final String _tagName = "CurrentTime";
								final double _tagValue = (world.dayTime());
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
							{
								final String _tagName = "Elapsed";
								final double _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("CurrentTime")
										- itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("TimeLastChecked"));
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
							SurvivalReimaginedMod.queueServerWork(1, () -> {
								{
									final String _tagName = "Spoilage";
									final double _tagValue = Math.round(itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Elapsed") / 100);
									CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
								}
								{
									final String _tagName = "TimeLastChecked";
									final double _tagValue = (world.dayTime());
									CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
								}
							});
							if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") >= 2000) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.ROTTEN_BIOMATTER.get()).copy();
									_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							{
								final String _tagName = "SpoilageMax";
								final double _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax")
										+ itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Spoilage"));
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
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