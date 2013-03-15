package hylinn.minecraft.ElementalWands.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemWand extends Item {
	
	private final EnumWandMaterial material;
	private final EnumWandElement element;
	
	public ItemWand(int id, EnumWandMaterial material, EnumWandElement element) {
		super(id);
		
		// Constructor Configuration
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
		this.material = material;
		this.element = element;
	}
	
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.func_94245_a("ElementalWands:blazerod");
	}

}
