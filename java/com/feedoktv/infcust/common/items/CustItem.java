package com.feedoktv.infcust.common.items;

import com.feedoktv.infcust.client.gui.GuiMenuEnum;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CustItem {
    public String name;
    public GuiMenuEnum menuPlacement;
    protected ResourceLocation modelTexture;
    protected float modelScale;
    protected AgeableModel model;
    private String itemName;
    private int buttonNumber;

    public CustItem(ResourceLocation _modelTex, float _modelScale, AgeableModel _model, String _itemName, String _name,GuiMenuEnum _menuPlacement) {
        this.modelTexture = _modelTex;
        this.modelScale = _modelScale;
        this.model = _model;
        this.itemName = _itemName;
        this.name = _name;
        this.menuPlacement = _menuPlacement;
    }


    public CustItem(ResourceLocation _modelTex, AgeableModel _model,String _itemName) {
        this.modelTexture = _modelTex;
        this.modelScale = 1F;
        this.model = _model;
        this.itemName = _itemName;
    }

    public CustItem(AgeableModel _model,String _itemName, GuiMenuEnum _menuPlacement) {
        this.modelTexture = new ResourceLocation("infcust:textures/item/" + _itemName + ".png");;
        this.modelScale = 1F;
        this.model = _model;
        this.itemName = _itemName;
        this.menuPlacement = _menuPlacement;
    }

    public CustItem(AgeableModel _model,float _modelScale,String _itemName) {
        this.modelTexture = new ResourceLocation("infcust:textures/item/" + _itemName + ".png");;
        this.modelScale = _modelScale;
        this.model = _model;
        this.itemName = _itemName;
    }

    public ResourceLocation getModelTexture() {
        return modelTexture;
    }

    public float getModelScale() {
        return modelScale;
    }

    public AgeableModel getModel() {
        return model;
    }

    public String getItemsName() {
        return itemName;
    }

    public String getTexturePath() {
        return "infcust:textures/item/" + itemName + ".png";
    }

    public String getName() { return name;}

    public int getButtonNumber() { return buttonNumber;}

    public void setButtonNumber(int _buttonNumber) { this.buttonNumber = _buttonNumber;}

}
