package com.feedoktv.infcust.common.core.capabilities.hatsCapability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability.PLAYER_HAT_ID;

public class HatCapabilityProvider implements ICapabilitySerializable<INBT> {

    private final HatCapabilityData playerHatCapability = new HatCapabilityData();
    private final Capability.IStorage<HatCapabilityData> hatCapabilityStorage = PLAYER_HAT_ID.getStorage();

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap.equals(PLAYER_HAT_ID)) return LazyOptional.of(() -> playerHatCapability).cast();
        else return LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return hatCapabilityStorage.writeNBT(PLAYER_HAT_ID, playerHatCapability, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        hatCapabilityStorage.readNBT(PLAYER_HAT_ID, playerHatCapability, null, nbt);
    }
}
