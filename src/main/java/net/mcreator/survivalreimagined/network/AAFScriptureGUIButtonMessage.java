package net.mcreator.survivalreimagined.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.survivalreimagined.procedures.PreviousPageProcedure;
import net.mcreator.survivalreimagined.procedures.NextPageProcedure;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber
public record AAFScriptureGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<AAFScriptureGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SurvivalReimaginedMod.MODID, "aaf_scripture_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AAFScriptureGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AAFScriptureGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AAFScriptureGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<AAFScriptureGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AAFScriptureGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			NextPageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			PreviousPageProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SurvivalReimaginedMod.addNetworkMessage(AAFScriptureGUIButtonMessage.TYPE, AAFScriptureGUIButtonMessage.STREAM_CODEC, AAFScriptureGUIButtonMessage::handleData);
	}
}