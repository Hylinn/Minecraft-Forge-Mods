package hylinn.minecraft.ElementalWands.entity.projectile;

import hylinn.minecraft.ElementalWands.world.ExplosionFireball;


import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityEnchantmentFireball extends EntityFireball {
	
	protected final int level;
	protected final float seconds;
	public Entity shootingEntity;
	private int directDamageModifier = 2;
	private int fireDurationModifier = 2;
	private float powerModifier = 2;
	private final DamageSource source;
	
	public EntityEnchantmentFireball(World world, Entity entity, int level, int itemInUseDuration) {
		super(world);
		this.seconds = (float) itemInUseDuration / 20.0F;
		this.level = level;
		this.shootingEntity = entity;
		this.source = DamageSource.causeFireballDamage(this, this.shootingEntity);
		
		this.setSize(0.3125F, 0.3125F);
	}

	@Override
	protected void onImpact(MovingObjectPosition target)
    {
        if (!this.worldObj.isRemote)
        {
        	float explosionRadius = seconds >= 1.0F ? Math.min((seconds + 1) / 2, 3) : 0;
        	float explosionPower = powerModifier * level;
        	int directDamage = directDamageModifier * level;
        	int fireDuration = fireDurationModifier * level;
        	
			if (target.entityHit != null && !target.entityHit.isImmuneToFire() && target.entityHit.attackEntityFrom(source, directDamage))
				target.entityHit.setFire(fireDuration);
  
            this.newExplosion(this, this.posX, this.posY, this.posZ, explosionRadius, explosionPower);
            this.setDead();
        }
    }
	
	public Explosion newExplosion(Entity exploder, double x, double y, double z, float radius, float power)
    {
        Explosion explosion = new ExplosionFireball(this.worldObj, exploder, x, y, z, radius, power);
        explosion.doExplosionA();
        explosion.doExplosionB(true);
        return explosion;
    }
}
