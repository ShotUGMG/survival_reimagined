
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.survivalreimagined.block.TuffRockBlockBlock;
import net.mcreator.survivalreimagined.block.TinOreBlock;
import net.mcreator.survivalreimagined.block.SwordBladeMoldBlock;
import net.mcreator.survivalreimagined.block.StoneRockBlocBlock;
import net.mcreator.survivalreimagined.block.ShovelHeadMoldBlock;
import net.mcreator.survivalreimagined.block.SheepLegBlock;
import net.mcreator.survivalreimagined.block.SheepHeadBlock;
import net.mcreator.survivalreimagined.block.SheepCarcassBlock;
import net.mcreator.survivalreimagined.block.SawBladeMoldBlock;
import net.mcreator.survivalreimagined.block.SandSaltDepositBlock;
import net.mcreator.survivalreimagined.block.PigLegBlock;
import net.mcreator.survivalreimagined.block.PigHeadBlock;
import net.mcreator.survivalreimagined.block.PigCarcassBlock;
import net.mcreator.survivalreimagined.block.PickaxeHeadMoldBlock;
import net.mcreator.survivalreimagined.block.NetherrackRockBlockBlock;
import net.mcreator.survivalreimagined.block.MossyStoneRockBlockBlock;
import net.mcreator.survivalreimagined.block.MineralProcessingTableBlock;
import net.mcreator.survivalreimagined.block.MetalRefiningTableBlock;
import net.mcreator.survivalreimagined.block.ManganeseOreBlock;
import net.mcreator.survivalreimagined.block.LeggingMoldBlock;
import net.mcreator.survivalreimagined.block.KnifeBladeMoldBlock;
import net.mcreator.survivalreimagined.block.IngotMoldBlock;
import net.mcreator.survivalreimagined.block.IngotClayMoldBlock;
import net.mcreator.survivalreimagined.block.HoeHeadMoldBlock;
import net.mcreator.survivalreimagined.block.HempBlock;
import net.mcreator.survivalreimagined.block.HelmetMoldBlock;
import net.mcreator.survivalreimagined.block.HammerHeadMoldBlock;
import net.mcreator.survivalreimagined.block.GraniteRockBlockBlock;
import net.mcreator.survivalreimagined.block.ForgeBlock;
import net.mcreator.survivalreimagined.block.FlintblockBlock;
import net.mcreator.survivalreimagined.block.EndStoneRockBlockBlock;
import net.mcreator.survivalreimagined.block.EmbeddedObsidianBlock;
import net.mcreator.survivalreimagined.block.DripstoneRockBlockBlock;
import net.mcreator.survivalreimagined.block.DioriteRockBLockBlock;
import net.mcreator.survivalreimagined.block.DeepslateRockBlockBlock;
import net.mcreator.survivalreimagined.block.DeepslateManganeseOreBlock;
import net.mcreator.survivalreimagined.block.CrucibleBlock;
import net.mcreator.survivalreimagined.block.CowLegBlock;
import net.mcreator.survivalreimagined.block.CowHeadBlock;
import net.mcreator.survivalreimagined.block.CowCarcassBlock;
import net.mcreator.survivalreimagined.block.CopperRockBlockBlock;
import net.mcreator.survivalreimagined.block.CobbledSandstoneBlock;
import net.mcreator.survivalreimagined.block.CobbledRedSandstoneBlock;
import net.mcreator.survivalreimagined.block.ClaySwordBladeMoldBlock;
import net.mcreator.survivalreimagined.block.ClayShovelHeadMoldBlock;
import net.mcreator.survivalreimagined.block.ClaySawBladeMoldBlock;
import net.mcreator.survivalreimagined.block.ClayPickaxeHeadMoldBlock;
import net.mcreator.survivalreimagined.block.ClayLeggingsMoldBlock;
import net.mcreator.survivalreimagined.block.ClayKnifeMoldBlock;
import net.mcreator.survivalreimagined.block.ClayHoeBladeMoldBlock;
import net.mcreator.survivalreimagined.block.ClayHelmetMoldBlock;
import net.mcreator.survivalreimagined.block.ClayHammerHeadMoldBlock;
import net.mcreator.survivalreimagined.block.ClayCrucibleBlock;
import net.mcreator.survivalreimagined.block.ClayChestplateMoldBlock;
import net.mcreator.survivalreimagined.block.ClayBootsMoldBlock;
import net.mcreator.survivalreimagined.block.ClayAxeHeadMoldBlock;
import net.mcreator.survivalreimagined.block.ChickenCarcassBlock;
import net.mcreator.survivalreimagined.block.ChestplateMoldBlock;
import net.mcreator.survivalreimagined.block.CalciteRockBlockBlock;
import net.mcreator.survivalreimagined.block.BootsMoldBlock;
import net.mcreator.survivalreimagined.block.BlockOfTinBlock;
import net.mcreator.survivalreimagined.block.BlockOfSteelBlock;
import net.mcreator.survivalreimagined.block.BlockOfRawTinBlock;
import net.mcreator.survivalreimagined.block.BlockOfRawRedstoneBlock;
import net.mcreator.survivalreimagined.block.BlockOfRawManganeseBlock;
import net.mcreator.survivalreimagined.block.BlockOfManganeseBlock;
import net.mcreator.survivalreimagined.block.BlockOfBronzeBlock;
import net.mcreator.survivalreimagined.block.BlackstoneRockBlockBlock;
import net.mcreator.survivalreimagined.block.BasaltRockBlockBlock;
import net.mcreator.survivalreimagined.block.AxeHeadMoldBlock;
import net.mcreator.survivalreimagined.block.AppleTreeSaplingBlock;
import net.mcreator.survivalreimagined.block.AppleOakLeavesBlock;
import net.mcreator.survivalreimagined.block.AppleBlock;
import net.mcreator.survivalreimagined.block.AndesiteRockBlockBlock;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SurvivalReimaginedModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SurvivalReimaginedMod.MODID);
	public static final DeferredBlock<Block> FLINTBLOCK = REGISTRY.register("flintblock", FlintblockBlock::new);
	public static final DeferredBlock<Block> STONE_ROCK_BLOC = REGISTRY.register("stone_rock_bloc", StoneRockBlocBlock::new);
	public static final DeferredBlock<Block> TIN_ORE = REGISTRY.register("tin_ore", TinOreBlock::new);
	public static final DeferredBlock<Block> FORGE = REGISTRY.register("forge", ForgeBlock::new);
	public static final DeferredBlock<Block> METAL_REFINING_TABLE = REGISTRY.register("metal_refining_table", MetalRefiningTableBlock::new);
	public static final DeferredBlock<Block> CLAY_CRUCIBLE = REGISTRY.register("clay_crucible", ClayCrucibleBlock::new);
	public static final DeferredBlock<Block> CRUCIBLE = REGISTRY.register("crucible", CrucibleBlock::new);
	public static final DeferredBlock<Block> AXE_HEAD_MOLD = REGISTRY.register("axe_head_mold", AxeHeadMoldBlock::new);
	public static final DeferredBlock<Block> PICKAXE_HEAD_MOLD = REGISTRY.register("pickaxe_head_mold", PickaxeHeadMoldBlock::new);
	public static final DeferredBlock<Block> SWORD_BLADE_MOLD = REGISTRY.register("sword_blade_mold", SwordBladeMoldBlock::new);
	public static final DeferredBlock<Block> HOE_HEAD_MOLD = REGISTRY.register("hoe_head_mold", HoeHeadMoldBlock::new);
	public static final DeferredBlock<Block> SHOVEL_HEAD_MOLD = REGISTRY.register("shovel_head_mold", ShovelHeadMoldBlock::new);
	public static final DeferredBlock<Block> SAW_BLADE_MOLD = REGISTRY.register("saw_blade_mold", SawBladeMoldBlock::new);
	public static final DeferredBlock<Block> HAMMER_HEAD_MOLD = REGISTRY.register("hammer_head_mold", HammerHeadMoldBlock::new);
	public static final DeferredBlock<Block> HELMET_MOLD = REGISTRY.register("helmet_mold", HelmetMoldBlock::new);
	public static final DeferredBlock<Block> CHESTPLATE_MOLD = REGISTRY.register("chestplate_mold", ChestplateMoldBlock::new);
	public static final DeferredBlock<Block> LEGGING_MOLD = REGISTRY.register("legging_mold", LeggingMoldBlock::new);
	public static final DeferredBlock<Block> BOOTS_MOLD = REGISTRY.register("boots_mold", BootsMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_SWORD_BLADE_MOLD = REGISTRY.register("clay_sword_blade_mold", ClaySwordBladeMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_PICKAXE_HEAD_MOLD = REGISTRY.register("clay_pickaxe_head_mold", ClayPickaxeHeadMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_AXE_HEAD_MOLD = REGISTRY.register("clay_axe_head_mold", ClayAxeHeadMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_SHOVEL_HEAD_MOLD = REGISTRY.register("clay_shovel_head_mold", ClayShovelHeadMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_HOE_BLADE_MOLD = REGISTRY.register("clay_hoe_blade_mold", ClayHoeBladeMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_HAMMER_HEAD_MOLD = REGISTRY.register("clay_hammer_head_mold", ClayHammerHeadMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_SAW_BLADE_MOLD = REGISTRY.register("clay_saw_blade_mold", ClaySawBladeMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_HELMET_MOLD = REGISTRY.register("clay_helmet_mold", ClayHelmetMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_CHESTPLATE_MOLD = REGISTRY.register("clay_chestplate_mold", ClayChestplateMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_LEGGINGS_MOLD = REGISTRY.register("clay_leggings_mold", ClayLeggingsMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_BOOTS_MOLD = REGISTRY.register("clay_boots_mold", ClayBootsMoldBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_BRONZE = REGISTRY.register("block_of_bronze", BlockOfBronzeBlock::new);
	public static final DeferredBlock<Block> ANDESITE_ROCK_BLOCK = REGISTRY.register("andesite_rock_block", AndesiteRockBlockBlock::new);
	public static final DeferredBlock<Block> GRANITE_ROCK_BLOCK = REGISTRY.register("granite_rock_block", GraniteRockBlockBlock::new);
	public static final DeferredBlock<Block> DIORITE_ROCK_B_LOCK = REGISTRY.register("diorite_rock_b_lock", DioriteRockBLockBlock::new);
	public static final DeferredBlock<Block> DRIPSTONE_ROCK_BLOCK = REGISTRY.register("dripstone_rock_block", DripstoneRockBlockBlock::new);
	public static final DeferredBlock<Block> CALCITE_ROCK_BLOCK = REGISTRY.register("calcite_rock_block", CalciteRockBlockBlock::new);
	public static final DeferredBlock<Block> TUFF_ROCK_BLOCK = REGISTRY.register("tuff_rock_block", TuffRockBlockBlock::new);
	public static final DeferredBlock<Block> MOSSY_STONE_ROCK_BLOCK = REGISTRY.register("mossy_stone_rock_block", MossyStoneRockBlockBlock::new);
	public static final DeferredBlock<Block> NETHERRACK_ROCK_BLOCK = REGISTRY.register("netherrack_rock_block", NetherrackRockBlockBlock::new);
	public static final DeferredBlock<Block> END_STONE_ROCK_BLOCK = REGISTRY.register("end_stone_rock_block", EndStoneRockBlockBlock::new);
	public static final DeferredBlock<Block> BLACKSTONE_ROCK_BLOCK = REGISTRY.register("blackstone_rock_block", BlackstoneRockBlockBlock::new);
	public static final DeferredBlock<Block> BASALT_ROCK_BLOCK = REGISTRY.register("basalt_rock_block", BasaltRockBlockBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_ROCK_BLOCK = REGISTRY.register("deepslate_rock_block", DeepslateRockBlockBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_RAW_TIN = REGISTRY.register("block_of_raw_tin", BlockOfRawTinBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_TIN = REGISTRY.register("block_of_tin", BlockOfTinBlock::new);
	public static final DeferredBlock<Block> COW_CARCASS = REGISTRY.register("cow_carcass", CowCarcassBlock::new);
	public static final DeferredBlock<Block> COW_LEG = REGISTRY.register("cow_leg", CowLegBlock::new);
	public static final DeferredBlock<Block> COW_HEAD = REGISTRY.register("cow_head", CowHeadBlock::new);
	public static final DeferredBlock<Block> SAND_SALT_DEPOSIT = REGISTRY.register("sand_salt_deposit", SandSaltDepositBlock::new);
	public static final DeferredBlock<Block> SHEEP_CARCASS = REGISTRY.register("sheep_carcass", SheepCarcassBlock::new);
	public static final DeferredBlock<Block> SHEEP_LEG = REGISTRY.register("sheep_leg", SheepLegBlock::new);
	public static final DeferredBlock<Block> SHEEP_HEAD = REGISTRY.register("sheep_head", SheepHeadBlock::new);
	public static final DeferredBlock<Block> CHICKEN_CARCASS = REGISTRY.register("chicken_carcass", ChickenCarcassBlock::new);
	public static final DeferredBlock<Block> PIG_CARCASS = REGISTRY.register("pig_carcass", PigCarcassBlock::new);
	public static final DeferredBlock<Block> PIG_HEAD = REGISTRY.register("pig_head", PigHeadBlock::new);
	public static final DeferredBlock<Block> PIG_LEG = REGISTRY.register("pig_leg", PigLegBlock::new);
	public static final DeferredBlock<Block> KNIFE_BLADE_MOLD = REGISTRY.register("knife_blade_mold", KnifeBladeMoldBlock::new);
	public static final DeferredBlock<Block> CLAY_KNIFE_MOLD = REGISTRY.register("clay_knife_mold", ClayKnifeMoldBlock::new);
	public static final DeferredBlock<Block> MANGANESE_ORE = REGISTRY.register("manganese_ore", ManganeseOreBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_MANGANESE_ORE = REGISTRY.register("deepslate_manganese_ore", DeepslateManganeseOreBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_STEEL = REGISTRY.register("block_of_steel", BlockOfSteelBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_MANGANESE = REGISTRY.register("block_of_manganese", BlockOfManganeseBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_RAW_MANGANESE = REGISTRY.register("block_of_raw_manganese", BlockOfRawManganeseBlock::new);
	public static final DeferredBlock<Block> BLOCK_OF_RAW_REDSTONE = REGISTRY.register("block_of_raw_redstone", BlockOfRawRedstoneBlock::new);
	public static final DeferredBlock<Block> COBBLED_SANDSTONE = REGISTRY.register("cobbled_sandstone", CobbledSandstoneBlock::new);
	public static final DeferredBlock<Block> COBBLED_RED_SANDSTONE = REGISTRY.register("cobbled_red_sandstone", CobbledRedSandstoneBlock::new);
	public static final DeferredBlock<Block> MINERAL_PROCESSING_TABLE = REGISTRY.register("mineral_processing_table", MineralProcessingTableBlock::new);
	public static final DeferredBlock<Block> EMBEDDED_OBSIDIAN = REGISTRY.register("embedded_obsidian", EmbeddedObsidianBlock::new);
	public static final DeferredBlock<Block> COPPER_ROCK_BLOCK = REGISTRY.register("copper_rock_block", CopperRockBlockBlock::new);
	public static final DeferredBlock<Block> APPLE_OAK_LEAVES = REGISTRY.register("apple_oak_leaves", AppleOakLeavesBlock::new);
	public static final DeferredBlock<Block> APPLE_TREE_SAPLING = REGISTRY.register("apple_tree_sapling", AppleTreeSaplingBlock::new);
	public static final DeferredBlock<Block> APPLE = REGISTRY.register("apple", AppleBlock::new);
	public static final DeferredBlock<Block> INGOT_MOLD = REGISTRY.register("ingot_mold", IngotMoldBlock::new);
	public static final DeferredBlock<Block> INGOT_CLAY_MOLD = REGISTRY.register("ingot_clay_mold", IngotClayMoldBlock::new);
	public static final DeferredBlock<Block> HEMP = REGISTRY.register("hemp", HempBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			AppleOakLeavesBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			AppleOakLeavesBlock.itemColorLoad(event);
		}
	}
}
