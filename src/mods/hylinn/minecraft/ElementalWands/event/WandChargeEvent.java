package hylinn.minecraft.ElementalWands.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class WandChargeEvent extends PlayerEvent {

	public ItemStack result;
	
	public WandChargeEvent(EntityPlayer player, ItemStack result) {
		
		super(player);
		this.result = result;
	}

}
