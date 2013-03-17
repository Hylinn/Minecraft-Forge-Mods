package hylinn.minecraft.ElementalWands.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;

public class EnchantmentFireball extends EnchantmentWand implements ICastable{

	protected final int MIN_LEVEL = 1;
	protected final int MAX_LEVEL = 5;
	
	public EnchantmentFireball(int id, int weight) {
		super(id, weight, EnumWandElement.FIRE);
	}

	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int charge) {
		return 1;// TODO Auto-generated method stub
	}
}
