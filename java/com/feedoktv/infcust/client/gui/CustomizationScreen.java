package com.feedoktv.infcust.client.gui;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.client.gui.Widgets.CustButton;
import com.feedoktv.infcust.client.gui.Widgets.ItemWidget;
import com.feedoktv.infcust.common.core.capabilities.hatsCapability.HatCapability;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;


public class CustomizationScreen extends Screen  {

    public static final ResourceLocation GUIres = new ResourceLocation("infcust:textures/gui/custbackground_256.png");
    private float xMouse;
    private float yMouse;
    private int leftPos;
    private int topPos;
    private int imageWidth = 1105;
    private int imageHeight = 711;
    TranslationTextComponent guiHeaderText = new TranslationTextComponent("infcust.guiMainHeader");;
    FontRenderer fontRenderer = Minecraft.getInstance().font;
    private CustButton hatsButton;
    private CustButton weaponButton;
    private CustButton armorButton;
    private CustButton backButton;
    private GuiMenuEnum currentMenuPoint = GuiMenuEnum.MAIN;
    private int pagesCount;
    private int currentPage;
    private List<ItemWidget> hatsWidgets = Lists.newArrayList();
    private List<ItemWidget> WeaponWidgets = Lists.newArrayList();
    private List<ItemWidget> ArmorWidgets = Lists.newArrayList();


    public CustomizationScreen() {
        super(new TranslationTextComponent("gui.customization"));

    }

    public void init() {
        super.init();

        this.leftPos = (this.width - 256) / 2;
        this.topPos = (this.height - 195) / 2;

        InfCust.LOGGER.error(currentMenuPoint);

        backButton = new CustButton(leftPos +115, topPos+150 , (this.width/this.height)*130, 20, new TranslationTextComponent("infcust.back"), (p_213030_1_) -> {
            this.showMainButtons();
            InfCust.capabilityUtil.updateCapabilityHatId(-1);
        });
        this.addButton(backButton);

        if (currentMenuPoint == GuiMenuEnum.MAIN) {
            initMainGuiScreen();

        }
        else {

            initHatsScreen();

        }


    }


    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {

        this.renderBackground(p_230430_1_);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(GUIres);
        this.blit(p_230430_1_, leftPos, topPos, 0, 0, 256, 195);
        //GuiUtils.drawContinuousTexturedBox(leftPos,topPos,0,0,this.width,this.height,256,200,1,0.0F);
        renderPlayerInScreen(leftPos+54, topPos+167, 65, (float)(0) - this.xMouse, (float)(0) - this.yMouse);

        fontRenderer.drawShadow(p_230430_1_,guiHeaderText, leftPos +150, topPos-5, 16777215);

        if (currentMenuPoint != GuiMenuEnum.MAIN & hatsWidgets.size() != 0) {
            generateAndRenderPages(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
        }

        this.xMouse = (float)p_230430_2_;
        this.yMouse = (float)p_230430_3_;

        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);

    }



    private void renderPlayerInScreen(int p_228187_0_, int p_228187_1_, int p_228187_2_, float p_228187_3_, float p_228187_4_) {
        LivingEntity playerEntity = this.minecraft.player;

        float f = (float)Math.atan((double)(p_228187_3_ / 40.0F));
        float f1 = (float)Math.atan((double)(p_228187_4_ / 40.0F));
        RenderSystem.pushMatrix();
        RenderSystem.translatef((float)p_228187_0_, (float)p_228187_1_, 1050.0F);
        RenderSystem.scalef(1.0F, 1.0F, -1.0F);
        MatrixStack matrixstack = new MatrixStack();
        matrixstack.translate(0.0D, 0.0D, 1000.0D);
        matrixstack.scale((float)p_228187_2_, (float)p_228187_2_, (float)p_228187_2_);
        Quaternion quaternion = Vector3f.ZP.rotationDegrees(180.0F);
        Quaternion quaternion1 = Vector3f.XP.rotationDegrees(f1 * 20.0F);
        quaternion.mul(quaternion1);
        matrixstack.mulPose(quaternion);
        float f2 = playerEntity.yBodyRot;
        float f3 = playerEntity.yRot;
        float f4 = playerEntity.xRot;
        float f5 = playerEntity.yHeadRotO;
        float f6 = playerEntity.yHeadRot;
        playerEntity.yBodyRot = 180.0F + f * 20.0F;
        playerEntity.yRot = 180.0F + f * 40.0F;
        playerEntity.xRot = -f1 * 20.0F;
        playerEntity.yHeadRot = playerEntity.yRot;
        playerEntity.yHeadRotO = playerEntity.yRot;
        EntityRendererManager entityrenderermanager = Minecraft.getInstance().getEntityRenderDispatcher();
        quaternion1.conj();
        entityrenderermanager.overrideCameraOrientation(quaternion1);
        entityrenderermanager.setRenderShadow(false);
        IRenderTypeBuffer.Impl irendertypebuffer$impl = Minecraft.getInstance().renderBuffers().bufferSource();
        RenderSystem.runAsFancy(() -> {
            entityrenderermanager.render(playerEntity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, matrixstack, irendertypebuffer$impl, 15728880);
        });
        irendertypebuffer$impl.endBatch();
        entityrenderermanager.setRenderShadow(true);
        playerEntity.yBodyRot = f2;
        playerEntity.yRot = f3;
        playerEntity.xRot = f4;
        playerEntity.yHeadRotO = f5;
        playerEntity.yHeadRot = f6;
        //playerEntity.setItemInHand(playerEntity.getUsedItemHand(), ItemStack.EMPTY);
        RenderSystem.popMatrix();
    }

    public void drawTexturedRect()

    {
        //RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.disableAlphaTest();
        minecraft.getTextureManager().bind(GUIres);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.vertex((double)leftPos, (double)leftPos+imageHeight, 0.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)leftPos+imageWidth, (double)topPos+imageHeight, 0.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)leftPos+imageWidth, (double)topPos, 0.0D).uv(0.0F, 0.0F).endVertex();
        bufferbuilder.vertex((double)leftPos, (double)topPos, 0.0D).uv(0.0F, 0.0F).endVertex();
        tessellator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.enableAlphaTest();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

    }

    ////// Main GUI functions

    private void initMainGuiScreen() {
        hatsButton = new CustButton(leftPos +115, topPos+20 ,(this.width/this.height)*130 , 20, new TranslationTextComponent("infcust.hats"), (p_213030_1_) -> {
            this.initHatsScreen();});

        weaponButton = new CustButton(leftPos +115, topPos+50 , (this.width/this.height)*130, 20, new TranslationTextComponent("infcust.armor"), (p_213030_1_) -> {
            this.hideMainButtons();});

        armorButton = new CustButton(leftPos +115, topPos+80 , (this.width/this.height)*130, 20, new TranslationTextComponent("infcust.weapon"), (p_213030_1_) -> {
            this.hideMainButtons();});

        this.addButton(hatsButton);
        this.addButton(weaponButton);
        this.addButton(armorButton);
    }

    private void setGUIHeaderText(GuiMenuEnum menuPoint) {

        if (menuPoint == GuiMenuEnum.MAIN) {
            guiHeaderText = new TranslationTextComponent("infcust.guiMainHeader");
        }
        else if (menuPoint == GuiMenuEnum.HATS) {
            guiHeaderText = new TranslationTextComponent("infcust.guiHatsHeader");
        }
        else if (menuPoint == GuiMenuEnum.WEAPON) {
            guiHeaderText = new TranslationTextComponent("infcust.guiWeaponHeader");
        }
        else
        {
            guiHeaderText = new TranslationTextComponent("infcust.guiArmorHeader");
        }
    }

    private void hideMainButtons() {
        for (int btn = 1; btn <= 3; btn = btn+1) {
            this.buttons.get(btn).setMessage(new TranslationTextComponent(""));
            this.buttons.get(btn).setAlpha(0.0F);
            this.buttons.get(btn).visible = false;
            this.buttons.get(btn).setWidth(0);
        }
    }

    private void showMainButtons() {
        hideAllItems();
    }

    private void hideAllItems() {
        for (int itemIndex=0; itemIndex <= hatsWidgets.size()-1; itemIndex = itemIndex+1) {
            this.hatsWidgets.get(itemIndex).isVisible = false;
        }
    }

    private void calculatePages() {

    }

    ////// Main GUI functions

    ////// Hats functions in GUI

    private void initHats() {

//        InfCust.itemsHandler.CustItems.forEach(item -> { if (item.menuPlacement==GuiMenuEnum.HATS) { addItem(new ItemWidget(leftPos +115, topPos+20 , 40, 40, new TranslationTextComponent("infcust.testwidget"),GuiMenuEnum.HATS ,item,(p_213030_1_) -> {
//          InfCust.itemsHandler.setCurrentItem(item);}));
//
//        }});

        this.addButton(new ItemWidget(leftPos + 110, topPos + 20, 40, 40, new TranslationTextComponent("infcust.testwidget"), GuiMenuEnum.HATS, InfCust.itemsHandler.getItemByIndex(0), (p_213030_1_) -> {
            InfCust.itemsHandler.setCurrentItem(InfCust.itemsHandler.getItemByIndex(0));
            InfCust.capabilityUtil.updateCapabilityHatId(0);
            InfCust.LOGGER.error("updated capa");
        }));


        InfCust.LOGGER.error("INITHATS ");
    }

    public void addItem(ItemWidget itemWidget) {
        this.hatsWidgets.add(itemWidget);
    }

    public void generateAndRenderPages(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {

        // Shit code is my life



    //    int i =0;
    //    for(int currentColumn=1; currentColumn<=4; currentColumn= currentColumn+1)
    //    {
    //        for(int currentRow=1; currentRow<=2; currentRow= currentRow+1)
    //        {
    //            this.hatsWidgets.get(i).x = leftPos + (currentRow*40);
    //            this.hatsWidgets.get(i).y = leftPos + (currentColumn*40);
    //            this.hatsWidgets.get(i).render(p_230430_1_,p_230430_2_,p_230430_3_,p_230430_4_);
    //            i = i +1;
    //        }
    //    }

    }

    private void showHatsWidgets() {
        InfCust.itemsHandler.CustItems.forEach(item -> { if (item.menuPlacement==GuiMenuEnum.HATS) {this.buttons.get(item.getButtonNumber());}});
    }

    private void initHatsScreen() {
        if (currentMenuPoint != GuiMenuEnum.HATS){
            hideMainButtons();
        }
        currentMenuPoint = GuiMenuEnum.HATS;
        setGUIHeaderText(GuiMenuEnum.HATS);
        initHats();
    }

    ////// Hats functions in GUI


}
