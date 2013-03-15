package hylinn.minecraft.ElementalWands.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import hylinn.minecraft.ElementalWands.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {
       
        @Override
        public void registerRenderers() {
                //MinecraftForgeClient.preloadTexture(ITEMS_PNG);
                //MinecraftForgeClient.preloadTexture(BLOCK_PNG);
        }
       
}
