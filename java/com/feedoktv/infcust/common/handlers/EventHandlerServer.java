package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapabilityProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandlerServer {
    @SubscribeEvent
    public static void AddCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(new ResourceLocation(InfCust.MOD_ID, ("hatcap")), new HatCapabilityProvider());
            InfCust.LOGGER.error("attached");
        }
    }
}
