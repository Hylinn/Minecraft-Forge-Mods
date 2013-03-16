package hylinn.minecraft.ElementalWands.item;

import net.minecraft.item.Item;

public enum EnumWandMaterial {
	WOOD   (10, 10),
	BONE   (20, 15),
	IRON   (30, 12),
	QUARTZ (60, 12),
	GOLD   (50, 20);
	
	private final int enchantability;
	private final int maxCharges;
	
	public Item customCraftingMaterial = null;
	
	private EnumWandMaterial(int maxCharges, int enchantability) {
		this.enchantability = enchantability;
		this.maxCharges = maxCharges;
	}
	
	public int getMaxCharges()
    {
        return this.maxCharges;
    }
	
	public int getEnchantability()
    {
        return this.enchantability;
    }
	
	public int getWandCraftingMaterial()
    {
        switch (this)
        {
            case WOOD:   return Item.stick.itemID;
            case BONE:   return Item.bone.itemID;
            case GOLD:   return Item.ingotGold.itemID;
            case IRON:   return Item.ingotIron.itemID;
            case QUARTZ: return Item.field_94583_ca.itemID; // field_94583_ca will probably change in the future.
            default:     return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
