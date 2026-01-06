package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;

public class GoldRubyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:runes/ruby")))) {
			if (getAmountInGUISlot(entity, 2) >= 3) {
				{
					final String _tagName = "GoldInfused";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY),
							tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "RubyInfused";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY),
							tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, (float) 1.3, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, (float) 1.3, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.BLOCKS, (float) 0.8, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.BLOCKS, (float) 0.8, 1, false);
					}
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(1).getItem() : ItemStack.EMPTY).shrink(1);
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(2).getItem() : ItemStack.EMPTY).shrink(3);
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}