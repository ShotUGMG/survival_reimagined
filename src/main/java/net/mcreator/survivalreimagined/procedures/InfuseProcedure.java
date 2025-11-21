package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;
import java.util.Map;

public class InfuseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (RMIWhileThisGUIIsOpenTickProcedure.execute(entity) == true) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:rmi_runes/gold")))) {
				GoldSapphireProcedure.execute(world, x, y, z, entity);
				GoldAmberProcedure.execute(world, x, y, z, entity);
				GoldDiamondProcedure.execute(world, x, y, z, entity);
				GoldEmeraldProcedure.execute(world, x, y, z, entity);
				GoldRubyProcedure.execute(world, x, y, z, entity);
				GoldLapisProcedure.execute(world, x, y, z, entity);
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:rmi_runes/silver")))) {
				SilverSapphireProcedure.execute(world, x, y, z, entity);
				SilverAmberProcedure.execute(world, x, y, z, entity);
				SilverDiamondProcedure.execute(world, x, y, z, entity);
				SilverEmeraldProcedure.execute(world, x, y, z, entity);
				SilverRubyProcedure.execute(world, x, y, z, entity);
				SilverLapisProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
