package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import hylinn.minecraft.ElementalWands.item.ItemWand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantmentWand extends Enchantment implements ICastable{

	public final EnumWandElement element;
	protected int minLevel = 1;
	protected int maxLevel = 5;
	protected int castCost = 1;
	
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
		return minLevel;
	}

	public int getMaxLevel() {
		return maxLevel;
	}
	
	public int getMinEnchantability(int level) {
		return (int) Math.pow(3, level - 1);
	}
	
	public int getMaxEnchantability(int level) {
		return 50;
	}
	
	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration) {
		System.out.println(this.getTranslatedName(level) + " cast after charging for " + itemInUseDuration);
		return 0;
	}
}
