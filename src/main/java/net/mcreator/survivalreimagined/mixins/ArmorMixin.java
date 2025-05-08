package net.mcreator.survivalreimagined.mixins;

import org.spongepowered.asm.mixin.Mixin;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.network.chat.Component;

import net.mcreator.survivalreimagined.procedures.DisplayInfoProcedure;

import java.util.List;
import com.jcraft.jorbis.Block;
import net.minecraft.world.level.block.Blocks;

@Mixin(ArmorItem.class)
public abstract class ArmorMixin {
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		String hoverText = DisplayInfoProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}
}
