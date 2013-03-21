package hylinn.minecraft.ElementalWands.enchantment;

import java.util.Random;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.item.EnumWandElement;
import hylinn.minecraft.ElementalWands.util.RandomName;
import hylinn.minecraft.ElementalWands.util.TargetHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EnchantmentSummonSnowGolem extends EnchantmentWand {

	private float rangePerLevel = 4.0F;
	private int golemsPerStage = 2;
	private Random rand = new Random();
	private final double spawnVariance = 0.5D;
	
	public EnchantmentSummonSnowGolem(int id, int weight) {
		super(id, weight, EnumWandElement.WATER);
		this.setName("summonSnowGolem");
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
				summonGolems(world, seconds >= 1.0F ? (int) Math.min(3, (seconds + 1) / 2) : 0, target.blockX, target.blockY, target.blockZ);
			}
			else if (entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode) {
				Vec3 targetAir = TargetHelper.getPositionAtDistanceFromEntity(world, entity, level * rangePerLevel);
				summonGolems(world, seconds >= 1.0F ? (int) Math.min(3, (seconds + 1) / 2) : 0, targetAir.xCoord, targetAir.yCoord, targetAir.zCoord);
			}
		}
		return getCastChargeCost(itemInUseDuration);
	}
	
	private void summonGolems(World world, int castStage, double centerX, double centerY, double centerZ) {
		
		for (int i = 0; i <= castStage * golemsPerStage; i++) {
			EntitySnowman snowGolem = new EntitySnowman(world);
			double newX = centerX + rand.nextDouble() - spawnVariance;
			double newY = centerY;
			double newZ = centerZ + rand.nextFloat() - spawnVariance;
			Block newSpawn = Block.blocksList[world.getBlockId((int) newX, (int) newY, (int) newZ)];
			
			if (newSpawn != null && newSpawn.isOpaqueCube()) {
				newX = centerX;
				newY = centerY;
				newZ = centerZ;
			}
			snowGolem.setPosition(newX, newY, newZ);
			snowGolem.func_94058_c(RandomName.nextName());
			world.spawnEntityInWorld(snowGolem);
		}
	}
}
