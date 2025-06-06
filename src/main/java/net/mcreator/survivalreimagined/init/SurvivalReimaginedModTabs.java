
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SurvivalReimaginedModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SURVIVAL_REBORN = REGISTRY.register("survival_reborn",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.survival_reimagined.survival_reborn")).icon(() -> new ItemStack(SurvivalReimaginedModItems.HEART.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SurvivalReimaginedModItems.FLINT_TOOL.get());
				tabData.accept(SurvivalReimaginedModItems.OAK_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.DARK_OAK_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.SPRUCE_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.BIRCH_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.MANGROVE_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.CHERRY_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.ACACIA_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.JUNGLE_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.CRIMSON_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.WARPED_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_OAK_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_DARK_OAK_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_SPRUCE_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_BIRCH_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_MANGROVE_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_CHERRY_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_ACACIA_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_JUNGLE_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_CRIMSON_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.LARGE_WARPED_BARK.get());
				tabData.accept(SurvivalReimaginedModItems.STONE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.HEMP_FIBER.get());
				tabData.accept(SurvivalReimaginedModItems.COPPER_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.COPPER_NUGGET.get());
				tabData.accept(SurvivalReimaginedModItems.COPPER_CHISEL.get());
				tabData.accept(SurvivalReimaginedModItems.SMALL_COAL_CHUNK.get());
				tabData.accept(SurvivalReimaginedModBlocks.TIN_ORE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.RAW_TIN.get());
				tabData.accept(SurvivalReimaginedModItems.TIN_INGOT.get());
				tabData.accept(SurvivalReimaginedModItems.TIN_NUGGET.get());
				tabData.accept(SurvivalReimaginedModItems.DEEPSLATE_ROCK.get());
				tabData.accept(SurvivalReimaginedModBlocks.FORGE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_INGOT.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_BRONZE.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_IRON.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_GOLD.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_COPPER.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_TIN.get());
				tabData.accept(SurvivalReimaginedModItems.STONE_HAMMER.get());
				tabData.accept(SurvivalReimaginedModBlocks.METAL_REFINING_TABLE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.OAK_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.DARK_OAK_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.SPRUCE_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.BIRCH_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.ACACIA_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.JUNGLE_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.CHERRY_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.MANGROVE_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.CRIMSON_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.WARPED_PLANK.get());
				tabData.accept(SurvivalReimaginedModItems.STONE_SAW.get());
				tabData.accept(SurvivalReimaginedModItems.CLAY_BRICK.get());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_CRUCIBLE.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CRUCIBLE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_PICKAXE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_AXE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_SWORD.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_SHOVEL.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_HOE.get());
				tabData.accept(SurvivalReimaginedModItems.COPPER_HANDLE.get());
				tabData.accept(SurvivalReimaginedModBlocks.AXE_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.PICKAXE_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SWORD_BLADE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.HOE_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SHOVEL_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SAW_BLADE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.HAMMER_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.HELMET_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CHESTPLATE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.LEGGING_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.BOOTS_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_SWORD_BLADE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_PICKAXE_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_AXE_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_SHOVEL_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_HOE_BLADE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_HAMMER_HEAD_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_SAW_BLADE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_HELMET_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_CHESTPLATE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_LEGGINGS_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_BOOTS_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_ARMOR_HELMET.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_ARMOR_CHESTPLATE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_ARMOR_LEGGINGS.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_ARMOR_BOOTS.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_SAW.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_HAMMER.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_PICKAXE_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_AXE_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_SWORD_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_HOE_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_SHOVEL_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_HAMMER_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_SAW_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_SAW.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_HAMMER.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_HELMET.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_CHESTPLATE.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_LEGGINGS.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_BOOTS.get());
				tabData.accept(SurvivalReimaginedModItems.IRON_CHUNK.get());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_BRONZE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.TIN_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.ANDESITE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.GRANITE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.DIORITE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.DRIPSTONE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.CALCITE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.TUFF_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.MOSSY_STONE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.NETHERRACK_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.END_STONE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.BLACKSTONE_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.BASALT_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.BOAT_PADDLES.get());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_RAW_TIN.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_TIN.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.COW_CARCASS.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.STONE_KNIFE.get());
				tabData.accept(SurvivalReimaginedModItems.COW_HIDE.get());
				tabData.accept(SurvivalReimaginedModBlocks.COW_LEG.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.COW_HEAD.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BRAIN.get());
				tabData.accept(SurvivalReimaginedModItems.HEART_ITEM.get());
				tabData.accept(SurvivalReimaginedModItems.INTESTINES.get());
				tabData.accept(SurvivalReimaginedModItems.STOMACH.get());
				tabData.accept(SurvivalReimaginedModItems.LIVER.get());
				tabData.accept(SurvivalReimaginedModItems.LUNGS.get());
				tabData.accept(SurvivalReimaginedModItems.COOKED_BRAIN.get());
				tabData.accept(SurvivalReimaginedModItems.COOKED_HEART.get());
				tabData.accept(SurvivalReimaginedModItems.COOKED_INTESTINES.get());
				tabData.accept(SurvivalReimaginedModItems.COOKED_LIVER.get());
				tabData.accept(SurvivalReimaginedModItems.COOKED_STOMACH.get());
				tabData.accept(SurvivalReimaginedModItems.COOKED_LUNGS.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_BRAIN.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_HEART.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_INTESTINES.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_LIVER.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_LUNGS.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_STOMACH.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_COD.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_SALMAN.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_CHICKEN.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_RABBIT.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_MUTTON.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_PORKCHOP.get());
				tabData.accept(SurvivalReimaginedModItems.SPOILED_BEEF.get());
				tabData.accept(SurvivalReimaginedModItems.SALT.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_STEAK.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_PORKCHOP.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_CHICKEN.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_RABBIT.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_MUTTON.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_HEART.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_INTESTINES.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_BRAIN.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_LIVER.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_STOMACH.get());
				tabData.accept(SurvivalReimaginedModItems.CURED_LUNGS.get());
				tabData.accept(SurvivalReimaginedModBlocks.SAND_SALT_DEPOSIT.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SHEEP_CARCASS.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.SHEEP_HIDE.get());
				tabData.accept(SurvivalReimaginedModBlocks.SHEEP_LEG.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SHEEP_HEAD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CHICKEN_CARCASS.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.PIG_CARCASS.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.PIG_HEAD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.PIG_LEG.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_KNIFE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_KNIFE_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.WOODEN_KNIFE.get());
				tabData.accept(SurvivalReimaginedModItems.SMALL_STICK.get());
				tabData.accept(SurvivalReimaginedModBlocks.KNIFE_BLADE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CLAY_KNIFE_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.SMALL_COPPER_HANDLE.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_MANGANESE.get());
				tabData.accept(SurvivalReimaginedModItems.MANGANESE_INGOT.get());
				tabData.accept(SurvivalReimaginedModItems.RAW_MANGANESE.get());
				tabData.accept(SurvivalReimaginedModItems.MANGANESE_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.MANGANESE_NUGGET.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_STEEL.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_INGOT.get());
				tabData.accept(SurvivalReimaginedModBlocks.MANGANESE_ORE.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.DEEPSLATE_MANGANESE_ORE.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_STEEL.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_MANGANESE.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_RAW_MANGANESE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.STEEL_SWORD.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_PICKAXE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_AXE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_SHOVEL.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_ARMOR_HELMET.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_ARMOR_CHESTPLATE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_ARMOR_LEGGINGS.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_ARMOR_BOOTS.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_KNIFE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_HAMMER.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_SWORD_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_PICKAXE_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_AXE_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_SHOVEL_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_HOE_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_KNIFE_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_HAMMER_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_SAW_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_HANDLE.get());
				tabData.accept(SurvivalReimaginedModItems.SMALL_BRONZE_HANDLE.get());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_NUGGET.get());
				tabData.accept(SurvivalReimaginedModItems.GOLD_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.SANDSTONE_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.RED_SANDSTONE_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.URANIUM_SANDSTONE_DEPOSIT.get());
				tabData.accept(SurvivalReimaginedModItems.URANIUM_RED_SANDSTONE_DEPOSIT.get());
				tabData.accept(SurvivalReimaginedModItems.GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.DIRT_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.SAND_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.RED_SAND_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.COARSE_DIRT_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.ROOTED_DIRT_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.GRAVEL_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.SOUL_SAND_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.MUD_PILE.get());
				tabData.accept(SurvivalReimaginedModItems.URANIUM_DUST.get());
				tabData.accept(SurvivalReimaginedModItems.URANIUM.get());
				tabData.accept(SurvivalReimaginedModItems.RAW_REDSTONE.get());
				tabData.accept(SurvivalReimaginedModItems.REDSTONE_CHUNK.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_REDSTONE.get());
				tabData.accept(SurvivalReimaginedModItems.REDSTONE_INGOT.get());
				tabData.accept(SurvivalReimaginedModBlocks.BLOCK_OF_RAW_REDSTONE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BRONZE_CHISEL.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_CHISEL.get());
				tabData.accept(SurvivalReimaginedModItems.STEEL_NUGGET.get());
				tabData.accept(SurvivalReimaginedModItems.MUD_ROCK.get());
				tabData.accept(SurvivalReimaginedModBlocks.COBBLED_SANDSTONE.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.COBBLED_RED_SANDSTONE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.OBSIDIAN_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.CRYING_OBSIDIAN_ROCK.get());
				tabData.accept(SurvivalReimaginedModItems.EMBEDDED_DIAMOND.get());
				tabData.accept(SurvivalReimaginedModItems.DEEPSLATE_EMBEDDED_DIAMOND.get());
				tabData.accept(SurvivalReimaginedModItems.EMBEDDED_EMERALD.get());
				tabData.accept(SurvivalReimaginedModItems.DEEPSLATE_EMBEDDED_EMERALD.get());
				tabData.accept(SurvivalReimaginedModItems.ANCIENT_DEBRIS_CHUNK.get());
				tabData.accept(SurvivalReimaginedModBlocks.MINERAL_PROCESSING_TABLE.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.REDSTONE_CHARGED_URANIUM_DUST.get());
				tabData.accept(SurvivalReimaginedModItems.REACTOR_ROD.get());
				tabData.accept(SurvivalReimaginedModItems.DEPLETED_REACTOR_ROD.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_PLATED_INGOT.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_SWORD_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_AXE_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_HOE_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_PICKAXE_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_SHOVEL_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_KNIFE_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_HAMMER_HEAD.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_SAW_BLADE.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_HAMMER.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_KNIFE.get());
				tabData.accept(SurvivalReimaginedModItems.DIAMOND_CHISEL.get());
				tabData.accept(SurvivalReimaginedModItems.OBSIDIAN_HANDLE.get());
				tabData.accept(SurvivalReimaginedModItems.SMALL_OBSIDIAN_HANDLE.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_PLATED_DIAMOND.get());
				tabData.accept(SurvivalReimaginedModBlocks.EMBEDDED_OBSIDIAN.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.BACKPACK.get());
				tabData.accept(SurvivalReimaginedModItems.GOLD_ROD.get());
				tabData.accept(SurvivalReimaginedModItems.BLOOD_MOON_ZOMBIE_SPAWN_EGG.get());
				tabData.accept(SurvivalReimaginedModItems.FLESH.get());
				tabData.accept(SurvivalReimaginedModItems.HEART_OF_THE_BLOOD_MOON.get());
				tabData.accept(SurvivalReimaginedModItems.HEART_OF_THE_NETHER.get());
				tabData.accept(SurvivalReimaginedModItems.BLOOD_MOONS_MUSIC_DISC.get());
				tabData.accept(SurvivalReimaginedModItems.BLOOD_MOON_DISC_FRAGMENT.get());
				tabData.accept(SurvivalReimaginedModBlocks.APPLE_OAK_LEAVES.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.APPLE_TREE_SAPLING.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.EYE_OF_ENDER_FUSION_DUST.get());
				tabData.accept(SurvivalReimaginedModItems.WHITE_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.ORANGE_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.MAGENTA_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.LIGHT_BLUE_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.YELLOW_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.LIME_GREEN_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.PINK_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.BLACK_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.LIGHT_GREY_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.CYAN_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.PURPLE_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.BLUE_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.GREEN_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.BROWN_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.RED_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModItems.GREY_GLASS_SHARD.get());
				tabData.accept(SurvivalReimaginedModBlocks.INGOT_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.INGOT_CLAY_MOLD.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.HEMP_SEEDS.get());
				tabData.accept(SurvivalReimaginedModItems.HEMP_LEAF.get());
				tabData.accept(SurvivalReimaginedModItems.HEMP_PAPER.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_NETHERITE.get());
				tabData.accept(SurvivalReimaginedModItems.NETHERITE_HAMMER.get());
				tabData.accept(SurvivalReimaginedModItems.NETHERITE_KNIFE.get());
				tabData.accept(SurvivalReimaginedModItems.NETHERITE_SAW.get());
				tabData.accept(SurvivalReimaginedModItems.WOOD_INGOT.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_ZINC.get());
				tabData.accept(SurvivalReimaginedModItems.ROUGH_BRASS.get());
				tabData.accept(SurvivalReimaginedModItems.RAW_ZINC_NUGGET.get());
				tabData.accept(SurvivalReimaginedModBlocks.LIMESTONE_ROCK.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.VERIDIUM_ROCK.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.OCHRUM_ROCK.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.CRIMSITE_ROCK.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SCORCHIA_ROCK.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.ASURINE_CRYSTAL.get().asItem());
				tabData.accept(SurvivalReimaginedModBlocks.SCORIA_ROCK.get().asItem());
				tabData.accept(SurvivalReimaginedModItems.SMALL_DIAMOND.get());
				tabData.accept(SurvivalReimaginedModItems.SMALL_EMERALD.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(SurvivalReimaginedModItems.STEEL_HOE.get());
			tabData.accept(SurvivalReimaginedModItems.STEEL_SAW.get());
			tabData.accept(SurvivalReimaginedModItems.DIAMOND_SAW.get());
		}
	}
}
