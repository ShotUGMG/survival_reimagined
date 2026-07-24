package net.mcreator.survivalreimagined.mixin;

import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.Camera;

@Mixin(Camera.class)
public interface CameraAccessor {
	@Accessor
	public void setDetached(boolean value);
}