package com.feedoktv.infcust.client.layers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.items.CustItem;
import com.feedoktv.infcust.common.models.test_armorhatmodel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class ItemsLayer <T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    private final ElytraModel<T> elytraModel = new ElytraModel<>();
    private static final ResourceLocation WINGS_LOCATION = new ResourceLocation("infcust:textures/models/armor/test_hatmodel.png");

    //test_armorhatmodel hh = new test_armorhatmodel();

    public ItemsLayer(IEntityRenderer<T, M> rendererIn) {
        super(rendererIn);
        //super((IEntityRenderer<T, M>)Minecraft.getInstance().getEntityRenderDispatcher().);

        InfCust.LOGGER.error("[INFCUST] ITEMSLAYER READY");


    }


    @Override
    public void render(MatrixStack mstack, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {

        //InfCust.LOGGER.error("[INFCUST] ITEMSLAYER RENDER");


        int itemId = InfCust.capabilityUtil.getCapabilityHatId();
        CustItem item = null;
        if (itemId != -1) {
            item = InfCust.itemsHandler.getItemByIndex(itemId);
        }


        ItemStack itemstack = p_225628_4_.getItemBySlot(EquipmentSlotType.HEAD);

        float f = MathHelper.lerp(p_225628_7_, p_225628_4_.yRotO, p_225628_4_.yRot) - MathHelper.lerp(p_225628_7_, p_225628_4_.yBodyRotO, p_225628_4_.yBodyRot);
        float f1 = MathHelper.lerp(p_225628_7_, p_225628_4_.xRotO, p_225628_4_.xRot);

        mstack.pushPose();

        mstack.mulPose(Vector3f.YP.rotationDegrees(f));
        mstack.mulPose(Vector3f.XP.rotationDegrees(f1));
        mstack.translate(0.0D, 0.5D, 0.0D);
        mstack.scale(1F, 1F, 1F);
        //this.getParentModel().copyPropertiesTo(this.elytraModel);
        //this.elytraModel.setupAnim(p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_);
        if(item != null) {
            IVertexBuilder ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_225628_2_, RenderType.armorCutoutNoCull(item.getModelTexture()), false, itemstack.hasFoil());
            item.getModel().renderToBuffer(mstack, ivertexbuilder, p_225628_3_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            //hh.renderToBuffer(mstack, ivertexbuilder, p_225628_3_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        mstack.mulPose(Vector3f.XP.rotationDegrees(-f1));
        mstack.mulPose(Vector3f.YP.rotationDegrees(-f));

        mstack.popPose();


    }
}