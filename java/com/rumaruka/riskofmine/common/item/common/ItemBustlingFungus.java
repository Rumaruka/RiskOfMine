package com.rumaruka.riskofmine.common.item.common;

import com.rumaruka.riskofmine.api.EnumType;
import com.rumaruka.riskofmine.common.item.ItemTypesThings;
import com.rumaruka.riskofmine.events.MovingHandler;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBustlingFungus extends ItemTypesThings {

    public String info = "ror.shiftpress.info";
    public String bf = "ror.bf.info";
    public ItemBustlingFungus() {
        super("bustling_fungus", EnumType.COMMON);
    }



    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.translateToLocal(TextFormatting.WHITE+getTypeName()));
        tooltip.add(I18n.translateToLocal(info));

        if(GuiScreen.isShiftKeyDown()){
            tooltip.add(I18n.translateToLocal(bf));
            tooltip.add(I18n.translateToLocal("[Stacks:"+stack.getCount()+"]"));
        }

    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {

            if (entity instanceof EntityPlayer && ((EntityPlayer) entity).getHeldItemOffhand().getItem() == this) {

                if (!MovingHandler.isMoving((EntityPlayerMP) entity)) {
                    ((EntityPlayer) entity).heal((stack.getCount() + 0.045f) / 20f);
                }


            }

        }

        super.onUpdate(stack, worldIn, entity, itemSlot, isSelected);
    }

}
