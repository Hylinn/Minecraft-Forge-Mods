package hylinn.minecraft.ElementalWands.enchantment.effect;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;

public class EnchantmentEffect extends PotionEffect {
	
	public EnchantmentEffect(int par1, int par2) {
		super(par1, par2);
		// TODO Auto-generated constructor stub
	}

	public EnchantmentEffect(int par1, int par2, int par3) {
		super(par1, par2, par3);
		// TODO Auto-generated constructor stub
	}

	public EnchantmentEffect(int par1, int par2, int par3, boolean par4) {
		super(par1, par2, par3, par4);
		// TODO Auto-generated constructor stub
	}

	public EnchantmentEffect(PotionEffect par1PotionEffect) {
		super(par1PotionEffect);
		// TODO Auto-generated constructor stub
	}

	public NBTTagCompound writeCustomPotionEffectToNBT(NBTTagCompound compound) {
		compound.setByte("Id", (byte) this.getPotionID());
		compound.setByte("Amplifier", (byte) this.getAmplifier());
		compound.setInteger("Duration", this.getDuration());
		return compound;
	}

}
