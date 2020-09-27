package com.rumaruka.riskofmine.events;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber
public class MovingHandler {

    private static HashMap<UUID, MoveInfo> moveMap = new HashMap<>();


    @SubscribeEvent
    public static void onPlayerIn(PlayerEvent.PlayerLoggedInEvent e){
        moveMap.put(e.player.getUniqueID(),new MoveInfo(e.player));
    }
    @SubscribeEvent
    public static void onPlayerOut(PlayerEvent.PlayerLoggedOutEvent e){
        moveMap.remove(e.player.getUniqueID());

    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.side == Side.SERVER && event.phase== TickEvent.Phase.END) {

            MoveInfo moveInfo = moveMap.get(event.player.getUniqueID());

            if(moveInfo!=null){
                moveInfo.update(event.player);

            }
        }


    }


    public static boolean isMoving(EntityPlayerMP mp){
        MoveInfo moveInfo = moveMap.get(mp.getUniqueID());
        if(moveInfo!=null){
            return moveInfo.isPosChanged();
        }
        return false;
    }

    public static class MoveInfo {
        private double lastPosX;
        private double lastPosY;
        private double lastPosZ;

        private boolean posChanged;

        public MoveInfo(EntityPlayer player) {
            updateLastPos(player);
        }

        private void updateLastPos(EntityPlayer player) {
            lastPosX = player.posX;
            lastPosY = player.posY;
            lastPosZ = player.posZ;
        }

        public void update(EntityPlayer player) {
            posChanged = lastPosX != player.posX || lastPosY != player.posY || lastPosZ != player.posZ;
            if (posChanged) updateLastPos(player);

        }

        public boolean isPosChanged() {
            return posChanged;
        }

    }
}

