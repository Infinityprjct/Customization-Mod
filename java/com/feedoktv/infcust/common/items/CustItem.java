package com.feedoktv.infcust.common.items;

import com.feedoktv.infcust.client.gui.GuiMenuEnum;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class CustItem {
    public String name;
    public GuiMenuEnum menuPlacement;
    protected ResourceLocation modelTexture;
    protected float modelScale;
    protected AgeableModel model;
    protected EntityModel entityModel;
    private String itemName;
    private int buttonNumber;
    private Item mcItem;

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

    public CustItem(AgeableModel _model, String _itemName, GuiMenuEnum _menuPlacement, Item _mcItem) {
        this.modelTexture = new ResourceLocation("infcust:textures/item/" + _itemName + ".png");;
        this.modelScale = 1F;
        this.model = _model;
        this.itemName = _itemName;
        this.menuPlacement = _menuPlacement;
        this.mcItem = _mcItem;
    }

    public CustItem(EntityModel _model, String _itemName, GuiMenuEnum _menuPlacement, Item _mcItem) {
        this.modelTexture = new ResourceLocation("infcust:textures/item/" + _itemName + ".png");;
        this.modelScale = 1F;
        this.entityModel = _model;
        this.itemName = _itemName;
        this.menuPlacement = _menuPlacement;
        this.mcItem = _mcItem;
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

    public EntityModel getEntityModel()
    {
        return entityModel;
    }

    public String getItemName() {
        return itemName;
    }

    public String getTexturePath() {
        return "infcust:textures/item/" + itemName + ".png";
    }

    public String getName() { return name;}

    public Item getMcItem() {return this.mcItem;}

    public int getButtonNumber() { return buttonNumber;}

    public void setButtonNumber(int _buttonNumber) { this.buttonNumber = _buttonNumber;}


}
