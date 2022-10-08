package com.feedoktv.infcust.common.models;// Made with Blockbench 3.9.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class lol_glasses extends EntityModel<Entity> {

    private final ModelRenderer bone;
    public lol_glasses() {

        bone = new ModelRenderer(this);
        bone.texOffs(0, 0).addBox(2.5F, -17.75F, -5.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-7.25F, -17.75F, -5.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-7.25F, -17.75F, -7.0F, 11.0F, 1.0F, 2.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-7.25F, -16.75F, -7.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        bone.setPos(2F,10.0F,0.0F);
    }

    @Override
    public void setupAnim(Entity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        bone.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
    }
}