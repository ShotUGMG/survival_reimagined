#  Survival Reimagined 1.3.0 Update
## Generation and Ores
 **Increased generation depth from -64 to -256**
- Added Volcanic Layer and Kimberlite Layer
   - Volcanic layer generates below -64
   - Kimberlite layer generates below -128

- Ores are now visually real-world accurate
   1. Copper Ores
      - Malachite
      - Azurite
      - Native Copper
   2. Tin Ores
      - Cassiterite
   3. Iron Ores
      - Hematite
      - Magnetite
   4. Managanese Ores
      - Manganite
      - Pyrolusite
   5. Gold Ores
      - Calaverite
      - Native Gold
   6. Silver Ores (New)
      - Argentite
      - Native Silver
   7. Uranium
      - Uraninite
      - Uranophane
   8. Titanium
      - Ilmenite
   9. Lapis Lazuli
      - Lazurite

   _Added Basalt and Kimberlite variants to most ores_
- Added Chemical minerals
   - Sulfur
   - Nitre (Saltpeter)

   _Allows crafting of gunpowder if combined with charcoal powder and Mortar & Pestal_

_These variants will display what type of metal it is as a tooltip in-game_
- Added Gems
   - Ruby
   - Sapphire
   - Ambee
- Added Rock / stone types
   - Stone
   - Deepslate
   - Basalt
   - Kimberlite

   _All 4 have a stalagmite and stalactite variant_

## Rune Magic Infuser and Infusing gear
- Added Runes for:
   - Diamond
   - Emerald
   - Amber
   - Sapphire
   - Ruby
   - Lapis
- Added Rune Magic Infuser (Functional Block)

_Runes give certain benefits based on what the gem was infused on and what gem was used (Tool, Armor, Weapon)_

## Wisteria Forest
- Added Wisteria Forest
   - Wisteria Wood set
   - Wisteria Spider Lily
   - Wisteria Leaf Litter
   - Wisteria Vines

## Progression
- Added 16 New Advancements to the progression tree
- Modified some advancements to cause less confusion
- Fixed bugs with a few advancements

## Mod Configuration
- Config for Bloodmoon
   - Option to Enable/Disable Blood Moon
   - Options to tweak chances of Bloodmoon per Moon Phase groups _(Full, New, Quarter, Gibbous, Crescent)_
   - Option to sleep through Blood Moon
- Config for Paranoia/Fear
   - Option to Enable/Disable Paranoia/Fear
   - Options to adjust min and max light levels for effect inflict and effect remove.
- Config for Zombification
   - Option to enable/disable Zombification
   - Option to tweak the chance of Zombification inflicting 
- Config for Mechanic Overrides
   - Hunger bar changes
   - Hunger Effect changes
   - Mining Speed changes
- Expiremental Features
   - Option to enable/disable Bleeding status effect _(only crimson arachnid can inflict Bleeding)_

   _Note: (Mod uses .toml file, recommended to use a mod to access toml files such as Configured. config file name is srconfig.toml)_

## Compat
   - Compatibility with Dynamic Light's mods (Dynamic Lights, Lamb's Dynamic Lights)
      - Holding a torch (or any reasonable light source) with a Dynamic Lights mod installed will now prevent paranoia
   - Added JEI information tab to all Rune Items
   - Updated Create compat.
      - Added recipes for:
         - Andesite Alloy
      - Modified recipes for:
         - Brass Ingot

   _Note: If Create Mod is installed, Zinc will be renamed to Sphalerite_

## Additions/Changes/Bug Fixes
- Zombification now has a 25% chance of inflicting on the player. Blocking with a shield prevents Zombification.
- Overall Mining Speed changed from 100% (Vanilla) --> 45%
- Tweaked spawnrates of Copper Chunks, Flint and Stone Rocks
- Modified Loot-tables of all metal-based ores
- Tweaked Hunger Effect rates to be more balanced
- Blood Moon
   - Added Crimson Arachnid
   - Added Crimson Thread.
      - Crimson Thread is now needed to craft Heart of the Bloodmoon_
   - Changed Blood Moon Zombie AI and removed Bloodmoon Zombie SFX
- Flint must now be scraped on a stoney sruface to craft Flint Tool
- Texture changes for Tin and Forge
- Added mossy cobblestone loot table
- Tweaked growth rates of Hemp
 
