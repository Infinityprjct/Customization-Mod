package com.feedoktv.infcust.common.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

public abstract class ItemBaseModel extends BipedModel<LivingEntity> {
    protected final ModelRenderer headModel;
    protected final ModelRenderer armorBody;
    protected final ModelRenderer armorRightArm;
    protected final ModelRenderer armorLeftArm;
    protected final ModelRenderer armorRightLeg;
    protected final ModelRenderer armorLeftLeg;
    protected final ModelRenderer armorRightBoot;
    protected final ModelRenderer armorLeftBoot;

    private String texture;

    public ItemBaseModel(int textureWidth, int textureHeight, ResourceLocation texture){
        super(1F);
        this.texWidth = textureWidth;
        this.texHeight = textureHeight;
        this.texture = texture.toString();

        headModel = new ModelRenderer(this);
        headModel.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(0,0);
        head.addChild(headModel);

        armorBody = new ModelRenderer(this);
        armorBody.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(armorBody);

        armorRightArm = new ModelRenderer(this);
        armorRightArm.setPos(0.0F, 0.0F, 0.0F);
        rightArm.addChild(armorRightArm);

        armorLeftArm = new ModelRenderer(this);
        armorLeftArm.setPos(0.0F, 0.0F, 0.0F);
        leftArm.addChild(armorLeftArm);

        armorRightLeg = new ModelRenderer(this);
        armorRightLeg.setPos(0.0F, 0.0F, 0.0F);
        armorRightLeg.addChild(armorRightLeg);

        armorLeftLeg = new ModelRenderer(this);
        armorLeftLeg.setPos(0.0F, 0.0F, 0.0F);
        armorLeftLeg.addChild(armorLeftLeg);


        armorRightBoot = new ModelRenderer(this);
        armorRightBoot.setPos(0.0F, 0.0F, 0.0F);
        rightLeg.addChild(armorRightBoot);

        armorLeftBoot = new ModelRenderer(this);
        armorLeftBoot.setPos(0.0F, 0.0F, 0.0F);
        leftLeg.addChild(armorLeftBoot);

        setupArmorParts();
    }

    public abstract void setupArmorParts();

    public final String getTexture(){
        return this.texture;
    }

    public BipedModel applySlot(EquipmentSlotType slot){
        headModel.visible = false;
        armorBody.visible = false;
        armorRightArm.visible = false;
        armorLeftArm.visible = false;
        armorRightLeg.visible = false;
        armorLeftLeg.visible = false;
        armorRightBoot.visible = false;
        armorLeftBoot.visible = false;

        switch(slot){
            case HEAD:
                headModel.visible = false;

                break;
            case CHEST:
                armorBody.visible = true;
                armorRightArm.visible = true;
                armorLeftArm.visible = true;
                break;
            case LEGS:
                armorRightLeg.visible = true;
                armorLeftLeg.visible = true;
                break;
            case FEET:
                armorRightBoot.visible = true;
                armorLeftBoot.visible = true;
                break;
            default:
                break;
        }

        return this;
    }

    public final ItemBaseModel applyEntityStats(BipedModel defaultArmor){
        this.rightArmPose = defaultArmor.rightArmPose;
        this.leftArmPose = defaultArmor.leftArmPose;

        return this;
    }

    public final void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    private final void copyModelAngles(ModelRenderer in, ModelRenderer out){
        out.xRot = in.xRot;
        out.yRot = in.yRot;
        out.zRot = in.zRot;
    }

}
