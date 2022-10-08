package com.feedoktv.infcust.client.layers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.common.handlers.ItemRegistry;
import com.feedoktv.infcust.common.items.CustItem;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.SkullTileEntityRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.SkullTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.UUID;

public class ItemsLayer <T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    private static final ResourceLocation WINGS_LOCATION = new ResourceLocation("infcust:textures/models/armor/test_hatmodel.png");

    public ItemsLayer(IEntityRenderer<T, M> rendererIn) {
        super(rendererIn);
        //super((IEntityRenderer<T, M>)Minecraft.getInstance().getEntityRenderDispatcher().);

        InfCust.LOGGER.error("[INFCUST] ITEMSLAYER READY");

    }



    @Override
    public void render(MatrixStack mstack, IRenderTypeBuffer p_225628_2_, int packedLightIn, T living, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {

        //InfCust.LOGGER.error("[INFCUST] ITEMSLAYER RENDER");

        int itemId = InfCust.capabilityUtil.getPlayerCapabilityId(living.getId());
        CustItem item = null;
        if (itemId != -1) {
            item = InfCust.itemsHandler.getItemByIndex(itemId);
        }

        //InfCust.LOGGER.error(p_225628_4_.getEntity().getName().getString());
        //InfCust.LOGGER.error(itemId);
        //InfCust.LOGGER.error(headYaw);

        ItemStack itemstack = living.getItemBySlot(EquipmentSlotType.HEAD);

        float f = MathHelper.lerp(partialTicks, living.yHeadRotO, living.yHeadRot) - MathHelper.lerp(partialTicks, living.yBodyRotO, living.yBodyRot);
        float f1 = MathHelper.lerp(partialTicks, living.xRotO, living.xRot);

        mstack.pushPose();
        mstack.mulPose(Vector3f.YP.rotationDegrees(f));
        mstack.mulPose(Vector3f.XP.rotationDegrees(f1));
        mstack.translate(2D, 0.0D, 0.0D);
        mstack.scale(0.2F, 0.2F, 0.2F);
        //mstack.scale(0.900F, 0.900F, 0.900F);
        //mstack.scale(0.625F, -0.625F, -0.625F);
        //mstack.scale(0.625F, -0.625F, -0.625F);

        //this.getParentModel().copyPropertiesTo(this.elytraModel);
        //this.elytraModel.setupAnim(p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_);
        if(item != null) {
            IVertexBuilder ivertexbuilder = ItemRenderer.getArmorFoilBuffer(p_225628_2_, RenderType.armorCutoutNoCull(item.getModelTexture()), false, itemstack.hasFoil());
            //item.getModel().renderToBuffer(mstack, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            IVertexBuilder vertexBuilder = p_225628_2_.getBuffer(item.getEntityModel().renderType(new ResourceLocation("infcust:textures/item/kaido.png")));
            item.getEntityModel().renderToBuffer(mstack, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            item.getEntityModel().setupAnim(living, limbSwing,limbSwingAmount,ageInTicks,partialTicks,headYaw);

            //hh.renderToBuffer(mstack, ivertexbuilder, p_225628_3_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }


        /*

        float f3 = 1.1875F;

        ItemRegistry.test_hatitem.get().getArmorModel().
        Minecraft.getInstance().getItemRenderer().renderStatic(ItemRegistry.test_hatitem.get().getContainerItem(itemstack), ItemCameraTransforms.TransformType.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY, mstack, p_225628_2_);
        */
        mstack.mulPose(Vector3f.XP.rotationDegrees(-f1));
        mstack.mulPose(Vector3f.YP.rotationDegrees(-f));

        mstack.popPose();



    }



}