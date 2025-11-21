package net.mcreator.survivalreimagined.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class SurvivalReimaginedConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> ZOMBIFICATION;
	public static final ModConfigSpec.ConfigValue<Boolean> IMMUNITY_ZOMBIFICATION;
	public static final ModConfigSpec.ConfigValue<Double> TIME_ZOMBIFICATION;
	public static final ModConfigSpec.ConfigValue<Double> CHANCE_ZOMBIFICATION;
	public static final ModConfigSpec.ConfigValue<Boolean> DARKNESS_EFFECTS;
	public static final ModConfigSpec.ConfigValue<Double> DARKNESS_LEVEL;
	public static final ModConfigSpec.ConfigValue<Double> LIGHT_LEVEL;
	public static final ModConfigSpec.ConfigValue<Double> PARANOIA_DELAY;
	public static final ModConfigSpec.ConfigValue<Boolean> BINDING_SCULK;

	public static final ModConfigSpec.ConfigValue<Boolean> BLOOD_MOON;
	public static final ModConfigSpec.ConfigValue<Boolean> BLOODMOON_SLEEP;
	public static final ModConfigSpec.ConfigValue<Boolean> DISABLE_MOBS;
	public static final ModConfigSpec.ConfigValue<Double> FULL_MOON;
	public static final ModConfigSpec.ConfigValue<Double> PHASES_ONE;
	public static final ModConfigSpec.ConfigValue<Double> PHASES_TWO;

	public static final ModConfigSpec.ConfigValue<Double> BREAK_SPEED;
	public static final ModConfigSpec.ConfigValue<Boolean> VANILLA_PORTAL;
	public static final ModConfigSpec.ConfigValue<Boolean> HUNGER_VANILLA;
	public static final ModConfigSpec.ConfigValue<Boolean> DEBUFF_HUNGER;
	public static final ModConfigSpec.ConfigValue<Boolean> HUNGEREFFECT_VANILLA;
	public static final ModConfigSpec.ConfigValue<Boolean> HUNGER_RAWFOOD;
	public static final ModConfigSpec.ConfigValue<Boolean> SPOIL_FOOD;

	public static final ModConfigSpec.ConfigValue<Boolean> BLEEDING_EFFECT;
	public static final ModConfigSpec.ConfigValue<Double> BLEED_CHANCE;
	static {
		BUILDER.push("Status Effects");
		BUILDER.push("Zombification");
		ZOMBIFICATION = BUILDER.comment("Allow Zombies to inflict Zombfication").define("Zombification", true);
		IMMUNITY_ZOMBIFICATION = BUILDER.comment("Allow the Golden Heart to grant the player immunity to Zombification").define("Zombification Immunity", true);
		TIME_ZOMBIFICATION = BUILDER.comment("Time it takes for Zombification to progress to next stage. Default is 6000 in ticks (5 Minutes)").define("Zombification Time", (double) 6000);
		CHANCE_ZOMBIFICATION = BUILDER.comment("Chance for a Zombie to inflict Zombification. Default is 0.25 (25%)").define("Zombification Chance", (double) 0.25);
		BUILDER.pop();
		BUILDER.push("Paranoia/Fear");
		DARKNESS_EFFECTS = BUILDER.comment("Allow the player to feel paranoia/fear if in dark areas").define("Paranoia and Fear", true);
		DARKNESS_LEVEL = BUILDER.comment("Minimum Light Level needed for Darkness effects to take effect (Default is 0, Range: 0 - 15)").define("Darkness Level", (double) 0);
		LIGHT_LEVEL = BUILDER.comment("Minimum Light Level needed for Darkness effects to stop take effect (Default is 5, Range: 0 - 15)").define("Light Level", (double) 5);
		PARANOIA_DELAY = BUILDER.comment("Time in ticks for Paranoia to turn into Fear (Default is 1000 in ticks)").define("Paranoia To Fear Delay", (double) 1000);
		BUILDER.pop();
		BUILDER.push("Binding Sculk");
		BINDING_SCULK = BUILDER.comment("Binding Sculk applied when walking over Sculk").define("Binding Sculk", true);
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.push("Events");
		BUILDER.push("Blood Moon");
		BLOOD_MOON = BUILDER.comment("Can Blood Moon happen?").define("Blood Moon", true);
		BLOODMOON_SLEEP = BUILDER.comment("Allow Sleeping through Bloodmoon").define("Bloodmoon Sleep", false);
		DISABLE_MOBS = BUILDER.comment("Disable Zombies and Skeletons spawns during bloodmoon").define("Disable Normal Mob Spawning", true);
		BUILDER.push("Blood Moon Spawn Chance");
		FULL_MOON = BUILDER.comment("Full Moon Bloodmoon chance. Defualt is 0.15 (15%)").define("Full Moon Chance", (double) 0.15);
		PHASES_ONE = BUILDER.comment("Gibbous and Quarter phases chance. Defualt is 0.1 (10%) ").define("Gibbous/Quarter Chance", (double) 0.1);
		PHASES_TWO = BUILDER.comment("New Moon and crescent phases chance. Defualt is 0.075 (7.5%) ").define("New Moon/Crescent Chance", (double) 0.075);
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.push("Gameplay");
		BUILDER.push("Mechanic Overrides");
		BREAK_SPEED = BUILDER.comment("Block Breaking Speed. Default is 0.45 (45%) Vanilla is 1 (100%)").define("Block Break Speed", (double) 0.45);
		VANILLA_PORTAL = BUILDER.comment("Disable Nether portal override mechanics (reverts to vanilla nether portal)").define("Vanilla Portal", false);
		BUILDER.pop();
		BUILDER.push("Hunger");
		HUNGER_VANILLA = BUILDER.comment("Disable hunger bar changes (Reverts to vanilla mechanics)").define("Vanilla Hunger", false);
		DEBUFF_HUNGER = BUILDER.comment("Hunger debuffs (Can't jump on 2 drumsticks, slower walk speed on 1 drumstick)").define("Hunger Debuffs", true);
		HUNGEREFFECT_VANILLA = BUILDER.comment("Disable Hunger Effect changes (Reverts to Vanilla mechanics)").define("Vanilla Hunger Effect", false);
		HUNGER_RAWFOOD = BUILDER.comment("Eating Raw Food gives the player hunger status effect").define("Raw Food", true);
		SPOIL_FOOD = BUILDER.comment("Allow meat to spoil").define("Food Spoil", true);
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.push("Experimental Features");
		BUILDER.push("Bleeding");
		BLEEDING_EFFECT = BUILDER.comment("Allow Crimson Arachnid to Inflict Bleeding").define("Bleeding", false);
		BLEED_CHANCE = BUILDER.comment("Chance to contract Bleeding Effect. Defualt is 0.1 (10%)").define("bleeding_chance", (double) 0.1);
		BUILDER.pop();
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
