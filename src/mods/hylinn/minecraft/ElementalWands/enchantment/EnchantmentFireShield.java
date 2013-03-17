package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EnchantmentFireShield extends EnchantmentWand implements ICastable {

	protected final int MIN_LEVEL = 1;
	protected final int MAX_LEVEL = 5;
	private final String enchantmentName = "Fire Shield";
	
	public EnchantmentFireShield(int id, int weight) {
		super(id, weight, EnumWandElement.FIRE);
		this.setName("fireShield");
	}

	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int charge) {
		System.out.println("Fire Shield Cast");
		return 1;
	}
	
	public int getMinEnchantability(int level) {
		return 1; //TODO Implement actual minimum enchantability
	}
	
	public int getMaxEnchantability(int level) {
		return 50; //TODO Implement actual maximum enchantability
	}
	
	public String getTranslatedName(int level) {
		return this.enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + level);
	}

}
