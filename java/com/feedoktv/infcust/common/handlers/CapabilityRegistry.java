package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapabilityData;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapabilityStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityRegistry {

    public static void init() {
        CapabilityManager.INSTANCE.register(HatCapabilityData.class, new HatCapabilityStorage(), HatCapabilityData::new);
    }
}
