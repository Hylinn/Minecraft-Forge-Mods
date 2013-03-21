Minecraft-Forge-Mods
====================
The following are all of the mods contained in this repository.
* <a href="#elemental-wands">Elemental Wands</a> (0.0.2)
* <a href="#mob-collars">Mob Collars</a> (Planned)

##Elemental Wands
* <a href="#description">Description</a>
* <a href="#recipes">Recipes</a>
* <a href="#wands">Wands</a>
  * <a href="#air">Air</a>
  * <a href="#arcane">Arcane</a>
  * <a href="#earth">Earth</a>
  * <a href="#fire">Fire</a>
  * <a href="#water">Water</a>
* <a href="#spells">Spells</a>
  * <a href="#air-1">Air</a>
  * <a href="#arcane-1">Arcane</a>
  * <a href="#earth-1">Earth</a>
  * <a href="#fire-1">Fire</a>
  * <a href="#water-1">Water</a>

  ###Description
Elemental Wands adds wands for the five elements (Fire, Earth, Air, Water, and Arcane). Each wand can be made out of one of five materials (Wood, Bone, Iron, Nether Quartz, and Gold) and can be enchanted with spells at any enchanting table.

  ###Recipes
  Each recipe requires two of the base material and one of the elemental material to be made.
  * *Air* - Ender pearl
  * *Arcane* - Glowstone dust
  * *Earth* - Emerald
  * *Fire* - Blaze rod
  * *Water* - Ghast tear
  
  Each base material has different properties as well. The base material determines the number of charges a wand has and the overall enchantability of the wand.
  * *Wood*  
  Enchantability - ?  
  Charges - ?
  * *Bone*  
  Enchantability - ?  
  Charges - ?
  * *Iron*  
  Enchantability - ?  
  Charges - ?
  * *Nether Quartz*  
  Enchantability - ?  
  Charges - ?
  * *Gold*  
  Enchantability - ?  
  Charges - ?
  
  ###Wands
  Each newly created wand has a base spell it can cast depending upon the wand's element. These spells use no charges and are not replaced when the wand is enchanted with a stronger spell. Each wand's base spell can be cast by left-clicking when it is equipped.  
  
  To enchant a wand with a stronger spell, one needs to visit an enchanting table. Each wand can only be enchanted with one spell and the spell will only be of the wand's element.

  In order to repair a damaged wand, one needs to use the base material of the wand (not the elemental material) at any anvil. If a wand breaks, any enchantment on it is also lost.

  ####Air
  *Elemental Material* - Ender pearl  
  *Base Spell (Wind Jump)* - Propels the caster forward as though they performed a sprinting jump. Can be used while stationary and when low hunger would not permit running. The movement caused by casting Wind Jump does not consume hunger.   
  *Spells* - <a href="#gust">Gust</a>, <a href="#lightning">Lightning</a>, <a href="#safe-fall">Safe Fall</a>, <a href="#vortex">Vortex</a>, <a href="#wind-shield">Wind Shield</a>
  
  ####Arcane
  *Elemental Material* - Glowstone dust   
  *Base Spell (Mage Hand)* - Casting performs the right click action on target block up to 10 blocks away. When used on a monster or player will knock the target back as though it had been hit by a sword.    
  *Spells* - <a href="#arcane-shield">Arcane Shield</a>, <a href="#dispel">Dispel</a>, <a href="#light">Light</a>, <a href="#magic-missile">Magic Missile</a>, <a href="#toughness">Toughness</a>
  
  ####Earth
  *Elemental Material* - Emerald  
  *Base Spell (Move Earth)* - Casting will pull the target block towards the direction of the targeted face a distance of one block. This spell can only be used on dirt, grass, gravel, netherrack, sand, and soul sand.    
  *Spells* - <a href="#burrow">Burrow</a>, <a href="#detect-ore">Detect Ore</a>, <a href="#earth-shield">Earth Shield</a>, <a href="#entangle">Entangle</a>, <a href="#stone-spike">Stone Spike</a>
  
  ####Fire
  *Elemental Material* - Blaze rod  
  *Base Spell (Ignite)* - Casting this acts exactly like using flint and steel.  
  *Spells* - <a href="#fireball">Fireball</a>, <a href="#fire-shield">Fire Shield</a>, <a href="#fire-wall">Fire Wall</a>, <a href="#flame-step">Flame Step</a>, <a href="#flame-weapon">Flame Weapon</a>
  
  ####Water
  *Elemental Material* - Ghast tear  
  *Base Spell (Freeze)* - When cast on still water will turn it into ice. Casting Freeze on still lava will turn it into obsidian. Casting the spell on any other target block will cover it will a layer of snow.  
  *Spells* - <a href="#conjure-water">Conjure Water</a>, <a href="#ice-bolt">Ice Bolt</a>, <a href="#ice-shield">Ice Shield</a>, <a href="#summon-snow-golem">Summon Snow Golem</a>, <a href="#swift-swim">Swift Swim</a>
  
  ###Spells
  Spells can be applied to the wands at any enchanting table. Only spells of the wand's element can be enchanted on it and only one spell can exist on a wand at a time. 
  
  Unless otherwise noted, each spell has a max level of 5 and weight of 3. The only way to obtain the level 5 version of a spell is by combining two level 4 version at an anvil.
  
  When casting a spell, it is possible to charge it up in a similar manner to using a bow. Each spell handles the effect of charging differently. Charging a spell also causes the spell to damage the wand more than an uncharged spell.  
  The cost is calculate by the following: ``max(2^seconds, 8)``
  
  There is also a one second cooldown after a spell is cast before another spell can start.
  
  ####Air
  #####Gust
  #####Lightning
  #####Safe Fall
  #####Vortex
  #####Wind Shield
  ####Arcane
  #####Arcane Shield
  #####Dispel
  #####Light
  #####Magic Missile
  #####Toughness
  ####Earth
  #####Burrow
  #####Detect Ore
  #####Earth Shield
  #####Entangle
  #####Stone Spikes
  ####Fire
  #####Fireball
  A fireball shoots forth from the caster towards the target. Upon impact the fireball does a large amount of damage to the entity it hit as well as igniting the target. It also releases a blast of fire doing damage to other surrounding entities and igniting them.
  
  *Charge Effect* - The blast radius increases the longer the spell is charged. It ranges from no radius when uncharged to four blocks when charged.  
  *Level Effect* - The amount of damage and the duration of ignition increases with each level of the spell. It ranges from a maximum of 3 damage at level 1 to 15 at level 5.  
  #####Fire Shield
  #####Fire Wall
  #####Flame Step
  #####Flame Weapon
  ####Water
  #####Conjure Water
  #####Ice Bolt
  #####Ice Shield
  #####Summon Snow Golem
  #####Swift Swim
  

##Mob Collars
* <a href="#description-1">Description</a>

  ###Description
