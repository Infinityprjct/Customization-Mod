package com.feedoktv.infcust.common.core.networking.packets;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability;
import com.feedoktv.infcust.common.core.networking.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CapabilityUpdateClientPacket extends AbstractMessage<CapabilityUpdateClientPacket> {

    private int hatId;
    private int playerId;

    public CapabilityUpdateClientPacket() {

    }

    public CapabilityUpdateClientPacket(int hatId, int id) {
        this.hatId = hatId;
        this.playerId = id;
    }

    @Override
    public void encode(CapabilityUpdateClientPacket message, PacketBuffer buffer) {
        buffer.writeInt(message.hatId);
        buffer.writeInt(message.playerId);
    }

    @Override
    public CapabilityUpdateClientPacket decode(PacketBuffer buffer) {
        int id = buffer.readInt();
        int playerId = buffer.readInt();
        return new CapabilityUpdateClientPacket(id, playerId);
    }

    @Override
    public void handle(CapabilityUpdateClientPacket message, Supplier<NetworkEvent.Context> ctx) {
        if (ctx.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
            ctx.get().enqueueWork(() ->
            {
                InfCust.LOGGER.error("[RECIEVED ON A CLIENT]");
                InfCust.LOGGER.error(Minecraft.getInstance().player.level.getEntity(message.playerId).getName().getString());
                Minecraft.getInstance().player.level.getEntity(message.playerId).getCapability(HatCapability.PLAYER_HAT_ID).ifPresent((Data) -> Data.setValue(message.hatId));
            });
            ctx.get().setPacketHandled(true);
        }
    }
}