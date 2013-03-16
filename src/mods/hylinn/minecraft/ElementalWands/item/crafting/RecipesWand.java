package hylinn.minecraft.ElementalWands.item.crafting;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.ItemWand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesWand {
	
	private static String[][] patterns = new String[][] {{" E ", " M ", " M "}, {"E  ", " M ", "  M"}, {"  E", " M ", "M  "}};
	private static Item[] wands = {
		ElementalWands.boneAirWand, ElementalWands.boneArcaneWand, ElementalWands.boneEarthWand, ElementalWands.boneFireWand, ElementalWands.boneWaterWand,
		ElementalWands.goldAirWand, ElementalWands.goldArcaneWand, ElementalWands.goldEarthWand, ElementalWands.goldFireWand, ElementalWands.goldWaterWand,
		ElementalWands.ironAirWand, ElementalWands.ironArcaneWand, ElementalWands.ironEarthWand, ElementalWands.ironFireWand, ElementalWands.ironWaterWand,
		ElementalWands.woodAirWand, ElementalWands.woodArcaneWand, ElementalWands.woodEarthWand, ElementalWands.woodFireWand, ElementalWands.woodWaterWand,
		ElementalWands.quartzAirWand, ElementalWands.quartzArcaneWand, ElementalWands.quartzEarthWand, ElementalWands.quartzFireWand, ElementalWands.quartzWaterWand
	};
	
	public static void addRecipes() {
		
		for (int wandIndex = 0; wandIndex < wands.length; wandIndex++) {
			for (int patternIndex = 0; patternIndex < patterns.length; patternIndex++) {
				ItemWand wand = (ItemWand) wands[wandIndex];
				GameRegistry.addRecipe(new ItemStack(wand), new Object[] {patterns[patternIndex], 'M', wand.getWandMaterial(), 'E', wand.getElementMaterial()});
			}
		}
		
	}
}
