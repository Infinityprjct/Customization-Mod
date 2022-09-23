package com.feedoktv.infcust.common.core.networking.packets;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability;
import com.feedoktv.infcust.common.core.networking.AbstractMessage;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TestPacket extends AbstractMessage<TestPacket> {
    @Override
    public void encode(TestPacket message, PacketBuffer buffer) {

    }

    @Override
    public TestPacket decode(PacketBuffer buffer) {
        return new TestPacket();
    }

    @Override
    public void handle(TestPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->
        {
            InfCust.LOGGER.debug("TEST PACKET");
            InfCust.LOGGER.error(ctx.get().getSender().getName().getString());
            ctx.get().getSender().getCapability(HatCapability.PLAYER_HAT_ID)
                    .ifPresent((Data) -> Data.setValue(1));
            InfCust.LOGGER.error(ctx.get().getSender().getCapability(HatCapability.PLAYER_HAT_ID)
                    .map(capa -> capa.getValue()));

            //PacketDispatcher.sendToDimension(new UpdateCapPacket(ctx.get().getSender().getUUID(), -1), World.OVERWORLD);

        });
        ctx.get().setPacketHandled(true);
    }
}
