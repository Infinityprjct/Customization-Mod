package com.feedoktv.infcust.common.core.capabilities;

import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;

public class CapabilityUtil {

    public void updateCapabilityHatId(int id)
    {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        player.getCapability(HatCapability.PLAYER_HAT_ID).ifPresent((Data) -> Data.setValue(id));
    }

    public int getCapabilityHatId()
    {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        int id = player.getCapability(HatCapability.PLAYER_HAT_ID)
                .map(capa -> capa.getValue())
                .orElse(0);
        return id;
    }
}
