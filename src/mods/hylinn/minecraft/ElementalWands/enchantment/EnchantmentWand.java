package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import hylinn.minecraft.ElementalWands.item.ItemWand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentWand extends Enchantment {

	public final EnumWandElement element;
	protected final int MIN_LEVEL = 1;
	protected final int MAX_LEVEL = 5;
	
	public EnchantmentWand(int id, int weight, EnumWandElement element) {
		super(id, weight, ElementalWands.enchantmentWand);
		this.element = element;
	}
	
	public boolean canApplyTogether(Enchantment enchantment) {
		return false;
	}
	
	public boolean func_92089_a(ItemStack stack) {
        return this.canApplyAtEnchantingTable(stack);
    }
	
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem() instanceof ItemWand ? ((ItemWand) stack.getItem()).element == this.element : false;
    }
	
	public int getMinLevel() {
		return MIN_LEVEL;
	}

	public int getMaxLevel() {
		return MAX_LEVEL;
	}
}
