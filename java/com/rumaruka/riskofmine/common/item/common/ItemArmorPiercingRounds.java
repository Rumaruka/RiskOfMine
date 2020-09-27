package com.rumaruka.riskofmine.common.item.common;

import com.google.common.collect.Multimap;
import com.rumaruka.riskofmine.api.EnumType;
import com.rumaruka.riskofmine.common.item.ItemTypesThings;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemArmorPiercingRounds extends ItemTypesThings {


    public String info = "ror.shiftpress.info";
    public String apr = "ror.apr.info";

    public ItemArmorPiercingRounds( ) {
        super("armor_piercing_rounds", EnumType.COMMON);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.translateToLocal(TextFormatting.WHITE+getTypeName()));
        tooltip.add(I18n.translateToLocal(info));
        if(GuiScreen.isShiftKeyDown()){
            tooltip.add(I18n.translateToLocal(apr));
            tooltip.add(I18n.translateToLocal("[Stacks:"+stack.getCount()+"]"));
        }

    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        EntityLivingBase livingBase = (EntityLivingBase) entityIn;
        if(!worldIn.isRemote && livingBase instanceof EntityWither || livingBase instanceof EntityDragon ||!livingBase.isNonBoss()){

                EntityPlayer player = (EntityPlayer) entityIn;

                player.getAttributeMap().applyAttributeModifiers(getAttributeModifiers(EntityEquipmentSlot.OFFHAND, stack));

        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {


        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);

        if (slot == EntityEquipmentSlot.OFFHAND )
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", stack.getCount()*2-1, 0));

        }

        return multimap;
    }

}
