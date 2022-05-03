package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.networking.NetworkMessage;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Supplier;

public class NetworkHandler {

    private static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(InfCust.MOD_ID, InfCust.MOD_ID), () -> "1.0", client -> true, server -> true);

    @Nullable
    public static NetworkHandler instance = null;

    private static short id = 0;

    public static void init() {
        instance = new NetworkHandler();
    }

    public NetworkHandler() {

    }
    public void sendTo(PacketBuffer packet, ServerPlayerEntity player) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public void sendToAll(PacketBuffer packet) {
        CHANNEL.send(PacketDistributor.ALL.noArg(), packet);
    }

    public void sendToNear(PacketBuffer packet, PacketDistributor.TargetPoint point) {
        CHANNEL.send(PacketDistributor.NEAR.with(() -> point), packet);
    }

    //public void sendToServer(Class<PacketUpdateHat> packet) {
    //    CHANNEL.send(PacketDistributor.SERVER.noArg(), packet);
    //}

    public void sendToSeveralPlayers(PacketBuffer packet, List<NetworkManager> managers) {
        CHANNEL.send(PacketDistributor.NMLIST.with(() -> managers), packet);
    }

    public static <MSG extends NetworkMessage> void registerMessage(Class<MSG> type) {
        CHANNEL.registerMessage(id++, type, (MSG message, PacketBuffer buff) -> {
            message.encode(buff);
        }, (PacketBuffer buff) -> {
            MSG pack = createNewInstance(type);
            pack.decode(buff);
            return pack;
        }, (MSG message, Supplier<NetworkEvent.Context> ctx) -> message._handle(ctx));
    }

    private static <MSG> MSG createNewInstance(Class<MSG> type) {
        MSG pack = null;
        try {
            pack = type.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            InfCust.LOGGER.error(String.format("An error occured when attempting to decode packet of type: %1$s. Ensure that there is a parameterless constructor defined!", type.toString()), e);
        }
        return pack;
    }
}
