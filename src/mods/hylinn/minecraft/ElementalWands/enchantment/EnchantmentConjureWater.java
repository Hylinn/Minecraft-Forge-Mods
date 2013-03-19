package hylinn.minecraft.ElementalWands.enchantment;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import hylinn.minecraft.ElementalWands.util.TargetHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EnchantmentConjureWater extends EnchantmentWand {

	private int waterType = Block.waterMoving.blockID;
	private float rangePerLevel = 4.0F;
	
	public EnchantmentConjureWater(int id, int weight) {
		super(id, weight, EnumWandElement.WATER);
		this.setName("conjureWater");
	}

	public int cast(ItemStack stack, World world, EntityLiving entity, int level, int itemInUseDuration) {
		float seconds = (float) itemInUseDuration / 20.0F; 
		if (ElementalWands.DEBUG) System.out.println(entity.getEntityName() + " cast " + this.getTranslatedName(level) + " after charging for " + seconds + " seconds");
		
		if (!world.isRemote) {
			MovingObjectPosition target = TargetHelper.getMovingObjectPositionFromEntity(world, entity, level * rangePerLevel, false);
			
			if (target != null) {
				switch (target.sideHit) {
					case 0:
						target.blockY -= 1;
						break;
					case 1:
						target.blockY += 1;
						break;
					case 2:
						target.blockZ -= 1;
						break;
					case 3: 
						target.blockZ += 1;
						break;
					case 4:
						target.blockX -= 1;
						break;
					case 5: 
						target.blockX += 1;
						break;
				}
				conjureWater(world, seconds >= 1.0F ? (int) Math.min(3, (seconds + 1) / 2) : 0, target.blockX, target.blockY, target.blockZ);
			}
			else if (entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode) {
				Vec3 targetAir = TargetHelper.getPositionAtDistanceFromEntity(world, entity, level * rangePerLevel);
				conjureWater(world, seconds >= 1.0F ? (int) Math.min(3, (seconds + 1) / 2) : 0, (int) targetAir.xCoord, (int) targetAir.yCoord, (int) targetAir.zCoord);
			}
		}
		return getCastChargeCost(itemInUseDuration);
	}

	private void conjureWater(World world, int castStage, int centerX, int centerY, int centerZ) {	
		if (world.provider.isHellWorld) {
			world.playSoundEffect(centerX + 0.5D, centerY + 0.5D, centerZ + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

            for (int i = 0; i < (castStage + 1) * 4; i++)
            {
            	double particleX = (double)centerX + Math.random();
            	double particleY = (double)centerY + Math.random();
            	double particleZ = (double)centerZ + Math.random();
            	if (ElementalWands.DEBUG) System.out.println(particleX + ", " + particleY + ", " + particleZ);
            	world.spawnParticle("largesmoke", particleX, particleY, particleZ, 0.0D, 0.0D, 0.0D);
            }
		}
		else {
			int direction = 1;
			for (int i = 0; i <= castStage; i++) {
				if (!world.isAirBlock(centerX, centerY + (i * direction), centerZ) && world.getBlockMaterial(centerX, centerY, centerZ).isSolid() && i > 1)
					break;
				else if (i <= 1)
					direction *= -1;
				world.setBlockAndMetadataWithNotify(centerX, centerY + (i * direction), centerZ, waterType, 0, 3);
			}
		}
	}	
}
