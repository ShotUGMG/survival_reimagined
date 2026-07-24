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
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AppleTreeSaplingBlockEntity>> APPLE_TREE_SAPLING = register("apple_tree_sapling", SurvivalReimaginedModBlocks.APPLE_TREE_SAPLING, AppleTreeSaplingBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AppleBlockEntity>> APPLE = register("apple", SurvivalReimaginedModBlocks.APPLE, AppleBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HempBlockEntity>> HEMP = register("hemp", SurvivalReimaginedModBlocks.HEMP, HempBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AdvancedAlloyForgeBlockEntity>> ADVANCED_ALLOY_FORGE = register("advanced_alloy_forge", SurvivalReimaginedModBlocks.ADVANCED_ALLOY_FORGE, AdvancedAlloyForgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RuneMagicInfuserBlockEntity>> RUNE_MAGIC_INFUSER = register("rune_magic_infuser", SurvivalReimaginedModBlocks.RUNE_MAGIC_INFUSER, RuneMagicInfuserBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SmallTroughBlockEntity>> SMALL_TROUGH = register("small_trough", SurvivalReimaginedModBlocks.SMALL_TROUGH, SmallTroughBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PalmLeavesBlockEntity>> PALM_LEAVES = register("palm_leaves", SurvivalReimaginedModBlocks.PALM_LEAVES, PalmLeavesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StrawberryPlantBlockEntity>> STRAWBERRY_PLANT = register("strawberry_plant", SurvivalReimaginedModBlocks.STRAWBERRY_PLANT, StrawberryPlantBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BananaLeavesBlockEntity>> BANANA_LEAVES = register("banana_leaves", SurvivalReimaginedModBlocks.BANANA_LEAVES, BananaLeavesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BananaBlockEntity>> BANANA_CLUSTER = register("banana_cluster", SurvivalReimaginedModBlocks.BANANA_CLUSTER, BananaBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BananaGrowBlockBlockEntity>> BANANA_GROW_BLOCK = register("banana_grow_block", SurvivalReimaginedModBlocks.BANANA_GROW_BLOCK, BananaGrowBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MandarinFruitBlockEntity>> MANDARIN_FRUIT = register("mandarin_fruit", SurvivalReimaginedModBlocks.MANDARIN_FRUIT, MandarinFruitBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MandarinSaplingBlockEntity>> MANDARIN_SAPLING = register("mandarin_sapling", SurvivalReimaginedModBlocks.MANDARIN_SAPLING, MandarinSaplingBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MillstoneBlockEntity>> MILLSTONE = register("millstone", SurvivalReimaginedModBlocks.MILLSTONE, MillstoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CampfireBlockEntity>> CAMPFIRE = register("campfire", SurvivalReimaginedModBlocks.CAMPFIRE, CampfireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LowFertilityFarmlandBlockEntity>> LOW_FERTILITY_FARMLAND = register("low_fertility_farmland", SurvivalReimaginedModBlocks.LOW_FERTILITY_FARMLAND,
			LowFertilityFarmlandBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MediumFertilitySoilBlockEntity>> MEDIUM_FERTILITY_SOIL = register("medium_fertility_soil", SurvivalReimaginedModBlocks.MEDIUM_FERTILITY_SOIL,
			MediumFertilitySoilBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HighFertilitySoilBlockEntity>> HIGH_FERTILITY_SOIL = register("high_fertility_soil", SurvivalReimaginedModBlocks.HIGH_FERTILITY_SOIL, HighFertilitySoilBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BeetrootBlockEntity>> BEETROOT = register("beetroot", SurvivalReimaginedModBlocks.BEETROOT, BeetrootBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlockOfCharcoalBlockEntity>> BLOCK_OF_CHARCOAL = register("block_of_charcoal", SurvivalReimaginedModBlocks.BLOCK_OF_CHARCOAL, BlockOfCharcoalBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CowCarcassBlockEntity>> COW_CARCASS = register("cow_carcass", SurvivalReimaginedModBlocks.COW_CARCASS, CowCarcassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SheepCarcassBlockEntity>> SHEEP_CARCASS = register("sheep_carcass", SurvivalReimaginedModBlocks.SHEEP_CARCASS, SheepCarcassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChickenCarcassBlockEntity>> CHICKEN_CARCASS = register("chicken_carcass", SurvivalReimaginedModBlocks.CHICKEN_CARCASS, ChickenCarcassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PigCarcassBlockEntity>> PIG_CARCASS = register("pig_carcass", SurvivalReimaginedModBlocks.PIG_CARCASS, PigCarcassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoatCarcassBlockEntity>> GOAT_CARCASS = register("goat_carcass", SurvivalReimaginedModBlocks.GOAT_CARCASS, GoatCarcassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DryingRackBlockEntity>> DRYING_RACK = register("drying_rack", SurvivalReimaginedModBlocks.DRYING_RACK, DryingRackBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TanningBarrelBlockEntity>> TANNING_BARREL = register("tanning_barrel", SurvivalReimaginedModBlocks.TANNING_BARREL, TanningBarrelBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WheatCropBlockEntity>> WHEAT_CROP = register("wheat_crop", SurvivalReimaginedModBlocks.WHEAT_CROP, WheatCropBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CornStalkBottomBlockEntity>> CORN_STALK_BOTTOM = register("corn_stalk_bottom", SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM, CornStalkBottomBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CarrotsBlockEntity>> CARROTS = register("carrots", SurvivalReimaginedModBlocks.CARROTS, CarrotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PotatoesBlockEntity>> POTATOES = register("potatoes", SurvivalReimaginedModBlocks.POTATOES, PotatoesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpeltSeedsBlockEntity>> SPELT_SEEDS = register("spelt_seeds", SurvivalReimaginedModBlocks.SPELT_SEEDS, SpeltSeedsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RyeSeedsBlockEntity>> RYE_SEEDS = register("rye_seeds", SurvivalReimaginedModBlocks.RYE_SEEDS, RyeSeedsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RaspberryPlantBlockEntity>> RASPBERRY_PLANT = register("raspberry_plant", SurvivalReimaginedModBlocks.RASPBERRY_PLANT, RaspberryPlantBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteHorseBlockEntity>> WHITE_HORSE = register("white_horse", SurvivalReimaginedModBlocks.WHITE_HORSE, WhiteHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteHorseStockingBlockEntity>> WHITE_HORSE_STOCKING = register("white_horse_stocking", SurvivalReimaginedModBlocks.WHITE_HORSE_STOCKING, WhiteHorseStockingBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteHorseFieldBlockEntity>> WHITE_HORSE_FIELD = register("white_horse_field", SurvivalReimaginedModBlocks.WHITE_HORSE_FIELD, WhiteHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteHorseWhiteDotsBlockEntity>> WHITE_HORSE_WHITE_DOTS = register("white_horse_white_dots", SurvivalReimaginedModBlocks.WHITE_HORSE_WHITE_DOTS,
			WhiteHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteHorseBlackDotsBlockEntity>> WHITE_HORSE_BLACK_DOTS = register("white_horse_black_dots", SurvivalReimaginedModBlocks.WHITE_HORSE_BLACK_DOTS,
			WhiteHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreamyHorseBlockEntity>> CREAMY_HORSE = register("creamy_horse", SurvivalReimaginedModBlocks.CREAMY_HORSE, CreamyHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreamyHorseStockingsBlockEntity>> CREAMY_HORSE_STOCKINGS = register("creamy_horse_stockings", SurvivalReimaginedModBlocks.CREAMY_HORSE_STOCKINGS,
			CreamyHorseStockingsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreamyHorseFieldBlockEntity>> CREAMY_HORSE_FIELD = register("creamy_horse_field", SurvivalReimaginedModBlocks.CREAMY_HORSE_FIELD, CreamyHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreamyHorseWhiteDotsBlockEntity>> CREAMY_HORSE_WHITE_DOTS = register("creamy_horse_white_dots", SurvivalReimaginedModBlocks.CREAMY_HORSE_WHITE_DOTS,
			CreamyHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreamyHorseBlackDotsBlockEntity>> CREAMY_HORSE_BLACK_DOTS = register("creamy_horse_black_dots", SurvivalReimaginedModBlocks.CREAMY_HORSE_BLACK_DOTS,
			CreamyHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChestnutHorseBlockEntity>> CHESTNUT_HORSE = register("chestnut_horse", SurvivalReimaginedModBlocks.CHESTNUT_HORSE, ChestnutHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrownHorseBlockEntity>> BROWN_HORSE = register("brown_horse", SurvivalReimaginedModBlocks.BROWN_HORSE, BrownHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHorseBlockEntity>> BLACK_HORSE = register("black_horse", SurvivalReimaginedModBlocks.BLACK_HORSE, BlackHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrayHorseBlockEntity>> GRAY_HORSE = register("gray_horse", SurvivalReimaginedModBlocks.GRAY_HORSE, GrayHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkBrownHorseBlockEntity>> DARK_BROWN_HORSE = register("dark_brown_horse", SurvivalReimaginedModBlocks.DARK_BROWN_HORSE, DarkBrownHorseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChestnutHorseStockingsBlockEntity>> CHESTNUT_HORSE_STOCKINGS = register("chestnut_horse_stockings", SurvivalReimaginedModBlocks.CHESTNUT_HORSE_STOCKINGS,
			ChestnutHorseStockingsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChestnutHorseFieldBlockEntity>> CHESTNUT_HORSE_FIELD = register("chestnut_horse_field", SurvivalReimaginedModBlocks.CHESTNUT_HORSE_FIELD, ChestnutHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChestnutHorseWhiteDotsBlockEntity>> CHESTNUT_HORSE_WHITE_DOTS = register("chestnut_horse_white_dots", SurvivalReimaginedModBlocks.CHESTNUT_HORSE_WHITE_DOTS,
			ChestnutHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChestnutHorseBlackDotsBlockEntity>> CHESTNUT_HORSE_BLACK_DOTS = register("chestnut_horse_black_dots", SurvivalReimaginedModBlocks.CHESTNUT_HORSE_BLACK_DOTS,
			ChestnutHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrownHorseStockingsBlockEntity>> BROWN_HORSE_STOCKINGS = register("brown_horse_stockings", SurvivalReimaginedModBlocks.BROWN_HORSE_STOCKINGS,
			BrownHorseStockingsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrownHorseFieldBlockEntity>> BROWN_HORSE_FIELD = register("brown_horse_field", SurvivalReimaginedModBlocks.BROWN_HORSE_FIELD, BrownHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrownHorseWhiteDotsBlockEntity>> BROWN_HORSE_WHITE_DOTS = register("brown_horse_white_dots", SurvivalReimaginedModBlocks.BROWN_HORSE_WHITE_DOTS,
			BrownHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrownHorseBlackDotsBlockEntity>> BROWN_HORSE_BLACK_DOTS = register("brown_horse_black_dots", SurvivalReimaginedModBlocks.BROWN_HORSE_BLACK_DOTS,
			BrownHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHorseStockingsBlockEntity>> BLACK_HORSE_STOCKINGS = register("black_horse_stockings", SurvivalReimaginedModBlocks.BLACK_HORSE_STOCKINGS,
			BlackHorseStockingsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHorseFieldBlockEntity>> BLACK_HORSE_FIELD = register("black_horse_field", SurvivalReimaginedModBlocks.BLACK_HORSE_FIELD, BlackHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHorseWhiteDotsBlockEntity>> BLACK_HORSE_WHITE_DOTS = register("black_horse_white_dots", SurvivalReimaginedModBlocks.BLACK_HORSE_WHITE_DOTS,
			BlackHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHorseBlackDotsBlockEntity>> BLACK_HORSE_BLACK_DOTS = register("black_horse_black_dots", SurvivalReimaginedModBlocks.BLACK_HORSE_BLACK_DOTS,
			BlackHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrayHorseStockingsBlockEntity>> GRAY_HORSE_STOCKINGS = register("gray_horse_stockings", SurvivalReimaginedModBlocks.GRAY_HORSE_STOCKINGS, GrayHorseStockingsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrayHorseFieldBlockEntity>> GRAY_HORSE_FIELD = register("gray_horse_field", SurvivalReimaginedModBlocks.GRAY_HORSE_FIELD, GrayHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrayHorseWhiteDotsBlockEntity>> GRAY_HORSE_WHITE_DOTS = register("gray_horse_white_dots", SurvivalReimaginedModBlocks.GRAY_HORSE_WHITE_DOTS,
			GrayHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrayHorseBlackDotsBlockEntity>> GRAY_HORSE_BLACK_DOTS = register("gray_horse_black_dots", SurvivalReimaginedModBlocks.GRAY_HORSE_BLACK_DOTS,
			GrayHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkBrownHorseStockingsBlockEntity>> DARK_BROWN_HORSE_STOCKINGS = register("dark_brown_horse_stockings", SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_STOCKINGS,
			DarkBrownHorseStockingsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkBrownHorseFieldBlockEntity>> DARK_BROWN_HORSE_FIELD = register("dark_brown_horse_field", SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_FIELD,
			DarkBrownHorseFieldBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkBrownHorseWhiteDotsBlockEntity>> DARK_BROWN_HORSE_WHITE_DOTS = register("dark_brown_horse_white_dots", SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_WHITE_DOTS,
			DarkBrownHorseWhiteDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkBrownHorseBlackDotsBlockEntity>> DARK_BROWN_HORSE_BLACK_DOTS = register("dark_brown_horse_black_dots", SurvivalReimaginedModBlocks.DARK_BROWN_HORSE_BLACK_DOTS,
			DarkBrownHorseBlackDotsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkinnedHorseBlockEntity>> SKINNED_HORSE = register("skinned_horse", SurvivalReimaginedModBlocks.SKINNED_HORSE, SkinnedHorseBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CORN_STALK_BOTTOM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREAMY_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOAT_CARCASS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BROWN_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAY_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MANDARIN_SAPLING.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_BROWN_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLACK_HORSE_STOCKINGS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MANDARIN_FRUIT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHESTNUT_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RASPBERRY_PLANT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MINERAL_PROCESSING_TABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHEAT_CROP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BANANA_GROW_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, POTATOES.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BROWN_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STRAWBERRY_PLANT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLOCK_OF_CHARCOAL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DRYING_RACK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ADVANCED_ALLOY_FORGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLACK_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BROWN_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAY_HORSE_STOCKINGS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLACK_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SKINNED_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, APPLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_BROWN_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BROWN_HORSE_STOCKINGS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHESTNUT_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHICKEN_CARCASS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREAMY_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BROWN_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAY_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, METAL_REFINING_TABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PIG_CARCASS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHESTNUT_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_BROWN_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLACK_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREAMY_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHESTNUT_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HIGH_FERTILITY_SOIL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FORGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, APPLE_TREE_SAPLING.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREAMY_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SHEEP_CARCASS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CARROTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TANNING_BARREL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHESTNUT_HORSE_STOCKINGS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLACK_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPELT_SEEDS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_HORSE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HEMP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_BROWN_HORSE_STOCKINGS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BANANA_CLUSTER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAY_HORSE_FIELD.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SMALL_TROUGH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREAMY_HORSE_STOCKINGS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RUNE_MAGIC_INFUSER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CAMPFIRE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALM_LEAVES.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BANANA_LEAVES.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BEETROOT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LOW_FERTILITY_FARMLAND.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RYE_SEEDS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MEDIUM_FERTILITY_SOIL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COW_CARCASS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_HORSE_STOCKING.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAY_HORSE_WHITE_DOTS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_BROWN_HORSE_BLACK_DOTS.get(), SidedInvWrapper::new);
	}
}