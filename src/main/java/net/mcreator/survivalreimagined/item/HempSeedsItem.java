package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.survivalreimagined.procedures.HempSeedsRightclickedOnBlockProcedure;

public class HempSeedsItem extends Item {
	public HempSeedsItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		return HempSeedsRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
	}
}