package hylinn.minecraft.ElementalWands.item;

import java.util.Map;
import java.util.Map.Entry;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.enchantment.ICastable;
import hylinn.minecraft.ElementalWands.event.WandCastEvent;
import hylinn.minecraft.ElementalWands.event.WandChargeEvent;
import hylinn.minecraft.ElementalWands.util.TargetHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemWand extends Item {
	
	public final EnumWandMaterial material;
	public final EnumWandElement element;
	private final int MAX_ITEM_USE_DURATION = 72000;
	private final int NUM_OF_ANIMATION_ICONS = 3;
	private final int baseSpellCost = 1;
	private final int minCastTime = 7; // in 1/20ths of a second;
	
    private Icon[] animationIcons = new Icon[NUM_OF_ANIMATION_ICONS];
	
	public ItemWand(int id, EnumWandMaterial material, EnumWandElement element) {
		super(id);
		
		// Constructor Configuration
		this.setMaxStackSize(1);
		this.setCreativeTab(ElementalWands.wandTab);
		this.setMaxDamage(material.getMaxCharges());
		this.material = material;
		this.element = element;
	}
	
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int itemInUseCount) {
		
		int itemInUseDuration = this.getMaxItemUseDuration(itemStack) - itemInUseCount;

        WandCastEvent event = new WandCastEvent(player, itemStack, itemInUseDuration);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            return;
        
        itemInUseDuration = event.charge;

        if (player.capabilities.isCreativeMode || itemInUseDuration >= minCastTime)
        	itemStack.damageItem(this.castWandSpell(itemStack, world, player, itemInUseDuration), player);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World wWorld, EntityPlayer player) {
		
		WandChargeEvent event = new WandChargeEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            return event.result;   
        
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        
	    return itemStack;
	}
	
	public int getItemEnchantability() {
		return this.material.getEnchantability();
	}
	
	public EnumAction getItemUseAction(ItemStack itemStack) {
        return ElementalWands.actionWand;
    }
	
	public boolean getIsRepairable(ItemStack item, ItemStack resource) {
		return this.material.getMaterialID() == resource.itemID ? true : super.getIsRepairable(item, resource);
    }
	
	public void func_94581_a(IconRegister iconRegister)
    {
		this.iconIndex = iconRegister.func_94245_a(this.getIconPath());
        for (int i = 0; i < this.animationIcons.length; ++i)
        {
            this.animationIcons[i] = iconRegister.func_94245_a(this.getIconPath(i));
        }
    }
	
	public Icon getIcon(ItemStack itemHeld, int renderPass, EntityPlayer player, ItemStack itemInUse, int itemInUseCount) {
		float charge = (float) (itemHeld.getMaxItemUseDuration() - itemInUseCount) / 20.0F;
		return itemInUse != null && charge > 1 ? this.animationIcons[(int) Math.min(NUM_OF_ANIMATION_ICONS - 1, (charge - 1) / 2)] : this.iconIndex;
	}
	
	public int getMaxItemUseDuration(ItemStack itemStack) {
        return MAX_ITEM_USE_DURATION;
    } 
	
	public boolean isFull3D() {
        return true;
    }

	public Object getWandMaterial() {
		return material.getMaterial();
	}

	public Object getElementMaterial() {
		return element.getMaterial();
	}
	
	public String getIconPath() {
		return ElementalWands.modName + ":wand" + this.element.toString() + this.material.toString();
	}
	
	public String getIconPath(int animation) {
		return ElementalWands.modName + ":wand" + this.element.toString() + this.material.toString() + animation;
	}
	
	private int castFireSpell(ItemStack stack, World world, EntityLiving entity) {
		MovingObjectPosition target = TargetHelper.getMovingObjectPositionFromEntity(world, entity, 5, true);
		
		if (target != null && entity instanceof EntityPlayer) {
			// TODO Not use Flint and Steel's on use function to set blocks on fire.
			Item.itemsList[Item.flintAndSteel.itemID].onItemUse(new ItemStack(0, 0, 0), (EntityPlayer) entity, world, target.blockX, target.blockY, target.blockZ, target.sideHit, 0F, 0F, 0F);
			return baseSpellCost;
		}
		return 0;
	}
	
	private int castAirSpell(ItemStack stack, World world, EntityLiving entity) {
		
		return baseSpellCost;
	}
	
	private int castWaterSpell(ItemStack stack, World world, EntityLiving entity) {
		MovingObjectPosition target = TargetHelper.getMovingObjectPositionFromEntity(world, entity, 5, true);
		
		if (target != null) {
			int blockID = world.getBlockId(target.blockX, target.blockY, target.blockZ);
			if (blockID == Block.waterStill.blockID || blockID == Block.waterMoving.blockID) {
				world.setBlockAndMetadataWithNotify(target.blockX, target.blockY, target.blockZ, Block.ice.blockID, 0, 3);
				return baseSpellCost;
			}
			else if (blockID == Block.lavaStill.blockID || blockID == Block.lavaMoving.blockID) {
				world.setBlockAndMetadataWithNotify(target.blockX, target.blockY, target.blockZ, Block.cobblestone.blockID, 0, 3);
				return baseSpellCost;
			}
			else if (blockID == Block.snow.blockID && world.getBlockMetadata(target.blockX, target.blockY, target.blockZ) < 6) {
				int metadata = world.getBlockMetadata(target.blockX, target.blockY, target.blockZ);
				world.setBlockMetadataWithNotify(target.blockX, target.blockY, target.blockZ, metadata + 1, 3);
				return baseSpellCost;
			}
			else if (blockID == Block.snow.blockID) {
				world.setBlockAndMetadataWithNotify(target.blockX, target.blockY, target.blockZ, Block.blockSnow.blockID, 0, 3);
				return baseSpellCost;
			}
			else if (world.isAirBlock(target.blockX, target.blockY + 1, target.blockZ) && Block.blocksList[blockID].isOpaqueCube()){
				world.setBlockAndMetadataWithNotify(target.blockX, target.blockY + 1, target.blockZ, Block.snow.blockID, 0, 3);
				return baseSpellCost;
			}
		}
		return 0;
	}
	
	private int castEarthSpell(ItemStack stack, World world, EntityLiving entity) {
		MovingObjectPosition target = TargetHelper.getMovingObjectPositionFromEntity(world, entity, 5, false);
		
		if (target != null && world.getBlockId(target.blockX, target.blockY, target.blockZ) == Block.dirt.blockID) {
			world.setBlockAndMetadataWithNotify(target.blockX, target.blockY, target.blockZ, Block.grass.blockID, 0, 3);
			return baseSpellCost;
		}
		return 0;
	}
	
	private int castArcaneSpell(ItemStack stack, World world, EntityLiving entity) {
		MovingObjectPosition target = TargetHelper.getMovingObjectPositionFromEntity(world, entity, 5, false);
		
		if (target != null) {
			int metadata = Block.torchWood.onBlockPlaced(world, target.blockX, target.blockY, target.blockZ, target.sideHit, 0, 0, 0, 0);
			if (metadata != 0) {
				//world.setBlockAndMetadataWithNotify(target.blockX, target.blockY, target.blockZ, Block.torchWood.blockID, metadata, 3);
				return baseSpellCost;
			}
		}
		return 0;
	}
	
	public int castWandSpell(ItemStack stack, World world, EntityLiving entity, int itemInUseDuration) {
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
		int returnDamage = 0;
		        
        if (enchantments.size() > 0) {
        	for (Entry<Integer, Integer> enchantmentEntry : enchantments.entrySet()) {
        		Enchantment enchantment = Enchantment.enchantmentsList[enchantmentEntry.getKey()];
        		if (enchantment instanceof ICastable)
        			returnDamage += ((ICastable) enchantment).cast(stack, world, entity, enchantmentEntry.getValue(), itemInUseDuration);
        	}
        }
        else {
        	switch(element) {
        		case AIR:
        			returnDamage = this.castAirSpell(stack, world, entity);
        			break;
        		case WATER:
        			returnDamage = this.castWaterSpell(stack, world, entity);
        			break;
        		case EARTH:
        			returnDamage = this.castEarthSpell(stack, world, entity);
        			break;
        		case FIRE:
        			returnDamage = this.castFireSpell(stack, world, entity);
        			break;
        		case ARCANE:
        			returnDamage = this.castArcaneSpell(stack, world, entity);
        			break;
        	}
        }
        return returnDamage;
	}
}
