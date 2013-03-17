package hylinn.minecraft.ElementalWands.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ICastable {
	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration);
}
