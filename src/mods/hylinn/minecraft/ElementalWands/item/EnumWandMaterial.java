package hylinn.minecraft.ElementalWands.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumWandMaterial {
	WOOD   (10, 14, Item.stick, "Wood"),
	BONE   (15, 17, Item.bone, "Bone"),
	IRON   (40, 15, Item.ingotIron, "Iron"),
	QUARTZ (75, 10, Item.field_94583_ca, "Quartz"),
	GOLD   (50, 22, Item.ingotGold, "Gold");
	
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
