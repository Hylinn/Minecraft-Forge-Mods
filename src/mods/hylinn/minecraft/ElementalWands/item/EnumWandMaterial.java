package hylinn.minecraft.ElementalWands.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumWandMaterial {
	WOOD   (10, 10, Item.stick, "Wood"),
	BONE   (20, 15, Item.bone, "Bone"),
	IRON   (30, 12, Item.ingotIron, "Iron"),
	QUARTZ (60, 12, Item.field_94583_ca, "Quartz"),
	GOLD   (50, 20, Item.ingotGold, "Gold");
	
	private final int enchantability;
	private final int maxCharges;
	private final Object material;
	private final String name;
	
	private EnumWandMaterial(int maxCharges, int enchantability, Item material, String name) {
		this.enchantability = enchantability;
		this.maxCharges = maxCharges;
		this.material = material;
		this.name = name;
	}
	
	private EnumWandMaterial(int maxCharges, int enchantability, Block material, String name) {
		this.enchantability = enchantability;
		this.maxCharges = maxCharges;
		this.material = material;
		this.name = name;
	}
	
	public int getMaxCharges()
    {
        return this.maxCharges;
    }
	
	public int getEnchantability()
    {
        return this.enchantability;
    }
	
	public Object getMaterial() {
		return this.material;
	}
	
	public int getMaterialID() {
		return material instanceof Item ? ((Item) material).itemID : ((Block) material).blockID;
	}
	
	public String toString() {
		return this.name;
	}
}
