package net.mcreator.survivalreimagined.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class SurvivalReimaginedModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, SurvivalReimaginedMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());
	public static double OceansWrathDamageMultiplier = 0;
	public static AttributeModifier OceansWrath = null;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SurvivalReimaginedMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		SurvivalReimaginedMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.GaskMaskDamage = original.GaskMaskDamage;
		clone.GasMaskHeal = original.GasMaskHeal;
		clone.DiamondLogicNumber = original.DiamondLogicNumber;
		clone.ZombificationImmune = original.ZombificationImmune;
		clone.PlayerPositionSet = original.PlayerPositionSet;
		clone.NBTPercentage = original.NBTPercentage;
		if (!event.isWasDeath()) {
			clone.SpoilTimer = original.SpoilTimer;
			clone.HungerSprinting = original.HungerSprinting;
			clone.HungerSwimming = original.HungerSwimming;
			clone.ScrapeHandler = original.ScrapeHandler;
			clone.ItemCount = original.ItemCount;
			clone.WeightMediumItems = original.WeightMediumItems;
			clone.HungryProc = original.HungryProc;
			clone.Hungry = original.Hungry;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(player.level());
			SavedData worlddata = WorldVariables.get(player.level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(player.level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "survival_reimagined_worldvars";
		boolean _syncDirty = false;
		public double HeartBeat = 0;
		public double EffectDanger = 0;
		public double SkyboxAlpha = 0;
		public double SkyboxClock = 0.0;
		public double BloodmoonFog = 0;
		public double FogStart = 0;
		public double FogEnd = 0;
		public double FruitTree = 0;
		public boolean GhostSpawned = false;
		public double GhostSpawnChance = 0;
		public double GhostSpawnNumberVariable = 0;
		public double GhostDespawnTimer = 0;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			HeartBeat = nbt.getDouble("HeartBeat");
			EffectDanger = nbt.getDouble("EffectDanger");
			SkyboxAlpha = nbt.getDouble("SkyboxAlpha");
			SkyboxClock = nbt.getDouble("SkyboxClock");
			BloodmoonFog = nbt.getDouble("BloodmoonFog");
			FogStart = nbt.getDouble("FogStart");
			FogEnd = nbt.getDouble("FogEnd");
			FruitTree = nbt.getDouble("FruitTree");
			GhostSpawned = nbt.getBoolean("GhostSpawned");
			GhostSpawnChance = nbt.getDouble("GhostSpawnChance");
			GhostSpawnNumberVariable = nbt.getDouble("GhostSpawnNumberVariable");
			GhostDespawnTimer = nbt.getDouble("GhostDespawnTimer");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("HeartBeat", HeartBeat);
			nbt.putDouble("EffectDanger", EffectDanger);
			nbt.putDouble("SkyboxAlpha", SkyboxAlpha);
			nbt.putDouble("SkyboxClock", SkyboxClock);
			nbt.putDouble("BloodmoonFog", BloodmoonFog);
			nbt.putDouble("FogStart", FogStart);
			nbt.putDouble("FogEnd", FogEnd);
			nbt.putDouble("FruitTree", FruitTree);
			nbt.putBoolean("GhostSpawned", GhostSpawned);
			nbt.putDouble("GhostSpawnChance", GhostSpawnChance);
			nbt.putDouble("GhostSpawnNumberVariable", GhostSpawnNumberVariable);
			nbt.putDouble("GhostDespawnTimer", GhostDespawnTimer);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "survival_reimagined_mapvars";
		boolean _syncDirty = false;
		public boolean BloodMoonTimer = false;
		public boolean AnnouncementPlayed = false;
		public boolean sculk_hearts = false;
		public double MPT_Time = 0;
		public double BloodMoonChanceRan = 0;
		public boolean isBloodMoon = false;
		public double BloodMoon = 0;
		public boolean ValueSetBloodMoon = false;
		public boolean isDay = false;
		public ItemStack MoldOutput = ItemStack.EMPTY;
		public boolean BunkerPlaced = false;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			BloodMoonTimer = nbt.getBoolean("BloodMoonTimer");
			AnnouncementPlayed = nbt.getBoolean("AnnouncementPlayed");
			sculk_hearts = nbt.getBoolean("sculk_hearts");
			MPT_Time = nbt.getDouble("MPT_Time");
			BloodMoonChanceRan = nbt.getDouble("BloodMoonChanceRan");
			isBloodMoon = nbt.getBoolean("isBloodMoon");
			BloodMoon = nbt.getDouble("BloodMoon");
			ValueSetBloodMoon = nbt.getBoolean("ValueSetBloodMoon");
			isDay = nbt.getBoolean("isDay");
			MoldOutput = ItemStack.parseOptional(lookupProvider, nbt.getCompound("MoldOutput"));
			BunkerPlaced = nbt.getBoolean("BunkerPlaced");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("BloodMoonTimer", BloodMoonTimer);
			nbt.putBoolean("AnnouncementPlayed", AnnouncementPlayed);
			nbt.putBoolean("sculk_hearts", sculk_hearts);
			nbt.putDouble("MPT_Time", MPT_Time);
			nbt.putDouble("BloodMoonChanceRan", BloodMoonChanceRan);
			nbt.putBoolean("isBloodMoon", isBloodMoon);
			nbt.putDouble("BloodMoon", BloodMoon);
			nbt.putBoolean("ValueSetBloodMoon", ValueSetBloodMoon);
			nbt.putBoolean("isDay", isDay);
			nbt.put("MoldOutput", MoldOutput.saveOptional(lookupProvider));
			nbt.putBoolean("BunkerPlaced", BunkerPlaced);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			_syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SurvivalReimaginedMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		boolean _syncDirty = false;
		public double SpoilTimer = 0;
		public double HungerSprinting = 0;
		public double HungerSwimming = 0;
		public double GaskMaskDamage = 0;
		public double GasMaskHeal = 0;
		public double ScrapeHandler = 0;
		public double DiamondLogicNumber = 0;
		public boolean ZombificationImmune = false;
		public double ItemCount = 0;
		public ItemStack WeightMediumItems = ItemStack.EMPTY;
		public double HungryProc = 0;
		public boolean Hungry = false;
		public boolean PlayerPositionSet = false;
		public double NBTPercentage = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("SpoilTimer", SpoilTimer);
			nbt.putDouble("HungerSprinting", HungerSprinting);
			nbt.putDouble("HungerSwimming", HungerSwimming);
			nbt.putDouble("GaskMaskDamage", GaskMaskDamage);
			nbt.putDouble("GasMaskHeal", GasMaskHeal);
			nbt.putDouble("ScrapeHandler", ScrapeHandler);
			nbt.putDouble("DiamondLogicNumber", DiamondLogicNumber);
			nbt.putBoolean("ZombificationImmune", ZombificationImmune);
			nbt.putDouble("ItemCount", ItemCount);
			nbt.put("WeightMediumItems", WeightMediumItems.saveOptional(lookupProvider));
			nbt.putDouble("HungryProc", HungryProc);
			nbt.putBoolean("Hungry", Hungry);
			nbt.putBoolean("PlayerPositionSet", PlayerPositionSet);
			nbt.putDouble("NBTPercentage", NBTPercentage);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			SpoilTimer = nbt.getDouble("SpoilTimer");
			HungerSprinting = nbt.getDouble("HungerSprinting");
			HungerSwimming = nbt.getDouble("HungerSwimming");
			GaskMaskDamage = nbt.getDouble("GaskMaskDamage");
			GasMaskHeal = nbt.getDouble("GasMaskHeal");
			ScrapeHandler = nbt.getDouble("ScrapeHandler");
			DiamondLogicNumber = nbt.getDouble("DiamondLogicNumber");
			ZombificationImmune = nbt.getBoolean("ZombificationImmune");
			ItemCount = nbt.getDouble("ItemCount");
			WeightMediumItems = ItemStack.parseOptional(lookupProvider, nbt.getCompound("WeightMediumItems"));
			HungryProc = nbt.getDouble("HungryProc");
			Hungry = nbt.getBoolean("Hungry");
			PlayerPositionSet = nbt.getBoolean("PlayerPositionSet");
			NBTPercentage = nbt.getDouble("NBTPercentage");
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SurvivalReimaginedMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}