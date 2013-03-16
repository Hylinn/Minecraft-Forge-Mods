package hylinn.minecraft.ElementalWands.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumWandElement {
	FIRE   (Item.blazeRod, "Fire"),
	EARTH  (Item.emerald, "Earth"),
	WATER  (Item.ghastTear, "Water"),
	AIR    (Item.enderPearl, "Air"),
	ARCANE (Item.lightStoneDust, "Arcane");
	
	private final Object material;
	private final String name;
	
	private EnumWandElement(Item material, String name) {
		this.material = material;
		this.name = name;
	}
	
	private EnumWandElement(Block material, String name) {
		this.material = material;
		this.name = name;
	}
	
	public Object getMaterial() {
		return material;
	}
	
	public int getMaterialID() {
		return material instanceof Item ? ((Item) material).itemID : ((Block) material).blockID;
	}
	
	public String toString() {
		return this.name;
	}
}
