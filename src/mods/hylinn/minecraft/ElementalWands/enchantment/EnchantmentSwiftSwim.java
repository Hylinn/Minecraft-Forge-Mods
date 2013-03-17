package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EnchantmentSwiftSwim extends EnchantmentWand implements ICastable {

	protected final int MIN_LEVEL = 1;
	protected final int MAX_LEVEL = 5;
	private final String enchantmentName = "Swift Swim";
	
	public EnchantmentSwiftSwim(int id, int weight) {
		super(id, weight, EnumWandElement.WATER);
		this.setName("swiftSwim");
	}

	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int charge) {
		System.out.println("Swift Swim Cast");
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
