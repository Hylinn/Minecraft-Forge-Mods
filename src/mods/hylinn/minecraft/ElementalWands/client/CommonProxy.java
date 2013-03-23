package hylinn.minecraft.ElementalWands.client;

import hylinn.minecraft.ElementalWands.server.WorldTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
   
    public void load() {
    	TickRegistry.registerTickHandler(new WorldTickHandler(), Side.SERVER);
    }
}