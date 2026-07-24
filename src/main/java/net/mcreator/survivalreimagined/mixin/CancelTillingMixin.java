package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.InteractionResult;

@Mixin(HoeItem.class)
public class CancelTillingMixin {
	@Inject(method = "useOn(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;", at = @At("HEAD"), cancellable = true)
	private void cancelHoeTilling(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
		if (true) {
			cir.setReturnValue(InteractionResult.FAIL);
			cir.cancel();
		}
	}
}