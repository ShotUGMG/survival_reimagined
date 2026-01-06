package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class WisteriaLitterHandlerProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModBlocks.WISTERIA_LEAF_LITTER.get().asItem()) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) < 3) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WISTERIA_LEAF_LITTER.get()) {
					if (getEntityGameType(entity) == GameType.ADVENTURE || getEntityGameType(entity) == GameType.SURVIVAL) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					}
					{
						int _value = (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11 ? blockstate.getValue(_getip11) : -1) + 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:place/wistera_litter")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:place/wistera_litter")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				return InteractionResult.SUCCESS;
			} else {
				return InteractionResult.FAIL;
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModBlocks.WISTERIA_LEAF_LITTER.get().asItem()) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip20 ? blockstate.getValue(_getip20) : -1) < 3) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.WISTERIA_LEAF_LITTER.get()) {
					if (getEntityGameType(entity) == GameType.ADVENTURE || getEntityGameType(entity) == GameType.SURVIVAL) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
					}
					{
						int _value = (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip28 ? blockstate.getValue(_getip28) : -1) + 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:place/wistera_litter")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("survival_reimagined:place/wistera_litter")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				return InteractionResult.SUCCESS;
			} else {
				return InteractionResult.FAIL;
			}
		}
		return InteractionResult.FAIL;
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