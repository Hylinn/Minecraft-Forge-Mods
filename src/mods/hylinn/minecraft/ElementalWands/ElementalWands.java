package hylinn.minecraft.ElementalWands;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.EnumAction;
import net.minecraftforge.common.EnumHelper;
import hylinn.minecraft.ElementalWands.creativetab.CreativeTabWand;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentAirShield;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentArcaneShield;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentBurrow;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentConjureWater;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentDetectOre;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentDispel;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentEarthShield;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentEntangle;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentFireShield;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentFireball;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentFlameStep;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentFlameWall;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentFlameWeapon;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentGust;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentIceBolt;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentIceShield;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentLight;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentLightning;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentMagicMissile;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentSafeFall;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentStoneSpikes;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentSummonSnowGolem;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentSwiftSwim;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentToughness;
import hylinn.minecraft.ElementalWands.enchantment.EnchantmentVortex;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ElementalWands", name="Elemental Wands", version="0.0.2")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ElementalWands {

    public static ItemWand[] wands;
    private static final int wandStartId = 31000;
    public static final String modName = "ElementalWands";
    
    public static final EnumEnchantmentType enchantmentWand = EnumHelper.addEnchantmentType("wand");
    public static final EnumAction actionWand = EnumHelper.addAction("wand");
    
    public static final Enchantment fireball = new EnchantmentFireball(200, 10);
    public static final Enchantment flameStep = new EnchantmentFlameStep(201, 10);
    public static final Enchantment flameWall = new EnchantmentFlameWall(202, 10);
    public static final Enchantment fireShield = new EnchantmentFireShield(203, 10);
    public static final Enchantment flameWeapon = new EnchantmentFlameWeapon(204, 10);
    
    public static final Enchantment toughness = new EnchantmentToughness(205, 10);
    public static final Enchantment light = new EnchantmentLight(206, 10);
    public static final Enchantment dispel = new EnchantmentDispel(207, 10);
    public static final Enchantment magicMissile = new EnchantmentMagicMissile(208, 10);
    public static final Enchantment arcaneShield = new EnchantmentArcaneShield(209, 10);
    
    public static final Enchantment gust = new EnchantmentGust(210, 10);
    public static final Enchantment airShield = new EnchantmentAirShield(211, 10);
    public static final Enchantment safeFall = new EnchantmentSafeFall(212, 10);
    public static final Enchantment vortex = new EnchantmentVortex(213, 10);
    public static final Enchantment lightning = new EnchantmentLightning(214, 10);
    
    public static final Enchantment stoneSpikes = new EnchantmentStoneSpikes(215, 10);
    public static final Enchantment detectOre = new EnchantmentDetectOre(216, 10);
    public static final Enchantment entangle = new EnchantmentEntangle(217, 10);
    public static final Enchantment earthShield = new EnchantmentEarthShield(218, 10);
    public static final Enchantment burrow = new EnchantmentBurrow(219, 10);
    
    public static final Enchantment iceBolt = new EnchantmentIceBolt(220, 10);
    public static final Enchantment swiftSwim = new EnchantmentSwiftSwim(221, 10);
    public static final Enchantment conjureWater = new EnchantmentConjureWater(222, 10);
    public static final Enchantment iceShield = new EnchantmentIceShield(223, 10);
    public static final Enchantment summonSnowGolem = new EnchantmentSummonSnowGolem(224, 10);
    
    public static final CreativeTabs wandTab = new CreativeTabWand("wandTab");
    
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
    	
    	LanguageRegistry.instance().addStringLocalization("itemGroup.wandTab", "en_US", "Wands");
    	
        //proxy.registerRenderers();
    }
   
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        // Stub Method
    }
}
