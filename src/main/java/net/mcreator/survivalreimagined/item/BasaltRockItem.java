package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.survivalreimagined.procedures.BasaltRockRightclickedOnBlockProcedure;

public class BasaltRockItem extends Item {
	public BasaltRockItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		BasaltRockRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}