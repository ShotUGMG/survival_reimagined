/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.function.Supplier;

public class SurvivalReimaginedModBoatTypes {
	public static final EnumProxy<Boat.Type> WISTERIA_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "survival_reimagined:wisteria_boat", SurvivalReimaginedModItems.WISTERIA_BOAT,
			(Supplier<Item>) () -> Items.AIR, (Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> RADIATED_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "survival_reimagined:radiated_boat", SurvivalReimaginedModItems.RADIATED_BOAT,
			(Supplier<Item>) () -> Items.AIR, (Supplier<Item>) () -> Items.STICK, false);
}