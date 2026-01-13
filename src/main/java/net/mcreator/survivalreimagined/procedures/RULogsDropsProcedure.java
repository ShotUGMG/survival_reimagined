package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RULogsDropsProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double X = 0;
		double Y = 0;
		double Z = 0;
		X = x + 0.5;
		Y = y + 0.5;
		Z = z + 0.5;
		if (ModList.get().isLoaded("regions_unexplored") == true) {
			if (getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
					if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem)) {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/alpha_oak_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.ALPHA_OAK_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/ashen_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.ASHEN_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/baobab_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.BAOBAB_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/blackwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.BLACKWOOD_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/brimwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.BRIMWOOD_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/cobalt_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.COBALT_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/cypress_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.CYPRESS_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/dead_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.DEAD_BARK_RU.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/eucalyptus_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.EUCALYPTUS_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/joshua_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.JOSHUA_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/kapok_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.KAPOK_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/larch_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.LARCH_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/magma_brimwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.BRIMWOOD_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/magnolia_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.MAGNOILA_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/mauve_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.MAUVE_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/palm_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.PALM_BARK_RU.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/pine_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.PINE_BARK_RU.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/redwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.REDWOOD_BARK_RU.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/silver_birch_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.SILVER_BIRCH_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/socotra_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.SOCOTRA_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/willow_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.WILLOW_BARK_RU.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/small_oak_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.LARGE_OAK_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/maple_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack(SurvivalReimaginedModItems.MAPLE_BARK_RU.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/alpha_oak_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/alpha_oak_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/ashen_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/ashen_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/baobab_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/baobab_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/blackwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/blackwood_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/brimwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/brimwood_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/cobalt_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/cobalt_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/cypress_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/cypress_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/dead_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/dead_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/eucalyptus_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/eucalyptus_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/joshua_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/joshua_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/kapok_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/kapok_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/larch_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/larch_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/magma_brimwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/magma_brimwood_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/magnolia_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/magnolia_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/mauve_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/mauve_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/palm_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/palm_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/pine_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/pine_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/redwood_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/redwood_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/silver_birch_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/silver_birch_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/socotra_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/alpha_oak_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/willow_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/willow_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/small_oak_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/small_oak_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("regions_unexplored:barked/maple_logs")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, X, Y, Z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("regions_unexplored:barked/maple_logs")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}