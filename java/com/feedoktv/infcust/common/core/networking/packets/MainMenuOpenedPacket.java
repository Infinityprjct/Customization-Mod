package com.feedoktv.infcust.common.core.networking.packets;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.networking.AbstractMessage;
import com.feedoktv.infcust.common.core.networking.PacketDispatcher;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

public class MainMenuOpenedPacket extends AbstractMessage<MainMenuOpenedPacket>
{
    private final String keyBindingDesc;

    public MainMenuOpenedPacket()
    {
        this("");
    }

    public MainMenuOpenedPacket(final String kb) { this.keyBindingDesc = kb; }

    public MainMenuOpenedPacket decode(final PacketBuffer buffer)
    {
        String keyBindingDesc = buffer.readUtf(64);
        return new MainMenuOpenedPacket(keyBindingDesc);
    }

    public void encode(final MainMenuOpenedPacket message, final PacketBuffer buffer)
    {
        buffer.writeUtf(message.keyBindingDesc, 64);
    }

    public void handle(final MainMenuOpenedPacket message, final Supplier<NetworkEvent.Context> ctx)
    {
        InfCust.LOGGER.error("PACKET");
        ServerPlayerEntity player = ctx.get().getSender();
        handleServerSide(message, ctx, Objects.requireNonNull(player));
    }

    private static void handleClientSide(final MainMenuOpenedPacket message, final Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(()->{
            if ("infcust.gui".equalsIgnoreCase(message.keyBindingDesc))
            {
                InfCust.eventHandlerClient.OpenCustMenu();
                InfCust.LOGGER.error("BLYADSTVO");
            }

        });
        ctx.get().setPacketHandled(true);
    }

    private static void handleServerSide(final MainMenuOpenedPacket message, final Supplier<NetworkEvent.Context> ctx, final ServerPlayerEntity player)
    {
        ctx.get().enqueueWork(()->{
            if ("infcust.gui".equalsIgnoreCase(message.keyBindingDesc))
            {
                InfCust.LOGGER.debug("PACKET MAIN GUI OPEN");
                PacketDispatcher.sendTo(new OpenMainMenuPacket(),player);
                //MusicOptionsUtil.setCtrlKey(player, true);
            }
            else
                PacketDispatcher.sendTo(new MainMenuOpenedPacket(message.keyBindingDesc), player);
        });
        ctx.get().setPacketHandled(true);
    }
}
