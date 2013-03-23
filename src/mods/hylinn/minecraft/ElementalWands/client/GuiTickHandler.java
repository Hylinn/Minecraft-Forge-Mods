package hylinn.minecraft.ElementalWands.client;

import hylinn.minecraft.ElementalWands.client.gui.inventory.ElementalWandsGuiContainerCreative;
import hylinn.minecraft.ElementalWands.client.gui.inventory.ElementalWandsGuiInventory;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class GuiTickHandler implements ITickHandler {

	private Minecraft minecraft;
    private final EnumSet tickTypes;
	
	public GuiTickHandler() {
		
		minecraft = FMLClientHandler.instance().getClient();
		tickTypes = EnumSet.of(TickType.CLIENT);
		
		//KeyBinding[] keyInventory = {minecraft.gameSettings.keyBindInventory};
		//KeyBindingRegistry.registerKeyBinding(new KeyInventoryHandler(keyInventory, new boolean[]{false}));
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		// Inject InvetoryGUI
		if (minecraft.currentScreen instanceof GuiInventory) {
			//minecraft.displayGuiScreen(new ElementalWandsGuiInventory(minecraft.thePlayer));
		}
		else if (minecraft.currentScreen instanceof GuiContainerCreative) {
			//minecraft.displayGuiScreen(new ElementalWandsGuiContainerCreative(minecraft.thePlayer));
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return tickTypes;
	}

	@Override
	public String getLabel() {
		return "Elemental Wands";
	}
}
