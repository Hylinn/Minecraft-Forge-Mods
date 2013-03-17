package hylinn.minecraft.ElementalWands.item;

import java.util.Map;
import java.util.Map.Entry;

import hylinn.minecraft.ElementalWands.ElementalWands;
import hylinn.minecraft.ElementalWands.enchantment.ICastable;
import hylinn.minecraft.ElementalWands.event.WandCastEvent;
import hylinn.minecraft.ElementalWands.event.WandChargeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemWand extends Item {
	
	public final EnumWandMaterial material;
	public final EnumWandElement element;
	private final int MAX_ITEM_USE_DURATION = 72000;
	private final int NUM_OF_ANIMATION_ICONS = 3;
	
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
		
		int charge = this.getMaxItemUseDuration(itemStack) - itemInUseCount;

        WandCastEvent event = new WandCastEvent(player, itemStack, charge);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            return;
        
        charge = event.charge;

        itemStack.damageItem(this.castWandSpell(itemStack, world, player, charge), player);
        
//        world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F); //TODO Create and use wand random wand sounds.
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
	
	private int castFireSpell(ItemStack stack, World world, EntityLiving entity, int itemInUseDuration) {
		System.out.println("Fire Spell Cast");
		return 1;
	}
	
	private int castAirSpell(ItemStack stack, World world, EntityLiving entity, int itemInUseDuration) {
		System.out.println("Air Spell Cast");
		return 1;
	}
	
	private int castWaterSpell(ItemStack stack, World world, EntityLiving entity, int itemInUseDuration) {
		System.out.println("Water Spell Cast");
		return 1;
	}
	
	private int castEarthSpell(ItemStack stack, World world, EntityLiving entity, int itemInUseDuration) {
		System.out.println("Earth Spell Cast");
		return 1;
	}
	
	private int castArcaneSpell(ItemStack stack, World world, EntityLiving entity, int itemInUseDuration) {
		System.out.println("Arcane Spell Cast");
		return 1;
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
        			returnDamage = this.castAirSpell(stack, world, entity, itemInUseDuration);
        			break;
        		case WATER:
        			returnDamage = this.castWaterSpell(stack, world, entity, itemInUseDuration);
        			break;
        		case EARTH:
        			returnDamage = this.castEarthSpell(stack, world, entity, itemInUseDuration);
        			break;
        		case FIRE:
        			returnDamage = this.castFireSpell(stack, world, entity, itemInUseDuration);
        			break;
        		case ARCANE:
        			returnDamage = this.castArcaneSpell(stack, world, entity, itemInUseDuration);
        			break;
        	}
        }
        return returnDamage;
	}
}
