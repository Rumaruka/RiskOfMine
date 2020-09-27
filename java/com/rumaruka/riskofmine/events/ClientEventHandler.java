package com.rumaruka.riskofmine.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.server.command.TextComponentHelper;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;


@Mod.EventBusSubscriber(modid = MODID,value = Side.CLIENT)
public class ClientEventHandler {


    @SubscribeEvent
    public void onPlayerLoggedWorld(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        sendMessage(player);
    }

    private void sendMessage(EntityPlayer player) {

            TextComponentBase message = TextComponentHelper.createComponentTranslation(player, "message.welcome", player.getDisplayName());
            TextComponentBase message1 = TextComponentHelper.createComponentTranslation(player, "message.welcome_n", player.getDisplayName());
            message.getStyle().setColor(TextFormatting.WHITE);
            message1.getStyle().setColor(TextFormatting.RED);
            player.sendMessage(message);
            player.sendMessage(message1);

    }
}
