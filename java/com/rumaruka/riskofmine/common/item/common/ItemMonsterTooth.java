package com.rumaruka.riskofmine.common.item.common;

import com.rumaruka.riskofmine.api.EnumType;
import com.rumaruka.riskofmine.common.entity.EntityHealOrb;
import com.rumaruka.riskofmine.common.item.ItemTypesThings;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMonsterTooth extends ItemTypesThings {


    public String info = "ror.shiftpress.info";
    public String mt = "ror.mt.info";
    public ItemMonsterTooth() {

        super("monster_tooth",  EnumType.COMMON);
    }



    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.translateToLocal(TextFormatting.WHITE+getTypeName()));
        tooltip.add(I18n.translateToLocal(info));
        if(GuiScreen.isShiftKeyDown()){
            tooltip.add(I18n.translateToLocal(mt));
            tooltip.add(I18n.translateToLocal("[Stacks:"+stack.getCount()+"]"));
        }
    }






}
