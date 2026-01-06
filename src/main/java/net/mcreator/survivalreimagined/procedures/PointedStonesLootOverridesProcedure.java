package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class PointedStonesLootOverridesProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		return execute(null, world, x, y, z);
	}

	private static ItemStack execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		ItemStack ItemDrop = ItemStack.EMPTY;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (!(getEntityGameType(entityiterator) == GameType.CREATIVE)) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:pointed_stones/kimberlite")))) {
					ItemDrop = new ItemStack(SurvivalReimaginedModBlocks.KIMBERLITE_ROCK.get()).copy();
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:pointed_stones/deepslate")))) {
					ItemDrop = new ItemStack(SurvivalReimaginedModItems.DEEPSLATE_ROCK.get()).copy();
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:pointed_stones/basalt")))) {
					ItemDrop = new ItemStack(SurvivalReimaginedModItems.BASALT_ROCK.get()).copy();
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:pointed_stones/stone")))) {
					ItemDrop = new ItemStack(SurvivalReimaginedModItems.STONE_ROCK.get()).copy();
				} else {
					ItemDrop = ItemStack.EMPTY.copy();
				}
			}
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), ItemDrop);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
		return ItemDrop;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}