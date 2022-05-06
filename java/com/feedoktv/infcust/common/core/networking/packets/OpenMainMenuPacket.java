package com.feedoktv.infcust.common.core.networking.packets;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.networking.AbstractMessage;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenMainMenuPacket extends AbstractMessage<OpenMainMenuPacket> {
    @Override
    public void encode(OpenMainMenuPacket message, PacketBuffer buffer) {

    }

    @Override
    public OpenMainMenuPacket decode(PacketBuffer buffer) {
        return new OpenMainMenuPacket();
    }

    @Override
    public void handle(OpenMainMenuPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->
            {
                InfCust.LOGGER.error("OpenMainMenuPacket");
                InfCust.eventHandlerClient.OpenCustMenu();
            });
        ctx.get().setPacketHandled(true);
    }
}
