package net.mcreator.survivalreimagined.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.survivalreimagined.procedures.HeartOfTheBloodMoonRightclickedProcedure;

public class HeartOfTheBloodMoonItem extends Item {
	public HeartOfTheBloodMoonItem() {
		super(new Item.Properties().rarity(Rarity.RARE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		HeartOfTheBloodMoonRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}