package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.client.gui.GuiMenuEnum;
import com.feedoktv.infcust.common.items.CustItem;
import com.feedoktv.infcust.common.models.test_armorhatmodel;

import java.util.ArrayList;

public class ItemsHandler {

    public  ArrayList<CustItem> CustItems = new ArrayList<>();
    private CustItem currentItem;

    public void initItems() {
        CustItems.add(new CustItem(new test_armorhatmodel(),"test_hatmodel", GuiMenuEnum.HATS));
        InfCust.LOGGER.error("[INFCUST] ALL ITEMS INITIALIZED");
    }

    public CustItem getItemByIndex(int index) {
        return CustItems.get(index);
    }

    public CustItem getCurrentItem() { return currentItem;}

    public void setCurrentItem(CustItem item) { currentItem = item;
    InfCust.LOGGER.error(item.name);}

}
