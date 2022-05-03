package com.feedoktv.infcust.common.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class test_armorhatmodel extends ItemBaseModel{
    public test_armorhatmodel() {
        super(32, 32, new ResourceLocation("infcust:textures/item/test_hatmodel.png"));
    }

    @Override
    public void setupArmorParts() {

        armorHead.setPos(0.0F,7.0F,0.0F);

        armorHead.texOffs(0,2).addBox(-5.0F, -2.0F, -6.0F, 11.0F, 1.0F, 13.0F, 0.0F, false);
        armorHead.addBox(-3.0F, -17.0F, -4.0F, 7.0F, 15.0F, 9.0F, 0.0F, false);
        armorHead.setTexSize(32,32);
        armorHead.setPos(0.0F,-16.0F,0.0F);

    }

    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(armorHead);
    }
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of();
    }
}
