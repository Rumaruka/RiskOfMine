package com.rumaruka.riskofmine.proxy;

import com.rumaruka.riskofmine.init.ROMEntites;
import com.rumaruka.riskofmine.init.ROMItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        ROMEntites.registerRenders();
    }
    @Override
    public void renderObject() {

        ROMItems.render();
    }
}
