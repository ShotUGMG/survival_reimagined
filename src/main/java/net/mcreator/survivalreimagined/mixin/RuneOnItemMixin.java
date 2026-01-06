package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.procedures.RuneOnItemDisplayProcedure;

import java.util.List;

@Mixin(Item.class)
public abstract class RuneOnItemMixin {
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = RuneOnItemDisplayProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}
}
