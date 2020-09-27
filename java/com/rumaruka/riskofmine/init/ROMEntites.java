package com.rumaruka.riskofmine.init;

import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.client.render.RenderHealOrb;
import com.rumaruka.riskofmine.common.entity.EntityHealOrb;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ROMEntites {


    public static void register(){
        int id = 0;
        registerEntity("healorb",EntityHealOrb.class,id++,80,3,true);

    }
    public static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int trackingRange, int updateFrequency, boolean sendVelocityUpdates) {
        EntityRegistry.registerModEntity(new ResourceLocation(RiskOfMine.MODID + ":" + name), entityClass, name, id, RiskOfMine.instance, trackingRange, updateFrequency, sendVelocityUpdates);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityHealOrb.class, RenderHealOrb::new);
    }



}
