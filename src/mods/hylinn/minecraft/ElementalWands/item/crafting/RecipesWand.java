package hylinn.minecraft.ElementalWands.item.crafting;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.ItemWand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesWand {
	
	private static String[][] patterns = new String[][] {{" E ", " M ", " M "}, {"E  ", " M ", "  M"}, {"  E", " M ", "M  "}};
	
	public static void addRecipes() {
		
		for (int wandIndex = 0; wandIndex < ElementalWands.wands.length; wandIndex++) {
			for (int patternIndex = 0; patternIndex < patterns.length; patternIndex++) {
				ItemWand wand = (ItemWand) ElementalWands.wands[wandIndex];
				GameRegistry.addRecipe(new ItemStack(wand), new Object[] {patterns[patternIndex], 'M', wand.getWandMaterial(), 'E', wand.getElementMaterial()});
			}
		}
		
	}
}
