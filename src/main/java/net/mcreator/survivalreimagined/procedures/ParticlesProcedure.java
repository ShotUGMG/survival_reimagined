package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModParticleTypes;

public class ParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Grinding") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("c:embedded/stone")))) {
				world.addParticle((SimpleParticleType) (SurvivalReimaginedModParticleTypes.STONE_GRINDING.get()), (x + 0.5), (y + 1), (z + 0.5), (x + 0), (y + 1), (x + 0));
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
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