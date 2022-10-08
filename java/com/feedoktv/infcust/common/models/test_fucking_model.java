package com.feedoktv.infcust.common.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class test_fucking_model extends EntityModel<Entity> {
    private final ModelRenderer m;

    public test_fucking_model() {
        m = new ModelRenderer(this);
        m.texOffs(0, 0).addBox(2.5F, -17.75F, -5.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        m.texOffs(0, 0).addBox(-7.25F, -17.75F, -5.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        m.texOffs(0, 0).addBox(-7.25F, -17.75F, -7.0F, 11.0F, 1.0F, 2.0F, 0.0F, false);
        m.texOffs(0, 0).addBox(-7.25F, -16.75F, -7.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        m.setPos(2F,10.0F,0.0F);
    }

    @Override
    public void setupAnim(Entity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        m.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    }
}
