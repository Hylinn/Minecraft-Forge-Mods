package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import hylinn.minecraft.ElementalWands.item.ItemWand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EnchantmentWand extends Enchantment implements ICastable{

	public final EnumWandElement element;
	protected int minLevel = 1;
	protected int maxLevel = 5;
	protected float castCost = 1.0F;
	protected float maxCastTime = 5.0F; // in Seconds
	
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
	
	public int getCastChargeCost(int itemInUseDuration) {
		float seconds = itemInUseDuration / 20.0F;
		return (int) Math.min(maxCastTime, Math.pow(2, seconds) * castCost);
	}
	
	public int getMinEnchantability(int level) {
		return (int) Math.pow(3, level - 1);
	}
	
	public int getMaxEnchantability(int level) {
		return 50;
	}
	
	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration) {
		System.out.println(this.getTranslatedName(level) + " cast after charging for " + itemInUseDuration);
		return getCastChargeCost(itemInUseDuration);
	}
}
