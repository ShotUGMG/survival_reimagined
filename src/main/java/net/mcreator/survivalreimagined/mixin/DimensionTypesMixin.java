package net.mcreator.survivalreimagined.mixin;

import java.util.OptionalLong;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({DimensionTypes.class})
public class DimensionTypesMixin {
    private static final Logger LOGGER = LogManager.getLogger();

    public DimensionTypesMixin() {
    }

    @Inject(
        method = {"bootstrap"},
        at = {@At("HEAD")},
        cancellable = true
    )
    private static void bootstrap(BootstrapContext<DimensionType> pContext, CallbackInfo ci) {
        LOGGER.info("Mixin bootstrap method called");
        pContext.register(BuiltinDimensionTypes.OVERWORLD, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0, false, true, -256, 512, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
        pContext.register(BuiltinDimensionTypes.NETHER, new DimensionType(OptionalLong.of(18000L), false, true, true, false, 8.0, false, true, -64, 256, 128, BlockTags.INFINIBURN_NETHER, BuiltinDimensionTypes.NETHER_EFFECTS, 0.1F, new DimensionType.MonsterSettings(true, false, ConstantInt.of(7), 15)));
        pContext.register(BuiltinDimensionTypes.END, new DimensionType(OptionalLong.of(6000L), false, false, false, false, 1.0, false, false, 0, 256, 256, BlockTags.INFINIBURN_END, BuiltinDimensionTypes.END_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
        pContext.register(BuiltinDimensionTypes.OVERWORLD_CAVES, new DimensionType(OptionalLong.empty(), true, true, false, true, 1.0, true, false, -256, 512, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
        LOGGER.info("Dimension types registered, cancelling original method");
        ci.cancel();
    }
}
