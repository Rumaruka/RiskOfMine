package com.rumaruka.riskofmine;


import com.rumaruka.riskofmine.events.ClientEventHandler;
import com.rumaruka.riskofmine.events.CommonThingsHandler;
import com.rumaruka.riskofmine.events.MovingHandler;
import com.rumaruka.riskofmine.init.ROMEntites;
import com.rumaruka.riskofmine.init.ROMItems;
import com.rumaruka.riskofmine.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.rumaruka.riskofmine.RiskOfMine.*;

@Mod(modid = MODID,name = NAME,version = VER)
public class RiskOfMine {

    public static final String MODID = "riskofmine";
    public static final String NAME = "Risk Of Mine";
    public static final String VER = "1.0";
    //Networking
    public static final String serverProxy = "com.rumaruka.riskofmine.proxy.CommonProxy";
    public static final String clientProxy = "com.rumaruka.riskofmine.proxy.ClientProxy";

    @SidedProxy(serverSide = serverProxy, clientSide = clientProxy)
    public static CommonProxy proxy;
    @Mod.Instance(MODID)
    public static RiskOfMine instance;
    public static Logger logger = LogManager.getLogger(NAME);
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger.info("=======================");
        logger.info("=Registration Objects for Risk of Mine=");
        logger.info("=======================");
        instance = this;

        ROMItems.init();
        ROMItems.setup();
        ROMEntites.register();
        proxy.preInit();


    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

        logger.info("=======================");
        logger.info("=Registration Handlers for Risk of Mine=");
        logger.info("=======================");
        MinecraftForge.EVENT_BUS.register(new MovingHandler());
        MinecraftForge.EVENT_BUS.register(new CommonThingsHandler());

    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        logger.info("=======================");
        logger.info("=Registration Render and Client events for Risk of Mine=");
        logger.info("=======================");
        proxy.renderObject();
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());


    }


}
