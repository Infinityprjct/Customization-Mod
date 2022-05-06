package com.feedoktv.infcust;

import com.feedoktv.infcust.client.handlers.EventHandlerClient;
import com.feedoktv.infcust.common.core.capabilities.CapabilityUtil;
import com.feedoktv.infcust.common.core.networking.PacketDispatcher;
import com.feedoktv.infcust.common.handlers.CapabilityRegistry;
import com.feedoktv.infcust.common.handlers.EventHandlerServer;
import com.feedoktv.infcust.common.handlers.ItemsHandler;
import com.feedoktv.infcust.common.handlers.NetworkHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

@Mod(InfCust.MOD_ID)
public class InfCust {

    public static final String MOD_ID = "infcust";

    public static final Logger LOGGER = LogManager.getLogger();

    public static EventHandlerClient eventHandlerClient;
    public static EventHandlerServer eventHandlerServer;
    public static ItemsHandler itemsHandler;
    public static CapabilityUtil capabilityUtil;



    public static KeyBinding keyBinding;

    public InfCust() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::finishLoading);

        MinecraftForge.EVENT_BUS.register(eventHandlerServer = new EventHandlerServer());

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {

            eventBus.addListener(this::doClientStuff);

            itemsHandler.register(eventBus);
            MinecraftForge.EVENT_BUS.register(eventHandlerClient = new EventHandlerClient());

            itemsHandler = new ItemsHandler();

        });



        LOGGER.info("Infinity Customization class initialized");
    }

    private void setup(final FMLCommonSetupEvent event) {
        PacketDispatcher.register();
        CapabilityRegistry.init();
        capabilityUtil = new CapabilityUtil();

        LOGGER.info("[INFCUST] SETUP EVENT INIT");

    }

    @OnlyIn(Dist.CLIENT)
    private void doClientStuff(final FMLClientSetupEvent event) {
        itemsHandler.initItems();
        eventHandlerClient.initLayers();
        NetworkHandler.init();

        keyBinding = new KeyBinding("infcust.gui", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.categories.infcust");
        ClientRegistry.registerKeyBinding(keyBinding);
        LOGGER.info("[INFCUST] SETUP EVENT INIT");
    }

    private void finishLoading(FMLLoadCompleteEvent event) {
        LOGGER.info("[INFCUST] COMPLETE EVENT INIT");

    }

}
