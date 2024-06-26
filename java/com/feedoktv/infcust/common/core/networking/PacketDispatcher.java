package com.feedoktv.infcust.common.core.networking;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.networking.packets.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketDispatcher
{
    private static final ResourceLocation CHANNEL_NAME = new ResourceLocation(InfCust.MOD_ID, "network");
    private static final String NETWORK_VERSION = new ResourceLocation(InfCust.MOD_ID, "1").toString();
    private static int packetId = 0;
    private static SimpleChannel channel;

    public static void register()
    {
        channel = NetworkRegistry.ChannelBuilder
                .named(CHANNEL_NAME)
                .clientAcceptedVersions(version -> true)
                .serverAcceptedVersions(version -> true)
                .networkProtocolVersion(() -> NETWORK_VERSION)
                .simpleChannel();

        // To Server Packets
        registerMessage(MainMenuOpenedPacket.class, new MainMenuOpenedPacket());

        // To Client packets
        registerMessage(OpenMainMenuPacket.class, new OpenMainMenuPacket());

        // Bisexual packets
        registerMessage(TestPacket.class, new TestPacket());
        registerMessage(CapabilityUpdateServerPacket.class, new CapabilityUpdateServerPacket());
        registerMessage(CapabilityUpdateClientPacket.class, new CapabilityUpdateClientPacket());
    }

    private static <MSG extends AbstractMessage<MSG>> void registerMessage(Class<MSG> messageType, AbstractMessage<MSG> message)
    {
        channel.registerMessage(packetId++, messageType, message::encode, message::decode, message::handle);
    }

    private PacketDispatcher() { /* NOP */ }

    /**
     * Send this message to the specified player's client-side counterpart. See
     * {@link SimpleChannel#send(PacketDistributor.PacketTarget, Object)}
     */
    public static <MSG> void sendTo(MSG message, ServerPlayerEntity player)
    {
        channel.send(PacketDistributor.PLAYER.with(()->player), message);
    }

    /**
     * Send this message to everyone. See
     * {@link SimpleChannel#send(PacketDistributor.PacketTarget, Object)}
     */
    public static <MSG> void sendToAll(MSG message)
    {
        channel.send(PacketDistributor.ALL.with(null), message);
    }

    /**
     * Send this message to everyone within a certain range of a point. See
     * {@link SimpleChannel#send(PacketDistributor.PacketTarget, Object)}
     */
    public static <MSG> void sendToAllAround(MSG message, PacketDistributor.TargetPoint point)
    {
        channel.send(PacketDistributor.NEAR.with(()->point), message);
    }

    /**
     * Sends a message to everyone within a certain range of the coordinates in
     * the same dimension. Shortcut to
     * {@link PacketDispatcher#sendToAllAround(MSG, PacketDistributor.TargetPoint)}
     */
    public static <MSG> void sendToAllAround(MSG message, RegistryKey<World> dimension, double x, double y, double z, double range)
    {
        sendToAllAround(message, new PacketDistributor.TargetPoint(x, y, z, range, dimension));
    }

    /**
     * Sends a message to everyone within a certain range of the player
     * provided. Shortcut to
     * {@link PacketDispatcher#sendToAllAround(MSG,  PlayerEntity, double)}
     */
    public static <MSG> void sendToAllAround(MSG message, PlayerEntity player, double range)
    {
        sendToAllAround(message, player.getCommandSenderWorld().dimension(), player.blockPosition().getX(), player.blockPosition().getY(), player.blockPosition().getY(), range);
    }

    /**
     * Send this message to everyone within the supplied dimension. See
     * {@link SimpleChannel#send(PacketDistributor.PacketTarget, Object)}
     */
    public static <MSG> void sendToDimension(MSG message, RegistryKey<World> dimension)
    {
        channel.send(PacketDistributor.DIMENSION.with( ()->dimension), message);
    }

    /**
     * Send this message to the server. See
     * {@link SimpleChannel#sendToServer(Object)}
     */
    public static <MSG> void sendToServer(MSG message)
    {
        channel.sendToServer(message);
    }

}