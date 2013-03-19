package hylinn.minecraft.ElementalWands.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TargetHelper {
	public static Vec3 getPositionAtDistanceFromEntity(World world, Entity entity, double distance) {
		float f1 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch);
        float f2 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw);
        
        double entityX = entity.prevPosX + (entity.posX - entity.prevPosX);
        double entityY = entity.prevPosY + (entity.posY - entity.prevPosY) + (( double)entity.height * 0.9D) - (double)entity.yOffset;
        double entityZ = entity.prevPosZ + (entity.posZ - entity.prevPosZ);
        Vec3 entityLocation = world.getWorldVec3Pool().getVecFromPool(entityX, entityY, entityZ);
        
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        
        Vec3 distanceFromEntity = entityLocation.addVector((double)f7 * distance, (double)f6 * distance, (double)f8 * distance);
		
		return distanceFromEntity;
	}
	
	public static MovingObjectPosition getMovingObjectPositionFromEntity(World world, Entity entity, double distance, boolean flag) {
        double entityX = entity.prevPosX + (entity.posX - entity.prevPosX);
        double entityY = entity.prevPosY + (entity.posY - entity.prevPosY) + (( double)entity.height * 0.9D) - (double)entity.yOffset;
        double entityZ = entity.prevPosZ + (entity.posZ - entity.prevPosZ);
        
        Vec3 entityLocation = world.getWorldVec3Pool().getVecFromPool(entityX, entityY, entityZ);      
        Vec3 distanceFromEntity = getPositionAtDistanceFromEntity(world, entity, distance);
        return world.rayTraceBlocks_do(entityLocation, distanceFromEntity, flag);
    }
}
