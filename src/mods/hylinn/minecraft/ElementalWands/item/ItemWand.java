package hylinn.minecraft.ElementalWands.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWand extends Item {
	
	private final EnumWandMaterial material;
	private final EnumWandElement element;
	
	public ItemWand(int id, EnumWandMaterial material, EnumWandElement element) {
		super(id);
		
		// Constructor Configuration
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxDamage(10); //TODO Set actual max uses based on material. Look at ItemSword for help.
		this.material = material;
		this.element = element;
	}
	
	@SideOnly(Side.CLIENT)
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("ElementalWands:blazerod"); //TODO Set ItemWand texture to something dependent upon material and element.
	}
	
	public boolean getIsRepairable(ItemStack item, ItemStack resource)
    {
        return true; //TODO Implement repair check. Look at ItemSword for help.
    }
	
	public ItemStack onItemRightClick(ItemStack itemStack, World wWorld, EntityPlayer player)
    {
		//TODO Handle the act of right clicking a wand. Look at ItemSword and ItemBow for help. Also make sure to increase itemDamage with each use.
        //player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

}
