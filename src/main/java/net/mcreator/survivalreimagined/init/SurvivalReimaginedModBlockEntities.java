
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.survivalreimagined.block.entity.MineralProcessingTableBlockEntity;
import net.mcreator.survivalreimagined.block.entity.MetalRefiningTableBlockEntity;
import net.mcreator.survivalreimagined.block.entity.ForgeBlockEntity;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SurvivalReimaginedModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FORGE = register("forge", SurvivalReimaginedModBlocks.FORGE, ForgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> METAL_REFINING_TABLE = register("metal_refining_table", SurvivalReimaginedModBlocks.METAL_REFINING_TABLE, MetalRefiningTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MINERAL_PROCESSING_TABLE = register("mineral_processing_table", SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE, MineralProcessingTableBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FORGE.get(), (blockEntity, side) -> ((ForgeBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, METAL_REFINING_TABLE.get(), (blockEntity, side) -> ((MetalRefiningTableBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MINERAL_PROCESSING_TABLE.get(), (blockEntity, side) -> ((MineralProcessingTableBlockEntity) blockEntity).getItemHandler());
	}
}
