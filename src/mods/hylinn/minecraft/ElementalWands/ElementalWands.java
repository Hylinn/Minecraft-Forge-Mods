package hylinn.minecraft.ElementalWands;

import java.util.Arrays;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
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

@Mod(modid="ElementalWands", name="Elemental Wands", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ElementalWands {

//	// Create the fire wands.
//    public static final Item wandFireWood   = (new ItemWand(31000, EnumWandMaterial.WOOD,   EnumWandElement.FIRE)).setUnlocalizedName("ElementalWands:wandFireWood");
//    public static final Item wandFireBone   = (new ItemWand(31001, EnumWandMaterial.BONE,   EnumWandElement.FIRE)).setUnlocalizedName("ElementalWands:wandFireBone");
//    public static final Item wandFireIron   = (new ItemWand(31002, EnumWandMaterial.IRON,   EnumWandElement.FIRE)).setUnlocalizedName("ElementalWands:wandFireIron");
//    public static final Item wandFireQuartz = (new ItemWand(31003, EnumWandMaterial.QUARTZ, EnumWandElement.FIRE)).setUnlocalizedName("ElementalWands:wandFireQuartz");
//    public static final Item wandFireGold   = (new ItemWand(31004, EnumWandMaterial.GOLD,   EnumWandElement.FIRE)).setUnlocalizedName("ElementalWands:wandFireGold");
//    
//    // Create the earth wands.
//    public static final Item wandEarthWood   = (new ItemWand(31005, EnumWandMaterial.WOOD,   EnumWandElement.EARTH)).setUnlocalizedName("ElementalWands:wandEarthWood");
//    public static final Item wandEarthBone   = (new ItemWand(31006, EnumWandMaterial.BONE,   EnumWandElement.EARTH)).setUnlocalizedName("ElementalWands:wandEarthBone");
//    public static final Item wandEarthIron   = (new ItemWand(31007, EnumWandMaterial.IRON,   EnumWandElement.EARTH)).setUnlocalizedName("ElementalWands:wandEarthIron");
//    public static final Item wandEarthQuartz = (new ItemWand(31008, EnumWandMaterial.QUARTZ, EnumWandElement.EARTH)).setUnlocalizedName("ElementalWands:wandEarthQuartz");
//    public static final Item wandEarthGold   = (new ItemWand(31009, EnumWandMaterial.GOLD,   EnumWandElement.EARTH)).setUnlocalizedName("ElementalWands:wandEarthGold");
//    
//    // Create the water wands.
//    public static final Item wandWaterWood   = (new ItemWand(31010, EnumWandMaterial.WOOD,   EnumWandElement.WATER)).setUnlocalizedName("ElementalWands:wandWaterWood");
//    public static final Item wandWaterBone   = (new ItemWand(31011, EnumWandMaterial.BONE,   EnumWandElement.WATER)).setUnlocalizedName("ElementalWands:wandWaterBone");
//    public static final Item wandWaterIron   = (new ItemWand(31012, EnumWandMaterial.IRON,   EnumWandElement.WATER)).setUnlocalizedName("ElementalWands:wandWaterIron");
//    public static final Item wandWaterQuartz = (new ItemWand(31013, EnumWandMaterial.QUARTZ, EnumWandElement.WATER)).setUnlocalizedName("ElementalWands:wandWaterQuartz");
//    public static final Item wandWaterGold   = (new ItemWand(31014, EnumWandMaterial.GOLD,   EnumWandElement.WATER)).setUnlocalizedName("ElementalWands:wandWaterGold");
//    
//    // Create the air wands.
//    public static final Item wandAirWood   = (new ItemWand(31015, EnumWandMaterial.WOOD,   EnumWandElement.AIR)).setUnlocalizedName("ElementalWands:wandAirWood");
//    public static final Item wandAirBone   = (new ItemWand(31016, EnumWandMaterial.BONE,   EnumWandElement.AIR)).setUnlocalizedName("ElementalWands:wandAirBone");
//    public static final Item wandAirIron   = (new ItemWand(31017, EnumWandMaterial.IRON,   EnumWandElement.AIR)).setUnlocalizedName("ElementalWands:wandAirIron");
//    public static final Item wandAirQuartz = (new ItemWand(31018, EnumWandMaterial.QUARTZ, EnumWandElement.AIR)).setUnlocalizedName("ElementalWands:wandAirQuartz");
//    public static final Item wandAirGold   = (new ItemWand(31019, EnumWandMaterial.GOLD,   EnumWandElement.AIR)).setUnlocalizedName("ElementalWands:wandAirGold");
//    
//    // Create the arcane wands.
//    public static final Item wandArcaneWood   = (new ItemWand(31020, EnumWandMaterial.WOOD,   EnumWandElement.ARCANE)).setUnlocalizedName("ElementalWands:wandArcaneWood");
//    public static final Item wandArcaneBone   = (new ItemWand(31021, EnumWandMaterial.BONE,   EnumWandElement.ARCANE)).setUnlocalizedName("ElementalWands:wandArcaneBone");
//    public static final Item wandArcaneIron   = (new ItemWand(31022, EnumWandMaterial.IRON,   EnumWandElement.ARCANE)).setUnlocalizedName("ElementalWands:wandArcaneIron");
//    public static final Item wandArcaneQuartz = (new ItemWand(31023, EnumWandMaterial.QUARTZ, EnumWandElement.ARCANE)).setUnlocalizedName("ElementalWands:wandArcaneQuartz");
//    public static final Item wandArcaneGold   = (new ItemWand(31024, EnumWandMaterial.GOLD,   EnumWandElement.ARCANE)).setUnlocalizedName("ElementalWands:wandArcaneGold");
//	
    public static ItemWand[] wands;
    public static final int wandStartId = 31000;
    public static final String modName = "ElementalWands";
    
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
    	
    	wands = new ItemWand[EnumWandElement.values().length * EnumWandMaterial.values().length];
    	int wandIndex = 0;
    	for (EnumWandElement element : EnumWandElement.values()) {
    		for (EnumWandMaterial material : EnumWandMaterial.values()) {
    			wands[wandIndex] = (ItemWand) (new ItemWand(wandStartId + wandIndex, material, element)).setUnlocalizedName("wand" + element.toString() + material.toString());
    			LanguageRegistry.addName(wands[wandIndex], material.toString() + " " + element.toString() + " Wand");
    			wandIndex++;
    		}
    	}
    	
    	// Register the fire wands.
//    	LanguageRegistry.addName(wandFireWood,   "Wood Fire Wand");
//    	LanguageRegistry.addName(wandFireBone,   "Bone Fire Wand");
//    	LanguageRegistry.addName(wandFireIron,   "Iron Fire Wand");
//    	LanguageRegistry.addName(wandFireQuartz, "Nether Quartz Fire Wand");
//    	LanguageRegistry.addName(wandFireGold,   "Gold Fire Wand");
//    	
//    	// Register the earth wands.
//    	LanguageRegistry.addName(wandEarthWood,   "Wood Earth Wand");
//    	LanguageRegistry.addName(wandEarthBone,   "Bone Earth Wand");
//    	LanguageRegistry.addName(wandEarthIron,   "Iron Earth Wand");
//    	LanguageRegistry.addName(wandEarthQuartz, "Nether Quartz Earth Wand");
//    	LanguageRegistry.addName(wandEarthGold,   "Gold Earth Wand");
//    	
//    	// Register the water wands.
//    	LanguageRegistry.addName(wandWaterWood,   "Wood Water Wand");
//    	LanguageRegistry.addName(wandWaterBone,   "Bone Water Wand");
//    	LanguageRegistry.addName(wandWaterIron,   "Iron Water Wand");
//    	LanguageRegistry.addName(wandWaterQuartz, "Nether Quartz Water Wand");
//    	LanguageRegistry.addName(wandWaterGold,   "Gold Water Wand");
//    	
//    	// Register the air wands.
//    	LanguageRegistry.addName(wandAirWood,   "Wood Air Wand");
//    	LanguageRegistry.addName(wandAirBone,   "Bone Air Wand");
//    	LanguageRegistry.addName(wandAirIron,   "Iron Air Wand");
//    	LanguageRegistry.addName(wandAirQuartz, "Nether Quartz Air Wand");
//    	LanguageRegistry.addName(wandAirGold,   "Gold Air Wand");
//    	
//    	// Register the arcane wands.
//    	LanguageRegistry.addName(wandArcaneWood,   "Wood Arcane Wand");
//    	LanguageRegistry.addName(wandArcaneBone,   "Bone Arcane Wand");
//    	LanguageRegistry.addName(wandArcaneIron,   "Iron Arcane Wand");
//    	LanguageRegistry.addName(wandArcaneQuartz, "Nether Quartz Arcane Wand");
//    	LanguageRegistry.addName(wandArcaneGold,   "Gold Arcane Wand");
    	
    	// Add recipes for the wands.
    	RecipesWand.addRecipes();
    	
        //proxy.registerRenderers();
    }
   
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        // Stub Method
    }
}
