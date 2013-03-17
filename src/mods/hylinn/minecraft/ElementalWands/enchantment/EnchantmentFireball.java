package hylinn.minecraft.ElementalWands.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;

public class EnchantmentFireball extends EnchantmentWand {

	public EnchantmentFireball(int id, int weight) {
		super(id, weight, EnumWandElement.FIRE);
		this.setName("fireball");
	}

	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration) {
		System.out.println(this.getTranslatedName(level) + " cast after charging for " + itemInUseDuration);
		return 1;
	}
}
