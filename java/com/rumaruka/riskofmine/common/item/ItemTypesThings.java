package com.rumaruka.riskofmine.common.item;

import com.rumaruka.riskofmine.api.EnumType;
import net.minecraft.item.Item;

import static com.rumaruka.riskofmine.client.creativetabs.ROMCreativeTabs.ROM_CreativeTabs;

public class ItemTypesThings extends Item {

    public final String nameItem;
    private final EnumType type;
    public ItemTypesThings(String nameItem, EnumType type) {
        this.nameItem = nameItem;
        this.type = type;
        setUnlocalizedName(nameItem);
        setCreativeTab(ROM_CreativeTabs);

    }

    public EnumType getType() {
        return type;
    }

    public String getTypeName(){
        return type.getName();
    }
}
