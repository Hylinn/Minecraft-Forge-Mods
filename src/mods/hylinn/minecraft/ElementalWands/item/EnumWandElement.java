package hylinn.minecraft.ElementalWands.item;

import net.minecraft.item.Item;

public enum EnumWandElement {
	FIRE,
	EARTH,
	WATER,
	AIR,
	ARCANE;
	
	public Item customCraftingMaterial = null;
	
	public int getElementCraftingMaterial()
    {
        switch (this)
        {
            case FIRE:   return Item.blazeRod.itemID;
            case EARTH:  return Item.emerald.itemID;
            case WATER:  return Item.ghastTear.itemID;
            case AIR:    return Item.enderPearl.itemID;
            case ARCANE: return Item.lightStoneDust.itemID;
            default:     return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
