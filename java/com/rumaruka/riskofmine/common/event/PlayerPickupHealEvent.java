package com.rumaruka.riskofmine.common.event;

import com.rumaruka.riskofmine.common.entity.EntityHealOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
@Mod.EventBusSubscriber
public class PlayerPickupHealEvent extends PlayerEvent
{
    private final EntityHealOrb orb;

    public PlayerPickupHealEvent(EntityPlayer player, EntityHealOrb orb)
    {
        super(player);
        this.orb = orb;
    }

    public EntityHealOrb getOrb()
    {
        return orb;
    }
}