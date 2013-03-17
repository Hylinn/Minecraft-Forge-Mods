package hylinn.minecraft.ElementalWands;

import java.util.Arrays;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentFireball;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import hylinn.minecraft.ElementalWands.item.EnumWandMaterial;
import hylinn.minecraft.ElementalWands.item.ItemWand;
import hylinn.minecraft.ElementalWands.item.crafting.RecipesWand;
import hylinn.minecraft.ElementalWands.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ElementalWands", name="Elemental Wands", version="0.0.2")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ElementalWands {

    public static ItemWand[] wands;
    private static final int wandStartId = 31000;
    public static final String modName = "ElementalWands";
    
    public static final Enchantment fireball = new EnchantmentFireball(200, 10);
    
    // Create the enchantment type for wands.
    public static final EnumEnchantmentType enchantmentWand = EnumHelper.addEnchantmentType("wand");
    
    // Create the action type for wands.
    public static final EnumAction actionWand = EnumHelper.addAction("wand");
    
    @Instance("ElementalWands")
    public static ElementalWands instance;
   
    @SidedProxy(clientSide="hylinn.minecraft.ElementalWands.proxy.ClientProxy", serverSide="hylinn.minecraft.ElementalWands.proxy.CommonProxy")
    public static CommonProxy proxy;
   
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	//event.getModMetadata().version = "0.0.1";
    	//event.getModMetadata().name = "Elemental Wands";
    	//event.getModMetadata().description = "Adds wands of the five elements (Fire, Earth, Water, Air, and Arcane)";
    	//event.getModMetadata().authorList.addAll(Arrays.asList(new String[]{"Hylinn Taggart", "Matt Beyer"}));
    	//event.getModMetadata().logoFile = "";
    	//event.getModMetadata().dependencies.addAll(Arrays.asList(new String[]{"mod_MinecraftForge"}));
    	//event.getModMetadata().credits = "";
    	//event.getModMetadata().updateUrl = "";
    	//event.getModMetadata().modId = "";
    }
   
    @Init
    public void load(FMLInitializationEvent event) {
    	
    	// Create and register all of the wands.
    	wands = new ItemWand[EnumWandElement.values().length * EnumWandMaterial.values().length];
    	int wandIndex = 0;
    	for (EnumWandElement element : EnumWandElement.values()) {
    		for (EnumWandMaterial material : EnumWandMaterial.values()) {
    			wands[wandIndex] = (ItemWand) (new ItemWand(wandStartId + wandIndex, material, element)).setUnlocalizedName("wand" + element.toString() + material.toString());
    			LanguageRegistry.addName(wands[wandIndex], material.toString() + " " + element.toString() + " Wand");
    			wandIndex++;
    		}
    	}
    	
    	// Add recipes for the wands.
    	RecipesWand.addRecipes();
    	
        //proxy.registerRenderers();
    }
   
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        // Stub Method
    }
}
