package hylinn.minecraft.ElementalWands.creativetab;

import java.util.List;

import hylinn.minecraft.ElementalWands.ElementalWands;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class CreativeTabWand extends CreativeTabs {

	public CreativeTabWand(String label) {
		super(label);
	}

	public CreativeTabWand(int id, String label) {
		super(id, label);
	}
	
	public ItemStack getIconItemStack() {
		return new ItemStack(ElementalWands.wands[0]);
	}
	
    public void displayAllReleventItems(List itemList)
    {
        super.displayAllReleventItems(itemList);
        this.func_92116_a(itemList, new EnumEnchantmentType[] {ElementalWands.enchantmentWand});
    }

}
