package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class HempSeedsRightclickedOnBlockProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FARMLAND && world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.getBrightness(LightLayer.SKY, BlockPos.containing(x, y + 1, z)) >= 9) {
			world.setBlock(BlockPos.containing(x, y + 1, z), SurvivalReimaginedModBlocks.HEMP.get().defaultBlockState(), 3);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.HEMP_SEEDS.get()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SurvivalReimaginedModItems.HEMP_SEEDS.get()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
			}
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
