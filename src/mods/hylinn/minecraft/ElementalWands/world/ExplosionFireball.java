package hylinn.minecraft.ElementalWands.world;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ExplosionFireball extends Explosion {

	private final World world;
	private int field_77289_h = 16;
	private final double fallOffRate = 0.5D;
    public float radius;
    public float power;

	private Map<EntityPlayer, Vec3> field_77288_k = new HashMap<EntityPlayer, Vec3>();
	
	public ExplosionFireball(World world, Entity exploder, double x, double y, double z, float radius, float power) {
		super(world, exploder, x, y, z, radius);
		this.world = world;
		this.radius = radius;
		this.power = power;
		this.isFlaming = true;
		this.isSmoking = false;
	}
	
	public void doExplosionA()
    {
        HashSet<ChunkPosition> hashset = new HashSet<ChunkPosition>();
        int i;
        int j;
        int k;
        double d0;
        double d1;
        double d2;

        for (i = 0; i < this.field_77289_h; ++i)
        {
            for (j = 0; j < this.field_77289_h; ++j)
            {
                for (k = 0; k < this.field_77289_h; ++k)
                {
                    if (i == 0 || i == this.field_77289_h - 1 || j == 0 || j == this.field_77289_h - 1 || k == 0 || k == this.field_77289_h - 1)
                    {
                        double d3 = (double)((float)i / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F); // i/29
                        double d4 = (double)((float)j / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F); // j/29
                        double d5 = (double)((float)k / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F); // k/29
                        double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5); // Magnitude
                        d3 /= d6; // normalize i/29
                        d4 /= d6; // normalize j/29
                        d5 /= d6; // normalize k/29
                        float f1 = this.radius * (0.7F + this.world.rand.nextFloat() * 0.6F); // modified explosionSize
                        d0 = this.explosionX;
                        d1 = this.explosionY;
                        d2 = this.explosionZ;

                        for (float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F) // while modified explosionSize is decremented by .225 each iteration
                        {
                            int l = MathHelper.floor_double(d0); // d0 rounded down
                            int i1 = MathHelper.floor_double(d1); // d2 rounded down
                            int j1 = MathHelper.floor_double(d2); // d3 rounded down
                            int k1 = this.world.getBlockId(l, i1, j1); // block at (d0, d1, d2)

                            if (k1 > 0) // if block isn't air
                            {
                                Block block = Block.blocksList[k1];
                                float f3 = this.exploder != null ? this.exploder.func_82146_a(this, this.world, l, i1, j1, block) : block.getExplosionResistance(this.exploder, world, l, i1, j1, explosionX, explosionY, explosionZ);
                                f1 -= (f3 + 0.3F) * f2; // subtract (block resistance + C1) * C2 from remaining explosionSize
                            }

                            if (f1 > 0.0F && (this.exploder == null || this.exploder.func_96091_a(this, this.world, l, i1, j1, k1, f1)))
                            {
                                hashset.add(new ChunkPosition(l, i1, j1)); // Add block to affectedBlocks if explosion still has strength.
                            }

                            d0 += d3 * (double)f2; // Move to new block 
                            d1 += d4 * (double)f2;
                            d2 += d5 * (double)f2;
                        }
                    }
                }
            }
        }

        this.affectedBlockPositions.addAll(hashset);
        i = MathHelper.floor_double(this.explosionX - (double)this.radius - 1.0D);
        j = MathHelper.floor_double(this.explosionX + (double)this.radius + 1.0D);
        k = MathHelper.floor_double(this.explosionY - (double)this.radius - 1.0D);
        int l1 = MathHelper.floor_double(this.explosionY + (double)this.radius + 1.0D);
        int i2 = MathHelper.floor_double(this.explosionZ - (double)this.radius - 1.0D);
        int j2 = MathHelper.floor_double(this.explosionZ + (double)this.radius + 1.0D);
        List list = this.world.getEntitiesWithinAABBExcludingEntity(this.exploder, AxisAlignedBB.getAABBPool().getAABB((double)i, (double)k, (double)i2, (double)j, (double)l1, (double)j2));
        Vec3 vec3 = this.world.getWorldVec3Pool().getVecFromPool(this.explosionX, this.explosionY, this.explosionZ);

		for (int k2 = 0; k2 < list.size(); ++k2) {
			
			Entity entity = (Entity) list.get(k2);
			double distanceDamageModifier = fallOffRate * (entity.getDistance(this.explosionX, this.explosionY, this.explosionZ) / (double) this.radius);
			
			//System.out.println(entity.getEntityName() + entity.entityId + " " + entity.chunkCoordX + ", " + entity.chunkCoordY + ", " + entity.chunkCoordZ);
			//System.out.println(entity.getEntityName() + entity.entityId + " " + entity.getDistance(this.explosionX, this.explosionY, this.explosionZ));
			
			if (distanceDamageModifier <= 1.0D && !entity.isImmuneToFire()) {
				d0 = entity.posX - this.explosionX;
				d1 = entity.posY + (double) entity.getEyeHeight() - this.explosionY;
				d2 = entity.posZ - this.explosionZ;
				double d8 = (double) MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);

				if (d8 != 0.0D) {
					d0 /= d8;
					d1 /= d8;
					d2 /= d8;
					
					double cover = (double) this.world.getBlockDensity(vec3, entity.boundingBox);
					double reductionCoefficient = (1.0D - distanceDamageModifier) * cover;
					int reducedDamage = EnchantmentProtection.func_92093_a(entity, (int) (this.power - (this.power * reductionCoefficient)));
					
					//System.out.println(entity.getEntityName()+ entity.entityId + " " + (int) (this.power - (this.power * reductionCoefficient)) + " " + reductionCoefficient);
					
					entity.attackEntityFrom(DamageSource.func_94539_a(this), reducedDamage);
					entity.setFire((int) (this.power - (this.power * reductionCoefficient)));

					if (entity instanceof EntityPlayer) {
						this.field_77288_k.put((EntityPlayer) entity, this.world.getWorldVec3Pool().getVecFromPool(d0 * reductionCoefficient, d1 * reductionCoefficient, d2 * reductionCoefficient));
					}
				}
			}
		}
    }
}
