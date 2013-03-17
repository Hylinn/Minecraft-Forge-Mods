package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantmentFireShield extends EnchantmentWand  {
	
	public EnchantmentFireShield(int id, int weight) {
		super(id, weight, EnumWandElement.FIRE);
		this.setName("fireShield");
	}
	
	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration) {
		System.out.println(this.getTranslatedName(level) + " cast after charging for " + itemInUseDuration);
		return 1;
	}
}
