package com.feedoktv.infcust.common.core.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class NetworkMessage {

    public NetworkMessage() {
    }

    public abstract void encode(PacketBuffer buffer);


    public abstract void decode(PacketBuffer buffer);


    public abstract void handle(Supplier<NetworkEvent.Context> ctx);


    public void _handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handle(ctx);
        });
        ctx.get().setPacketHandled(true);
    }
}
