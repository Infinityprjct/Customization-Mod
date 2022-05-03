package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.client.gui.GuiMenuEnum;
import com.feedoktv.infcust.common.items.CustItem;
import com.feedoktv.infcust.common.items.test_hatitem;
import com.feedoktv.infcust.common.models.test_armorhatmodel;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class ItemsHandler {

    public  ArrayList<CustItem> CustItems = new ArrayList<>();
    private CustItem currentItem;
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfCust.MOD_ID);

    public static final RegistryObject<test_hatitem> test_hatitem = ITEMS.register("test_hatmodel",
            () -> new test_hatitem());


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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
