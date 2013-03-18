package hylinn.minecraft.ElementalWands.util;

public enum EnumSideHit {
	TOP   (1),
	BOTTOM(0),
	EAST  (2), 
	WEST  (3), 
	NORTH (4), 
	SOUTH (5);
	
	public final int value;
	
	private EnumSideHit(int value) {
		this.value = value;
	}
}
