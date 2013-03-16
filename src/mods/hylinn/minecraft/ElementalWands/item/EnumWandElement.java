package hylinn.minecraft.ElementalWands.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumWandElement {
	FIRE   (Item.blazeRod),
	EARTH  (Item.emerald),
	WATER  (Item.ghastTear),
	AIR    (Item.enderPearl),
	ARCANE (Item.lightStoneDust);
	
	private final Object material;
	
	private EnumWandElement(Item material) {
		this.material = material;
	}
	
	private EnumWandElement(Block material) {
		this.material = material;
	}
	
	public Object getMaterial() {
		return material;
	}
	
	public int getMaterialID() {
		return material instanceof Item ? ((Item) material).itemID : ((Block) material).blockID;
	}
}
