package com.feedoktv.infcust.common.core.capabilities;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class CapabilityUtil {

    public void updateCapabilityHatId(int id)
    {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        player.getCapability(HatCapability.PLAYER_HAT_ID).ifPresent((Data) -> Data.setValue(id));
    }

    public int getClientHatId() {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null) {
            int id = player.getCapability(HatCapability.PLAYER_HAT_ID)
                    .map(capa -> capa.getValue())
                    .orElse(0);
            return id;
        } else return -1;
    }

    public int getPlayerCapabilityId(int playerId) {
        Entity player = Minecraft.getInstance().player.level.getEntity(playerId);
        if (player != null) {
            int id = player.getCapability(HatCapability.PLAYER_HAT_ID)
                    .map(capa -> capa.getValue())
                    .orElse(0);
            return id;
        } else return -1;
    }
}
