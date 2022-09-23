package com.feedoktv.infcust.common.core.networking.packets;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability;
import com.feedoktv.infcust.common.core.networking.AbstractMessage;
import com.feedoktv.infcust.common.core.networking.PacketDispatcher;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CapabilityUpdateServerPacket extends AbstractMessage<CapabilityUpdateServerPacket> {

    private int hatId;
    private int playerId;

    public CapabilityUpdateServerPacket() {

    }

    public CapabilityUpdateServerPacket(int hatId, int id) {
        this.hatId = hatId;
        this.playerId = id;
    }

    @Override
    public void encode(CapabilityUpdateServerPacket message, PacketBuffer buffer) {
        buffer.writeInt(message.hatId);
        buffer.writeInt(message.playerId);
    }

    @Override
    public CapabilityUpdateServerPacket decode(PacketBuffer buffer) {
        int id = buffer.readInt();
        int playerId = buffer.readInt();
        return new CapabilityUpdateServerPacket(id, playerId);
    }

    @Override
    public void handle(CapabilityUpdateServerPacket message, Supplier<NetworkEvent.Context> ctx) {
        if (ctx.get().getDirection().getReceptionSide() == LogicalSide.SERVER) {
            ctx.get().enqueueWork(() ->
            {
                InfCust.LOGGER.error("[PACKET ON SERVER]");
                ctx.get().getSender().getCapability(HatCapability.PLAYER_HAT_ID).ifPresent((Data) -> Data.setValue(message.hatId));
                PacketDispatcher.sendToAll(new CapabilityUpdateClientPacket(message.hatId, message.playerId));
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
