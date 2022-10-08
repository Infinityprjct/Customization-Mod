package com.feedoktv.infcust.common.models;// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.feedoktv.infcust.InfCust;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;

public class Shapka extends EntityModel<Entity> {
	private final ModelRenderer Shapka;
	private OBJModel model;

	public Shapka() {

		Shapka = new ModelRenderer(this);
		Shapka.texOffs(0, 0).addBox(-4.0F, -33.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		Shapka.texOffs(0, 0).addBox(4.0F, -33.0F, -4.0F, 1.0F, 9.0F, 8.0F, 0.0F, false);
		Shapka.texOffs(0, 0).addBox(-5.0F, -33.0F, -4.0F, 1.0F, 9.0F, 8.0F, 0.0F, false);
		Shapka.setPos(0.0F,24.0F,0.0F);

		model = OBJLoader.INSTANCE.loadModel(new OBJModel.ModelSettings(new ResourceLocation("infcust","models/3d/kaidogeneric.obj"),true,true,true,true,null));

	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Shapka.yRot += 25F;
	}


	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Shapka.render(matrixStack, buffer, packedLight, packedOverlay);
		model = OBJLoader.INSTANCE.loadModel(new OBJModel.ModelSettings(new ResourceLocation("infcust","models/3d/kaidogeneric.obj"),true,true,true,true,null));
		model.getParts();
	}

}