package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class SmallTroughEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).HungryProc == 1 && entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).Hungry == true) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("food_portions") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) > 0) {
				{
					int _value = (blockstate.getBlock().getStateDefinition().getProperty("food_portions") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) - 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("food_portions") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")), SoundSource.AMBIENT, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")), SoundSource.AMBIENT, 1, 1, false);
					}
				}
				{
					SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
					_vars.Hungry = false;
					_vars.HungryProc = 0;
					_vars.markSyncDirty();
				}
			}
		}
	}
}