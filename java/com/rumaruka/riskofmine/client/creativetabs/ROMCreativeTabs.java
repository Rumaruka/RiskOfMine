package com.rumaruka.riskofmine.client.creativetabs;

import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static net.minecraft.init.Items.DIAMOND;

public class ROMCreativeTabs extends CreativeTabs {

    public static ROMCreativeTabs ROM_CreativeTabs = new ROMCreativeTabs();

    public ROMCreativeTabs( ) {
        super(RiskOfMine.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ROMItems.armor_piercing_rounds);
    }
}
