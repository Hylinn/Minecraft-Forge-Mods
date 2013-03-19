package hylinn.minecraft.ElementalWands.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.entity.projectile.EntityEnchantmentFireball;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;

public class EnchantmentFireball extends EnchantmentWand {

	public EnchantmentFireball(int id, int weight) {
		super(id, weight, EnumWandElement.FIRE);
		this.setName("fireball");
	}

	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration) {
		float seconds = (float) itemInUseDuration / 20.0F;
		if (ElementalWands.DEBUG) System.out.println(entity.getEntityName() + " cast " + this.getTranslatedName(level) + " after charging for " + seconds + " seconds");
		
		if (!world.isRemote) {
			Vec3 look = entity.getLookVec();
			EntityEnchantmentFireball fireball = new EntityEnchantmentFireball(world, entity, level, itemInUseDuration);
			fireball.setPosition(entity.posX + (look.xCoord * 2), entity.posY + (entity.height * 0.9) + (look.yCoord * 2) - entity.yOffset, entity.posZ + (look.zCoord * 2));
			fireball.accelerationX = look.xCoord * 0.1;
			fireball.accelerationY = look.yCoord * 0.1;
			fireball.accelerationZ = look.zCoord * 0.1;
			world.spawnEntityInWorld(fireball);
		}

		return getCastChargeCost(itemInUseDuration);
	}
}
