package com.rumaruka.riskofmine.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public interface IColoredEffect {


    @CapabilityInject(IColoredEffect.class)
    Capability<IColoredEffect>CAPABILITY =null;

    static boolean hasProveder(ItemStack stack){
        return stack.hasCapability(CAPABILITY,null);
    }
    static IColoredEffect getProvider(ItemStack stack){
        return stack.getCapability(CAPABILITY,null);
    }

    int getEffectColor(ItemStack stack);

    default boolean shouldTruncateColorBrightness(ItemStack stack) {
        return true;
    }
}
