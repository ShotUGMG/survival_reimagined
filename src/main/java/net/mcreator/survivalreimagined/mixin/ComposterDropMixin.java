package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

@Mixin(ComposterBlock.class)
public class ComposterDropMixin {
	@Inject(method = "extractProduce", at = @At("HEAD"), cancellable = true)
	private static void replaceComposterDrop(Entity entity, BlockState state, Level level, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
		if (!level.isClientSide) {
			Vec3 vec3 = Vec3.atLowerCornerWithOffset(pos, 0.5, 1.01, 0.5).offsetRandom(level.random, 0.7F);
			ItemEntity itemEntity = new ItemEntity(level, vec3.x(), vec3.y(), vec3.z(), new ItemStack(SurvivalReimaginedModItems.BIO_COMPOST.get()));
			itemEntity.setDefaultPickUpDelay();
			level.addFreshEntity(itemEntity);
		}
		BlockState blockstate = state.setValue(ComposterBlock.LEVEL, 0);
		level.setBlock(pos, blockstate, 3);
		level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
		level.playSound(null, pos, SoundEvents.COMPOSTER_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
		cir.setReturnValue(blockstate);
		return;
	}
}