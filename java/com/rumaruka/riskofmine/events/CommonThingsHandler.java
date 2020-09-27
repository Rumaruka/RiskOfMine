package com.rumaruka.riskofmine.events;


import com.rumaruka.riskofmine.common.entity.EntityHealOrb;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonThingsHandler {

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event) {
        World world = event.getEntity().world;
        EntityLivingBase player = (EntityLivingBase) event.getSource().getTrueSource();
        ItemStack stack = player != null ? player.getHeldItemOffhand() : ItemStack.EMPTY;
        if (!world.isRemote) {
            if (stack.isEmpty() && stack.getItem() == ROMItems.monster_tooth&& player instanceof EntityPlayer && event.getEntity() instanceof EntityCreature) {
                EntityHealOrb entityHealOrb = new EntityHealOrb(world,event.getEntity().posX+ 0.5D,event.getEntity().posY + 0.5D,event.getEntity().posZ + 0.5D,10000000);

                world.spawnEntity(entityHealOrb);
            }

        }
    }
}