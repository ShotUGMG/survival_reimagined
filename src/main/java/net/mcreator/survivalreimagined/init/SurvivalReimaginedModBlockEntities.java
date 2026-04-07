/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.survivalreimagined.block.entity.*;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber
public class SurvivalReimaginedModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ForgeBlockEntity>> FORGE = register("forge", SurvivalReimaginedModBlocks.FORGE, ForgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MetalRefiningTableBlockEntity>> METAL_REFINING_TABLE = register("metal_refining_table", SurvivalReimaginedModBlocks.METAL_REFINING_TABLE, MetalRefiningTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MineralProcessingTableBlockEntity>> MINERAL_PROCESSING_TABLE = register("mineral_processing_table", SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE,
			MineralProcessingTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AdvancedAlloyForgeBlockEntity>> ADVANCED_ALLOY_FORGE = register("advanced_alloy_forge", SurvivalReimaginedModBlocks.ADVANCED_ALLOY_FORGE, AdvancedAlloyForgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RuneMagicInfuserBlockEntity>> RUNE_MAGIC_INFUSER = register("rune_magic_infuser", SurvivalReimaginedModBlocks.RUNE_MAGIC_INFUSER, RuneMagicInfuserBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SmallTroughBlockEntity>> SMALL_TROUGH = register("small_trough", SurvivalReimaginedModBlocks.SMALL_TROUGH, SmallTroughBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MillstoneBlockEntity>> MILLSTONE = register("millstone", SurvivalReimaginedModBlocks.MILLSTONE, MillstoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PalmLeavesBlockEntity>> PALM_LEAVES = register("palm_leaves", SurvivalReimaginedModBlocks.PALM_LEAVES, PalmLeavesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StrawberryPlantBlockEntity>> STRAWBERRY_PLANT = register("strawberry_plant", SurvivalReimaginedModBlocks.STRAWBERRY_PLANT, StrawberryPlantBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StrawberryCropBlockEntity>> STRAWBERRY_CROP = register("strawberry_crop", SurvivalReimaginedModBlocks.STRAWBERRY_CROP, StrawberryCropBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BananaLeavesBlockEntity>> BANANA_LEAVES = register("banana_leaves", SurvivalReimaginedModBlocks.BANANA_LEAVES, BananaLeavesBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FORGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, METAL_REFINING_TABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MINERAL_PROCESSING_TABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ADVANCED_ALLOY_FORGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RUNE_MAGIC_INFUSER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SMALL_TROUGH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALM_LEAVES.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STRAWBERRY_PLANT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STRAWBERRY_CROP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BANANA_LEAVES.get(), SidedInvWrapper::new);
	}
}