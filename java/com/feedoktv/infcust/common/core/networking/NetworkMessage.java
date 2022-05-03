package com.feedoktv.infcust.common.core.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class NetworkMessage {
    /**
     * Must ALWAYS have a default constructor for the decode phase.
     */
    public NetworkMessage() {
    }

    /**
     * Override this method to encode this packet's data to the
     * {@link io.netty.buffer.ByteBuf}.
     *
     * @param buffer The buffer to write the data to.
     */
    public abstract void encode(PacketBuffer buffer);


    public abstract void decode(PacketBuffer buffer);

    /**
     * Override this method to perform any actions once the data has been decoded.
     *
     * @param ctx The context of the message.
     */
    public abstract void handle(Supplier<NetworkEvent.Context> ctx);

    /**
     * This method is raised by the packet handler and should not normally be
     * overridden.
     *
     * @param ctx The context of the message.
     */
    public void _handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handle(ctx);
        });
        ctx.get().setPacketHandled(true);
    }
}
