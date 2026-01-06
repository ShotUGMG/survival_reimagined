package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.world.inventory.AdvancedAlloyForgeGUIMenu;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import io.netty.buffer.Unpooled;

public class AdvancedAlloyForgeOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get() && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.AIR)
				^ ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.AIR)
				^ ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR)
				^ ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.URANIUM_ROD.get()
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == SurvivalReimaginedModBlocks.BLOCK_OF_TITANIUM.get() && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR)) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("AdvancedAlloyForgeGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new AdvancedAlloyForgeGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:build_aaf"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Incomplete Block Setup"), true);
		}
	}
}