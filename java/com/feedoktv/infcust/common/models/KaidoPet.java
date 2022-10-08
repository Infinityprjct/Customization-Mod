package com.feedoktv.infcust.common.models;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
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

import java.util.ArrayList;
import java.util.List;


public class KaidoPet extends EntityModel<Entity> {
	private int time = 0;
	private List<ModelRenderer> Flakes;
	private final ModelRenderer Kaido;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r9_r1;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer Hair;
	private final ModelRenderer hair_cube_r1;
	private final ModelRenderer hair_cube3_r1;
	private final ModelRenderer hair_cube2_r1;
	private final ModelRenderer hair_cube4_r1;
	private final ModelRenderer hair_cube5_r1;
	private final ModelRenderer hair_cube6_r1;
	private final ModelRenderer hair_cube7_r1;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer Tail;
	private final ModelRenderer Flake;
	private final ModelRenderer Flake2;
	private final ModelRenderer Flake3;
	private final ModelRenderer Flake4;
	private final ModelRenderer Flake5;
	private final ModelRenderer Flake6;
	private final ModelRenderer Flake7;
	private final ModelRenderer Flake8;
	private final ModelRenderer Flake9;
	private final ModelRenderer Flake10;

	public KaidoPet() {
		texWidth = 512;
		texHeight = 512;

		Kaido = new ModelRenderer(this);
		Kaido.setPos(90.0F, -17.0F, 69.0F);


		Head = new ModelRenderer(this);
		Head.setPos(-52.0625F, 15.3164F, -70.1738F);
		Kaido.addChild(Head);
		Head.texOffs(0, 0).addBox(-9.9375F, -16.3164F, -2.8262F, 20.0F, 23.0F, 11.0F, 0.0F, false);
		Head.texOffs(0, 131).addBox(-10.9375F, -14.3164F, -8.8262F, 7.0F, 3.0F, 6.0F, 0.0F, true);
		Head.texOffs(0, 92).addBox(-3.9375F, -15.3164F, -9.8262F, 8.0F, 9.0F, 7.0F, 0.0F, false);
		Head.texOffs(99, 97).addBox(-8.9375F, -11.3164F, -7.8262F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		Head.texOffs(51, 0).addBox(4.0625F, -11.3164F, -7.8262F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		Head.texOffs(48, 56).addBox(-7.9375F, -6.3164F, -21.8262F, 16.0F, 5.0F, 12.0F, 0.0F, false);
		Head.texOffs(35, 89).addBox(-7.9375F, -1.8164F, -21.8262F, 16.0F, 2.0F, 5.0F, 0.0F, false);
		Head.texOffs(0, 60).addBox(-7.9375F, -6.3164F, -9.8262F, 16.0F, 12.0F, 7.0F, 0.0F, false);
		Head.texOffs(88, 112).addBox(-3.9375F, 1.5753F, -21.2203F, 8.0F, 4.0F, 12.0F, 0.0F, false);
		Head.texOffs(80, 118).addBox(-2.9375F, 1.5753F, -27.2203F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		Head.texOffs(85, 119).addBox(-1.9375F, 2.5753F, -33.2203F, 4.0F, 3.0F, 6.0F, 0.0F, false);
		Head.texOffs(62, 0).addBox(-6.9375F, 4.5753F, -36.2203F, 14.0F, 4.0F, 10.0F, 0.0F, false);
		Head.texOffs(95, 89).addBox(-3.9375F, -7.1747F, -39.4703F, 8.0F, 3.0F, 5.0F, 0.0F, false);
		Head.texOffs(62, 28).addBox(-6.9375F, -6.4247F, -38.7203F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		Head.texOffs(39, 60).addBox(4.0625F, -6.4247F, -38.7203F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-6.9375F, 2.7398F, -28.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(6.0625F, 2.7398F, -28.3756F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-6.9375F, 2.7398F, -30.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(6.0625F, 2.7398F, -30.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-6.9375F, 2.7398F, -32.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(6.0625F, 2.7398F, -32.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-6.9375F, 2.7398F, -34.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-6.9375F, 0.7398F, -36.1256F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-4.9375F, 2.7398F, -36.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-2.9375F, 2.7398F, -36.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(-0.9375F, 2.7398F, -36.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(1.0625F, 2.7398F, -36.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(3.5625F, 2.7398F, -36.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(6.0625F, 0.7398F, -36.1256F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Head.texOffs(62, 123).addBox(6.0625F, 2.7398F, -34.1256F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Head.texOffs(0, 131).addBox(4.0625F, -14.3164F, -8.8262F, 7.0F, 3.0F, 6.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0625F, 8.973F, -26.683F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.0873F, 0.0F, 0.0F);
		Head_r1.texOffs(38, 34).addBox(-4.0F, -2.0F, -9.5F, 8.0F, 3.0F, 19.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-6.4375F, 0.63F, -11.3588F);
		Head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.2333F, 0.1198F, -0.4659F);
		cube_r1.texOffs(62, 123).addBox(-1.25F, -4.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0625F, 4.6277F, -14.6875F);
		Head.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.2618F, 0.0F, 0.0F);
		cube_r2.texOffs(62, 123).addBox(-7.0F, -5.5F, 1.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(62, 126).addBox(6.0F, -5.5F, 1.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(62, 123).addBox(-7.0F, -5.5F, -3.25F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(62, 123).addBox(6.0F, -5.5F, -3.25F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(62, 14).addBox(-7.0F, -1.5F, -4.25F, 14.0F, 4.0F, 10.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(6.5625F, 0.8934F, -16.2057F);
		Head.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.2382F, -0.1096F, 0.4232F);
		cube_r3.texOffs(62, 123).addBox(0.75F, -2.75F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(7.7552F, -0.587F, -11.6848F);
		Head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.2427F, -0.0992F, 0.3806F);
		cube_r4.texOffs(62, 123).addBox(-0.25F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-6.4375F, 1.7946F, -15.7054F);
		Head.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.2467F, -0.0886F, 2.8035F);
		cube_r5.texOffs(62, 123).addBox(0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r5.texOffs(62, 126).addBox(0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0625F, -4.4952F, -22.4929F);
		Head.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.0F);
		cube_r6.texOffs(73, 41).addBox(-6.0F, -1.75F, -5.0F, 12.0F, 4.0F, 7.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0625F, 7.5048F, -23.4929F);
		Head.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0873F, 0.0F, 0.0F);
		cube_r7.texOffs(36, 73).addBox(-5.0F, -3.0F, -4.0F, 10.0F, 4.0F, 10.0F, 0.0F, false);
		cube_r7.texOffs(62, 123).addBox(4.0F, -6.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r7.texOffs(62, 123).addBox(-5.0F, -6.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r7.texOffs(62, 123).addBox(4.0F, -5.85F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r7.texOffs(62, 123).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r7.texOffs(62, 123).addBox(4.0F, -7.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r7.texOffs(62, 123).addBox(-5.0F, -7.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-4.4375F, 3.2398F, -26.3756F);
		Head.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.0436F, 0.0F, 0.0F);
		cube_r8.texOffs(62, 123).addBox(8.5F, -1.5F, -0.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r8.texOffs(62, 123).addBox(-0.5F, -1.5F, -0.75F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0625F, -3.6747F, -31.2203F);
		Head.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.1309F, 0.0F, 0.0F);
		cube_r9.texOffs(73, 28).addBox(-7.0F, -2.5F, -5.75F, 14.0F, 3.0F, 10.0F, 0.0F, false);

		cube_r9_r1 = new ModelRenderer(this);
		cube_r9_r1.setPos(0.0F, 1.5F, -3.75F);
		cube_r9.addChild(cube_r9_r1);
		setRotationAngle(cube_r9_r1, 0.1309F, 0.0F, 0.0F);
		cube_r9_r1.texOffs(92, 128).addBox(-6.0F, -2.0F, -1.8059F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.5625F, -7.1121F, -30.5156F);
		Head.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.1309F, 0.0F, 0.0F);
		cube_r10.texOffs(68, 89).addBox(-5.0F, 0.0F, -4.0F, 9.0F, 2.0F, 9.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.5625F, -7.8164F, -13.8262F);
		Head.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.1309F, 0.0F, 0.0F);
		cube_r11.texOffs(0, 79).addBox(-5.0F, 0.5F, -7.0F, 9.0F, 2.0F, 11.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0625F, 7.4925F, -6.9F);
		Head.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1745F, 0.0F, 0.0F);
		cube_r14.texOffs(0, 34).addBox(-4.0F, -2.5F, -11.0F, 8.0F, 4.0F, 22.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(-5.4375F, -17.3164F, 6.6738F);
		Head.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.48F, 0.0F, 0.0F);
		cube_r15.texOffs(50, 96).addBox(10.5F, -19.0F, 0.0F, 3.0F, 20.0F, 3.0F, 0.0F, false);
		cube_r15.texOffs(38, 49).addBox(13.5F, -16.0F, 0.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r15.texOffs(49, 60).addBox(-5.5F, -16.0F, 0.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r15.texOffs(50, 96).addBox(-2.5F, -19.0F, 0.0F, 3.0F, 20.0F, 3.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(7.9582F, -35.872F, 18.0243F);
		Head.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.4737F, -0.0803F, -0.1551F);
		cube_r16.texOffs(74, 100).addBox(-3.5F, -9.0F, -1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(4.6505F, -42.3445F, 21.3937F);
		Head.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.4483F, -0.1776F, -0.3521F);
		cube_r17.texOffs(111, 40).addBox(-1.25F, -6.75F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(-4.0201F, -45.8517F, 23.2194F);
		Head.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.4549F, 0.1586F, 0.3123F);
		cube_r18.texOffs(111, 41).addBox(-1.0F, -2.25F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(-4.8443F, -37.8743F, 19.0667F);
		Head.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.4737F, 0.0803F, 0.1551F);
		cube_r19.texOffs(74, 100).addBox(-2.25F, -6.0F, -1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(14.553F, -32.3853F, 16.2092F);
		Head.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.1122F, -0.4677F, -1.8157F);
		cube_r20.texOffs(0, 53).addBox(-2.25F, -2.25F, -0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(-11.8477F, -31.1103F, 15.5455F);
		Head.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.1339F, -0.4623F, -1.2774F);
		cube_r21.texOffs(0, 51).addBox(-1.5F, -1.75F, -0.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(11.5913F, -29.2053F, 14.5538F);
		Head.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.4659F, -0.1198F, -0.2333F);
		cube_r22.texOffs(47, 34).addBox(-0.5F, -1.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(-15.9375F, -29.9289F, 14.9305F);
		Head.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.4608F, 0.1393F, 0.2727F);
		cube_r23.texOffs(46, 49).addBox(2.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(25.1998F, -47.2975F, -0.4706F);
		Head.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.4391F, -0.3715F, 2.316F);
		cube_r24.texOffs(14, 34).addBox(1.25F, -4.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(33.4241F, -32.46F, -6.5139F);
		Head.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.263F, -0.5086F, 2.7238F);
		cube_r25.texOffs(62, 14).addBox(3.25F, 5.5F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		cube_r25.texOffs(0, 108).addBox(2.75F, -5.5F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(32.6939F, -19.8095F, -6.7529F);
		Head.addChild(cube_r26);
		setRotationAngle(cube_r26, -0.2145F, -0.5293F, -2.6469F);
		cube_r26.texOffs(110, 107).addBox(3.25F, -4.75F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(21.415F, -14.746F, 3.3847F);
		Head.addChild(cube_r27);
		setRotationAngle(cube_r27, -0.532F, -0.2071F, -1.8196F);
		cube_r27.texOffs(110, 0).addBox(-1.5F, -0.75F, -4.25F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(-22.3077F, -42.3507F, -3.1527F);
		Head.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.1582F, -0.4084F, 0.7309F);
		cube_r28.texOffs(14, 34).addBox(0.0F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(-33.5356F, -29.6884F, -6.0532F);
		Head.addChild(cube_r29);
		setRotationAngle(cube_r29, -0.0608F, -0.4323F, 0.4933F);
		cube_r29.texOffs(62, 14).addBox(3.75F, -14.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		cube_r29.texOffs(0, 108).addBox(3.25F, -6.0F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(-33.5686F, -17.6221F, -3.8674F);
		Head.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.3052F, -0.3169F, -0.4418F);
		cube_r30.texOffs(12, 108).addBox(2.75F, -6.0F, -1.75F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(-26.2051F, -12.6669F, 2.6738F);
		Head.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.4331F, -0.0552F, -1.2775F);
		cube_r31.texOffs(110, 107).addBox(0.75F, -5.0F, -4.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(14.7559F, -14.4553F, 2.6738F);
		Head.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.0873F, 0.0F, -1.6144F);
		cube_r32.texOffs(110, 14).addBox(-1.5F, -5.5F, -2.5F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(-11.4375F, -18.3164F, -1.3262F);
		Head.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -1.6144F);
		cube_r33.texOffs(24, 113).addBox(-6.5F, -9.5F, 2.5F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(-10.9375F, 0.6836F, 0.1738F);
		Head.addChild(cube_r34);
		setRotationAngle(cube_r34, -0.2182F, 0.0F, 0.0F);
		cube_r34.texOffs(0, 34).addBox(19.0F, -6.5F, -4.25F, 4.0F, 11.0F, 6.0F, 0.0F, false);
		cube_r34.texOffs(0, 34).addBox(-1.0F, -6.5F, -4.25F, 4.0F, 11.0F, 6.0F, 0.0F, true);

		Hair = new ModelRenderer(this);
		Hair.setPos(-3.9375F, 25.6836F, 1.1738F);
		Head.addChild(Hair);


		hair_cube_r1 = new ModelRenderer(this);
		hair_cube_r1.setPos(4.0F, -28.8583F, -40.1441F);
		Hair.addChild(hair_cube_r1);
		setRotationAngle(hair_cube_r1, 0.2182F, 0.0F, 0.0F);
		hair_cube_r1.texOffs(117, 68).addBox(-6.0F, 0.0F, -0.5F, 12.0F, 0.0F, 4.0F, 0.0F, false);

		hair_cube3_r1 = new ModelRenderer(this);
		hair_cube3_r1.setPos(-4.6518F, -19.9767F, -30.7488F);
		Hair.addChild(hair_cube3_r1);
		setRotationAngle(hair_cube3_r1, 0.0038F, -0.0873F, -3.0985F);
		hair_cube3_r1.texOffs(107, 0).addBox(-3.25F, 0.25F, -6.25F, 6.0F, 0.0F, 15.0F, 0.0F, false);

		hair_cube2_r1 = new ModelRenderer(this);
		hair_cube2_r1.setPos(3.9165F, -19.9767F, -39.7177F);
		Hair.addChild(hair_cube2_r1);
		setRotationAngle(hair_cube2_r1, 1.5708F, 1.3526F, 1.5708F);
		hair_cube2_r1.texOffs(115, 47).addBox(-2.5F, 0.25F, -7.0F, 6.0F, 0.0F, 14.0F, 0.0F, false);

		hair_cube4_r1 = new ModelRenderer(this);
		hair_cube4_r1.setPos(3.9165F, -15.8274F, -38.7978F);
		Hair.addChild(hair_cube4_r1);
		setRotationAngle(hair_cube4_r1, 0.0F, 1.5708F, 0.0F);
		hair_cube4_r1.texOffs(132, 53).addBox(-3.0F, -0.5F, -5.0F, 6.0F, 0.0F, 10.0F, 0.0F, false);

		hair_cube5_r1 = new ModelRenderer(this);
		hair_cube5_r1.setPos(11.0289F, -17.9767F, -32.1374F);
		Hair.addChild(hair_cube5_r1);
		setRotationAngle(hair_cube5_r1, 0.0F, -0.0873F, 0.0F);
		hair_cube5_r1.texOffs(107, 0).addBox(-1.5F, -2.0F, -5.75F, 6.0F, 0.0F, 15.0F, 0.0F, false);

		hair_cube6_r1 = new ModelRenderer(this);
		hair_cube6_r1.setPos(-4.3872F, -21.1587F, -17.7841F);
		Hair.addChild(hair_cube6_r1);
		setRotationAngle(hair_cube6_r1, -0.1753F, 0.0852F, 3.1227F);
		hair_cube6_r1.texOffs(107, 0).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 0.0F, 15.0F, 0.0F, false);

		hair_cube7_r1 = new ModelRenderer(this);
		hair_cube7_r1.setPos(12.0F, -21.0F, -18.5F);
		Hair.addChild(hair_cube7_r1);
		setRotationAngle(hair_cube7_r1, 0.1753F, 0.0852F, 0.0189F);
		hair_cube7_r1.texOffs(107, 0).addBox(-2.75F, 0.0F, -7.5F, 6.0F, 0.0F, 15.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(13.6365F, -38.5F, -10.4789F);
		Hair.addChild(cube_r12);
		setRotationAngle(cube_r12, 3.0724F, 0.2527F, 2.871F);
		cube_r12.texOffs(0, 125).addBox(-5.5F, -1.5F, 0.0F, 11.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(-6.0F, -38.5F, -10.0F);
		Hair.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0666F, 0.2079F, 0.3124F);
		cube_r13.texOffs(0, 125).addBox(-5.0F, -1.5F, -0.25F, 11.0F, 3.0F, 0.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setPos(-56.0F, 41.0F, -69.0F);
		Kaido.addChild(Tail);


		Flake = new ModelRenderer(this);
		Flake.setPos(0.0F, 0.0F, 0.0F);
		Tail.addChild(Flake);
		Flake.texOffs(0, 0).addBox(-4.0F, -39.0F, 7.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);

		Flake2 = new ModelRenderer(this);
		Flake2.setPos(0.0F, 0.0F, 15.0F);
		Tail.addChild(Flake2);
		Flake2.texOffs(0, 0).addBox(-4.0F, -39.0F, 7.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);

		Flake3 = new ModelRenderer(this);
		Flake3.setPos(0.0F, 0.0F, 30.0F);
		Tail.addChild(Flake3);
		Flake3.texOffs(0, 0).addBox(-4.0F, -39.0F, 7.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);

		Flake4 = new ModelRenderer(this);
		Flake4.setPos(0.0F, 0.0F, 45.0F);
		Tail.addChild(Flake4);
		Flake4.texOffs(0, 0).addBox(-4.0F, -39.0F, 7.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);

		Flake5 = new ModelRenderer(this);
		Flake5.setPos(0.0F, 0.0F, 60.0F);
		Tail.addChild(Flake5);
		Flake5.texOffs(0, 0).addBox(-4.0F, -39.0F, 7.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);

		Flake6 = new ModelRenderer(this);
		Flake6.setPos(0.0F, 0.0F, 75.0F);
		Tail.addChild(Flake6);
		Flake6.texOffs(0, 0).addBox(-4.0F, -39.0F, 7.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);

		Flake7 = new ModelRenderer(this);
		Flake7.setPos(0.0F, 0.0F, 90.0F);
		Tail.addChild(Flake7);
		Flake7.texOffs(0, 0).addBox(-3.0F, -38.0F, 7.0F, 14.0F, 15.0F, 15.0F, 0.0F, false);

		Flake8 = new ModelRenderer(this);
		Flake8.setPos(0.0F, 0.0F, 105.0F);
		Tail.addChild(Flake8);
		Flake8.texOffs(0, 0).addBox(-3.0F, -38.0F, 7.0F, 14.0F, 15.0F, 15.0F, 0.0F, false);

		Flake9 = new ModelRenderer(this);
		Flake9.setPos(0.0F, 0.0F, 120.0F);
		Tail.addChild(Flake9);
		Flake9.texOffs(0, 0).addBox(-3.0F, -38.0F, 7.0F, 14.0F, 15.0F, 15.0F, 0.0F, false);

		Flake10 = new ModelRenderer(this);
		Flake10.setPos(0.0F, 0.0F, 135.0F);
		Tail.addChild(Flake10);
		Flake10.texOffs(0, 0).addBox(-3.0F, -38.0F, 7.0F, 14.0F, 15.0F, 15.0F, 0.0F, false);
		Flakes = new ArrayList<>();
		Flakes.add(Flake);
		Flakes.add(Flake2);
		Flakes.add(Flake3);
		Flakes.add(Flake4);
		Flakes.add(Flake5);
		Flakes.add(Flake6);
		Flakes.add(Flake7);
		Flakes.add(Flake8);
		Flakes.add(Flake9);
		Flakes.add(Flake10);

	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		Head.xRot = (float) (0.2F * Math.sin(ageInTicks/20));

		for (int i=0;i<Flakes.size()-1;i++)
		{
			Flakes.get(i).xRot = (float) (0.2F * Math.sin(ageInTicks/20 - i*0.5));;
			Flakes.get(i).z = (float) (i*15 + Math.sin(ageInTicks/20 - i));

		}

		Kaido.yRot -= 0.5/20;

		this.time += 1;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.renderType(new ResourceLocation("infcust:textures/item/kaido.png"));

		Kaido.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}