package hylinn.minecraft.ElementalWands.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class WandCastEvent extends PlayerEvent {
	
	public final ItemStack wand;
    public int charge;

	public WandCastEvent(EntityPlayer player, ItemStack wand, int charge) {
		
		super(player);
		this.wand = wand;
        this.charge = charge;
	}

}
