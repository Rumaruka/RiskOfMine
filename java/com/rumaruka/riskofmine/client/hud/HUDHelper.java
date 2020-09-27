package com.rumaruka.riskofmine.client.hud;

import com.rumaruka.riskofmine.RiskOfMine;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = RiskOfMine.MODID)
public class HUDHelper {

   // public static final ResourceLocation shieldBar = new ResourceLocation();
   // public static final ResourceLocation barrierBar = new ResourceLocation();
   // public static final ResourceLocation blockhealBar = new ResourceLocation();

    public static void onDrawScreenPost(RenderGameOverlayEvent.Post event){}

    private static void renderShieldInvBar(ScaledResolution res, boolean hasCreative, int totalShield, int totalMaxShield) {}
    private static void renderBarrierInvBar(ScaledResolution res, boolean hasCreative, int totalBarrier, int totalMaxBarrier) {}
    private static void renderBlockHealhInvBar(ScaledResolution res, boolean hasCreative, int totalBlock, int totalMaxBlock) {}
}
