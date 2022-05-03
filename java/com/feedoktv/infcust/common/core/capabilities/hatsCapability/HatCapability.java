package com.feedoktv.infcust.common.core.capabilities.hatsCapability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class HatCapability {
    @CapabilityInject(HatCapabilityData.class)
    public static Capability<HatCapabilityData> PLAYER_HAT_ID;
}
