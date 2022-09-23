package com.feedoktv.infcust.common.core.capabilities.hatsCapability;

import com.feedoktv.infcust.common.core.capabilities.ICustCapability;

public class HatCapabilityData implements ICustCapability {

    private int hatId = -1;

    @Override
    public int getValue() {
        return this.hatId;
    }

    @Override
    public void setValue(int value) {
        this.hatId = value;
        synchronise();
    }

    public void synchronise()
    {

    }
}
