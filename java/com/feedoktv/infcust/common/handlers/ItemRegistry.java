package com.feedoktv.infcust.common.handlers;

import com.feedoktv.infcust.InfCust;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfCust.MOD_ID);

    public static final RegistryObject<Item> test_hatitem = ITEMS.register("test_hatmodel",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> test_glassesitem = ITEMS.register("test_glasses",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> test_huy = ITEMS.register("test_huy",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
