package com.feedoktv.infcust.common.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class test_glasses extends ItemBaseModel{
    public test_glasses() {
        super(16, 16, new ResourceLocation("infcust:textures/item/test_glasses.png"));
    }

    @Override
    public void setupArmorParts() {



        headModel.addBox(-14.5F, -13.0F, 0.5F, 5.0F, 3.0F, 1.0F)
                .texOffs(0, 13).addBox(-6.5F, -13.0F, 0.5F, 5.0F, 3.0F, 1.0F)
                .texOffs(10, 4).addBox(-9.5F, -13.0F, 0.5F, 3.0F, 0.0F, 1.0F)
                .texOffs(5, 13).addBox(-1.5F, -13.0F, 0.5F, 1.0F, 1.0F, 10.0F)
                .texOffs(5, 13).addBox(-15.5F, -13.0F, 0.5F, 1.0F, 1.0F, 10.0F)
                .texOffs(15, 6).addBox(-1.5F, -12.0F, 11.0F, 1.0F, 1.0F, 1.0F)
                .texOffs(15, 6).addBox(-15.5F, -12.0F, 11.0F, 1.0F, 1.0F, 1.0F);

        headModel.setPos(0.0F,0.0F,4.0F);

    }

    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(headModel);
    }
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of();
    }
}
