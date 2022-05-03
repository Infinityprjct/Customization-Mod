package com.feedoktv.infcust.common.items;

import com.feedoktv.infcust.common.models.test_armorhatmodel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class test_hatitem extends ArmorItem {
    public test_hatitem() {
        super(ArmorMaterial.CHAIN, EquipmentSlotType.HEAD, new Item.Properties().tab(ItemGroup.TAB_MISC));

    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        test_armorhatmodel model = new test_armorhatmodel();

        return (A) model;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "infcust:textures/item/test_hatmodel.png";
    }
}
