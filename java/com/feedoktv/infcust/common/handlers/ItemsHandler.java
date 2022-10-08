package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.client.gui.GuiMenuEnum;
import com.feedoktv.infcust.common.items.CustItem;
import com.feedoktv.infcust.common.models.*;

import java.util.ArrayList;

public class ItemsHandler {

    public  ArrayList<CustItem> CustItems = new ArrayList<>();
    private CustItem currentItem;

    public void initItems() {
        CustItems.add(new CustItem(new KaidoPet(),"test_glasses", GuiMenuEnum.HATS, ItemRegistry.test_huy.get()));
        CustItems.add(new CustItem(new lol_glasses(),"test_glasses", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_glasses(),"test_glasses", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_glasses(),"test_glasses", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel3", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel4", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel5", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel6", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel7", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel8", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel9", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel10", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel11", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel12", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel13", GuiMenuEnum.HATS, ItemRegistry.test_hatitem.get()));
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel14", GuiMenuEnum.WEAPON, ItemRegistry.test_hatitem.get()));
        InfCust.LOGGER.error("[INFCUST] ALL ITEMS INITIALIZED");
    }

    public CustItem getItemByIndex(int index) {
        return CustItems.get(index);
    }

    public CustItem getCurrentItem() { return currentItem;}

    public void setCurrentItem(CustItem item) { currentItem = item;
    InfCust.LOGGER.error(item.name);}

}
