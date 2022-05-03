package com.feedoktv.infcust.common.core.capabilities.hatsCapability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class HatCapabilityStorage implements Capability.IStorage<HatCapabilityData>{
    @Nullable
    @Override
    public INBT writeNBT(Capability<HatCapabilityData> capability, HatCapabilityData instance, Direction side) {
        CompoundNBT compound = new CompoundNBT();
        compound.putInt("hat_id", instance.getValue());
        return compound;
    }

    @Override
    public void readNBT(Capability<HatCapabilityData> capability, HatCapabilityData instance, Direction side, INBT nbt) {
        instance.setValue(((CompoundNBT) nbt).getInt("hat_id"));
    }
}
