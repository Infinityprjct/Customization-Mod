package com.feedoktv.infcust.client.handlers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.client.gui.CustomizationScreen;
import com.feedoktv.infcust.client.layers.ItemsLayer;
import com.feedoktv.infcust.common.core.networking.PacketDispatcher;
import com.feedoktv.infcust.common.core.networking.packets.CapabilityUpdateServerPacket;
import com.feedoktv.infcust.common.core.networking.packets.MainMenuOpenedPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Map;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class EventHandlerClient {
    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent e) {
        if(InfCust.keyBinding.isDown()) {
            PacketDispatcher.sendToServer(new MainMenuOpenedPacket("infcust.gui"));
            PacketDispatcher.sendToServer(new CapabilityUpdateServerPacket(0, Minecraft.getInstance().player.getId()));
            //Minecraft.getInstance().setScreen(new CustomizationScreen());
            //int id = InfCust.capabilityUtil.getCapabilityHatId();
            //InfCust.LOGGER.error("capa " + id);
        }
    }

    public void initLayers() {
    //    PlayerRenderer rend = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().get("default");
    //    //rend.addLayer(new ItemsLayer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>(rend));

//        ItemsLayer layer = new ItemsLayer(rend);
//
//        HashSet<LivingRenderer> addedRenderers = new HashSet<>();
//
//        EntityRendererManager renderManager = Minecraft.getInstance().getEntityRenderDispatcher();
//        Map<String, PlayerRenderer> skinMap = renderManager.getSkinMap();
//        for(Map.Entry<String, PlayerRenderer> e : skinMap.entrySet())
//        {
//            e.getValue().addLayer(layer);
//            addedRenderers.add(e.getValue());
//        }
//        renderManager.renderers.forEach((entityType, entityRenderer) -> {
//            if (addedRenderers.contains(entityRenderer)) {
//                return;
//            }
//        });

        //Add our sneaky sneaky layers
        PlayerRenderer rend = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().get("default");
        ItemsLayer layerHat = new ItemsLayer(rend);

        HashSet<LivingRenderer> addedRenderers = new HashSet<>();

        EntityRendererManager renderManager = Minecraft.getInstance().getEntityRenderDispatcher();
        Map<String, PlayerRenderer> skinMap = renderManager.getSkinMap();
        for(Map.Entry<String, PlayerRenderer> e : skinMap.entrySet())
        {
            e.getValue().addLayer(layerHat);
            addedRenderers.add(e.getValue());
        }
        renderManager.renderers.forEach((entityType, entityRenderer) -> {
            if (addedRenderers.contains(entityRenderer)) {
                return;
            }

            if (entityRenderer instanceof PlayerRenderer) {
                LivingRenderer renderer = (LivingRenderer) entityRenderer;
                renderer.addLayer(layerHat);
            }

        });
    }

    public void OpenCustMenu() {
        Minecraft.getInstance().setScreen(new CustomizationScreen());

    }

}
