package hylinn.minecraft.ElementalWands.server;

import java.util.EnumSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class WorldTickHandler implements ITickHandler {
	
	public WorldTickHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		for (Object object : tickData) {
			if (object instanceof WorldServer) {
				WorldServer world = (WorldServer) object;
				
				for (Object entity : world.loadedEntityList) {
					if (entity instanceof EntityLiving) {
						System.out.println(((EntityLiving) entity).getEntityName() + ((EntityLiving) entity).entityId);
					}
				}
			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.WORLD);
	}

	@Override
	public String getLabel() {
		return "WorldTickHandler";
	}

}
