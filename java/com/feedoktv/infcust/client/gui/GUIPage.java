package com.feedoktv.infcust.client.gui;

import com.feedoktv.infcust.InfCust;
import com.feedoktv.infcust.client.gui.Widgets.ItemWidget;
import com.feedoktv.infcust.common.core.networking.PacketDispatcher;
import com.feedoktv.infcust.common.core.networking.packets.CapabilityUpdateServerPacket;
import com.feedoktv.infcust.common.items.CustItem;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.List;

public class GUIPage {

    private List<CustItem> items = Lists.newArrayList();
    private List<GUIPageItem> pageItems = Lists.newArrayList();
    private List<ItemWidget> widgets = Lists.newArrayList();
    private List<GUIPageItem> GUIItems = Lists.newArrayList();
    private int leftPos;
    private int topPos;

    public GUIPage(List<CustItem> _items, int _leftPos, int _topPos)
    {
        this.items = _items;
        this.leftPos = _leftPos;
        this.topPos = _topPos;
    }

    public void initializeWidgets(int lp, int tp)
    {
        // If you're reading this dm me in tg @feedoktv
        // IDK HOW TO MAKE THIS FUCKING SHIT WORK NORMAL WITHOUT SHIT CODE LIKE YOU CAN SEE
        widgets.clear();
        InfCust.LOGGER.error(items.size());

        int itemCount = 0;

        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3 ; row++) {
                if (itemCount < items.size()) {
                    //int _x = lp + (50 * row) + lp;
                    //int _y = tp + (50 * column) + tp;
                    int _x = ((lp/2)-20) + (50 * row);
                    int _y = ((tp/2)-80) + (50 * column);
                    //InfCust.LOGGER.error(_x + "  " + _y);
                    /*
                    widgets.add( new ItemWidget(leftPos + 110, topPos + 20, 40, 40, new TranslationTextComponent("infcust.testwidget"), 11,11,1 ,GuiMenuEnum.HATS, InfCust.itemsHandler.getItemByIndex(1), (p_213030_1_) -> {
                        InfCust.LOGGER.error("Maaaan");
                    }));
                    */
                    GUIItems.add(new GUIPageItem(items.get(itemCount),_x,_y));
                    itemCount++;
                }
            }
        }
        InfCust.LOGGER.error("[PAGE INTITALIZED]");
    }

    public void updateDimensions(int _leftPos, int _topPos)
    {
        this.leftPos = _leftPos;
        this.topPos = _topPos;
    }

    public List<ItemWidget> getPageWidgets()
    {
        return widgets;
    }
    public List<GUIPageItem> getGUIItems()
    {
        return GUIItems;
    }

    public class GUIPageItem {
        public CustItem custItem;
        public int xPos;
        public int yPos;

        public GUIPageItem(CustItem _item,int _xPos,int _yPos)
        {
            this.custItem = _item;
            this.xPos = _xPos;
            this.yPos = _yPos;
        }

    }
}
