package hylinn.minecraft.ElementalWands.client;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
       
    @Override
    public void load() {
    	TickRegistry.registerTickHandler(new ElementalWandsTickHandler(), Side.CLIENT);
    }
}
