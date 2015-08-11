package com.lothrazar.mimic18;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com.lothrazar.mimic18.block.BlockDoorSimple;
import com.lothrazar.mimic18.block.BlockFenceGateSimple;
import com.lothrazar.mimic18.block.BlockFenceSimple;
import com.lothrazar.mimic18.block.BlockIronTrapdoor;
import com.lothrazar.mimic18.block.BlockRedSandStone;
import com.lothrazar.mimic18.block.BlockRedSandStoneSlab;
import com.lothrazar.mimic18.block.BlockRedSandStoneStairs;
import com.lothrazar.mimic18.block.BlockSimple;
import com.lothrazar.mimic18.block.BlockSlime;
import com.lothrazar.mimic18.item.ItemDoorSimple;
import com.lothrazar.mimic18.item.ItemSlabRedSandstone;
 

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * the 1.8 update 
 * @author Samson
 *
 */
public class MimicRegistry
{

	public static BlockSimple sea_lantern;
	public static Item prismarine_crystals;
	public static Item prismarine_shard;

	static ItemFood mutton_raw;
	static ItemFood mutton_cooked;
	public static BlockFenceGateSimple acacia_fence_gate;
	public static BlockFenceGateSimple spruce_fence_gate;
	public static BlockFenceGateSimple birch_fence_gate;
	public static BlockFenceGateSimple jungle_fence_gate;
	public static BlockFenceGateSimple big_oak_fence_gate;
	public static BlockFenceSimple birch_fence;
	public static BlockFenceSimple jungle_fence;
	public static BlockFenceSimple spruce_fence;
	public static BlockFenceSimple big_oak_fence;
	public static BlockFenceSimple acacia_fence;
	public static BlockRedSandStoneSlab red_sandstone_slab;
	public static BlockRedSandStoneSlab red_sandstone_dbl_slab;
	public static BlockRedSandStone red_sandstone;
 
	static void initRecipes()
	{
		//more random changse from
		// http://minecraft.gamepedia.com/1.8
		Blocks.packed_ice.setHarvestLevel("pickaxe", 0);
		Blocks.melon_block.setHarvestLevel("axe", 0);
		Blocks.ladder.setHarvestLevel("axe", 0);
		
		//new recipes for existing blocks

		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick,1,Reference.stonebrick_chisel), " s", " s" 
			,'s', new ItemStack(Blocks.stone_slab,1,Reference.stone_slab_stonebrick));

		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick,1,Reference.stonebrick_mossy), "sv", "  " 
			,'s', Blocks.stonebrick
		 	,'v', Blocks.vine 
				);

		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone), "sv", "  " 
			,'s', Blocks.cobblestone
		 	,'v', Blocks.vine 
				);
		 
		GameRegistry.addSmelting(Blocks.stonebrick, new ItemStack(Blocks.stonebrick,1,Reference.stonebrick_cracked), 0);
		
		//coarse dirt	
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt,1,1), "gd", "dg" 
			 ,'g', Blocks.gravel
			 ,'d', Blocks.dirt
		);
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt,1,1), "dg", "gd" 
			 ,'g', Blocks.gravel
			 ,'d', Blocks.dirt
		); 

		//doors made only 1 each build in 1.7, but 3 in 1.8
		//we do it just for oak because i have all the door stuff for the types
		GameRegistry.addRecipe(new ItemStack(Items.wooden_door,3), " pp", " pp",	" pp", 
				'p',new ItemStack(Blocks.planks,1,Reference.planks_oak));
	}
	
	static void initAcaciaDoor()
	{
		BlockDoorSimple door_acacia = new BlockDoorSimple();
  
		ItemDoorSimple door_acacia_item = new ItemDoorSimple(door_acacia);  
		door_acacia.setItemDropped(door_acacia_item);

		ModSamsContent.registerBlockHelper(door_acacia, "door_acacia"); 
		ModSamsContent.registerItemHelper(door_acacia_item, "door_acacia_item") ;
		
		GameRegistry.addRecipe(new ItemStack(door_acacia_item,3), " pp", " pp",	" pp", 
				'p',new ItemStack(Blocks.planks,1,Reference.planks_acacia));
	}
	
	 static void initJungleDoor()
	{
		BlockDoorSimple door_jungle = new BlockDoorSimple();
 

		ItemDoorSimple door_jungle_item = new ItemDoorSimple( door_jungle);
		door_jungle_item.setUnlocalizedName("door_jungle_iten");//same texture name but its in the assets......items package

		door_jungle.setItemDropped(door_jungle_item);

		ModSamsContent.registerBlockHelper(door_jungle, "door_jungle"); 
		ModSamsContent.registerItemHelper(door_jungle_item, "door_jungle_item") ; 
		 
		GameRegistry.addRecipe(new ItemStack(door_jungle_item,3), " pp", " pp",	" pp", 
				'p',new ItemStack(Blocks.planks,1,Reference.planks_jungle ));
	}

	 static void initSpruceDoor()
	{
		BlockDoorSimple door_spruce = new BlockDoorSimple();
 

		ItemDoorSimple door_spruce_item = new ItemDoorSimple(door_spruce);
		door_spruce_item.setUnlocalizedName("door_spruce_item");//same texture name but its in the assets......items package

		door_spruce.setItemDropped(door_spruce_item);
		 
		ModSamsContent.registerBlockHelper(door_spruce, "door_spruce"); 
		ModSamsContent.registerItemHelper(door_spruce_item, "door_spruce_item") ;
		 
		GameRegistry.addRecipe(new ItemStack(door_spruce_item,3), " pp", " pp",	" pp", 
				'p',new ItemStack(Blocks.planks,1,Reference.planks_spruce) );
	}

	 static void initBirchDoor()
	{
		BlockDoorSimple door_birch = new BlockDoorSimple();
 
		
		ItemDoorSimple door_birch_item = new ItemDoorSimple(door_birch );
		door_birch_item.setUnlocalizedName("door_birch_item");//same texture name but its in the assets......items package

		door_birch.setItemDropped(door_birch_item);
		

		ModSamsContent.registerBlockHelper(door_birch, "door_birch"); 
		ModSamsContent.registerItemHelper(door_birch_item, "door_birch_item") ;
 
		 
		GameRegistry.addRecipe(new ItemStack(door_birch_item,3), " pp", " pp",	" pp", 
				'p',new ItemStack(Blocks.planks,1,Reference.planks_birch) );
	}

	 static void initDarkoakDoor()
	{
		BlockDoorSimple door_dark_oak = new BlockDoorSimple();
 
		
		ItemDoorSimple door_dark_oak_item = new ItemDoorSimple(door_dark_oak);
		door_dark_oak_item.setUnlocalizedName("door_dark_oak_item");//same texture name but its in the assets......items package
		
		door_dark_oak.setItemDropped(door_dark_oak_item);

		ModSamsContent.registerBlockHelper(door_dark_oak, "door_dark_oak"); 
		ModSamsContent.registerItemHelper(door_dark_oak_item, "door_dark_oak_item") ;
 
		GameRegistry.addRecipe(new ItemStack(door_dark_oak_item,3), " pp", " pp",	" pp", 
				'p',new ItemStack(Blocks.planks,1,Reference.planks_darkoak) );
	}
	
	 static void initSlimeBlock()
	{
		BlockSlime slime = new BlockSlime();
	 
		ModSamsContent.registerBlockHelper(slime, "slime"); 

		GameRegistry.addRecipe(new ItemStack(slime), "ppp", "ppp",	"ppp", 
				'p', Items.slime_ball);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.slime_ball, 9), slime);
	}

	 static void initMutton()
	{
		mutton_raw = new ItemFood(2, false);
  
		ModSamsContent.registerItemHelper(mutton_raw, "mutton_raw") ;
		
		mutton_cooked = new ItemFood(6, false);
 
		ModSamsContent.registerItemHelper(mutton_cooked, "mutton_cooked") ;
 
		GameRegistry.addSmelting(mutton_raw, new ItemStack(mutton_cooked, 1), 0);
	}

	 static void initRedSandstone()
	{
		red_sandstone = new BlockRedSandStone();
		red_sandstone.setStepSound(Block.soundTypePiston).setHardness(0.8F);
			  
		ModSamsContent.registerBlockHelper(red_sandstone, "red_sandstone"); 
		

		GameRegistry.addRecipe(new ItemStack(red_sandstone), "ss", "ss",	 
				's', new ItemStack(Blocks.sand,1,1));
		
		//reverse it back to sand
		GameRegistry.addSmelting(red_sandstone, new ItemStack(Blocks.sand,4,1), 0); 
		
		BlockRedSandStone red_sandstone_smooth = new BlockRedSandStone();
		red_sandstone_smooth.setStepSound(Block.soundTypePiston).setHardness(0.8F); 
		ModSamsContent.registerBlockHelper(red_sandstone_smooth, "red_sandstone_smooth"); 

		//remove the smoothness
		GameRegistry.addSmelting(new ItemStack(red_sandstone_smooth), new ItemStack(red_sandstone), 0); 
		
		GameRegistry.addRecipe(new ItemStack(red_sandstone_smooth,4), "ss", "ss",	 
				's', new ItemStack(red_sandstone));
		
		BlockRedSandStone red_sandstone_carved = new BlockRedSandStone();
		red_sandstone_carved.setStepSound(Block.soundTypePiston).setHardness(0.8F);
 ;
		ModSamsContent.registerBlockHelper(red_sandstone_carved, "red_sandstone_carved"); 
		


		// dang protected again
		BlockRedSandStoneStairs red_sandstone_stairs = new BlockRedSandStoneStairs(red_sandstone,0); 
		ModSamsContent.registerBlockHelper(red_sandstone_stairs, "red_sandstone_stairs"); 
		

		GameRegistry.addRecipe(new ItemStack(red_sandstone_stairs,4), "s  ", "ss ","sss",	 
				's', new ItemStack(red_sandstone));
		GameRegistry.addRecipe(new ItemStack(red_sandstone_stairs,4), "  s", " ss","sss",	 
				's', new ItemStack(red_sandstone));

		red_sandstone_slab = new BlockRedSandStoneSlab(false);
		red_sandstone_slab.setBlockName("red_sandstone_slab").setCreativeTab(CreativeTabs.tabBlock);

		red_sandstone_dbl_slab = new BlockRedSandStoneSlab(true);

		GameRegistry.registerBlock(red_sandstone_slab,
				ItemSlabRedSandstone.class, "red_sandstone_slab");
		GameRegistry.registerBlock(red_sandstone_dbl_slab,
				ItemSlabRedSandstone.class, "red_sandstone_dbl_slab");//TODO: PICK BLOCK DOES TSONE LAB

		//undo the chiselled back to the 2 slabs
		GameRegistry.addSmelting(new ItemStack(red_sandstone_carved), new ItemStack(red_sandstone_slab,2), 0); 

		GameRegistry.addRecipe(new ItemStack(red_sandstone_slab,6), "   ", "   ","sss",	 
				's', new ItemStack(red_sandstone));
		GameRegistry.addRecipe(new ItemStack(red_sandstone_slab,6), "sss", "   ","   ",	 
				's', new ItemStack(red_sandstone));
		GameRegistry.addRecipe(new ItemStack(red_sandstone_slab,6), "   ", "sss","   ",	 
				's', new ItemStack(red_sandstone));
		

		GameRegistry.addRecipe(new ItemStack(red_sandstone_carved), "s ", "s ",	 
				's', new ItemStack(red_sandstone_slab));
		
		//uncraft slabs
		GameRegistry.addRecipe(new ItemStack(red_sandstone,6), "   ", "sss","sss",	 
				's', new ItemStack(red_sandstone_slab));
		
		//uncraft stairs
		GameRegistry.addRecipe(new ItemStack(red_sandstone,6), "ss", "ss",	 
				's', new ItemStack(red_sandstone_stairs));
		
	}
	
	static void initIronTrapdoor()
	{
		// Iron Trapdoor, Armor Stand
		// is protected again
		BlockIronTrapdoor iron_trapdoor = new BlockIronTrapdoor();
 
		ModSamsContent.registerBlockHelper(iron_trapdoor, "iron_trapdoor"); 
		
		GameRegistry.addRecipe(new ItemStack(iron_trapdoor), "ii", "ii",	 
				'i', Items.iron_ingot);
		 
		GameRegistry.addSmelting(new ItemStack(iron_trapdoor), new ItemStack(Items.iron_ingot,4), 0); 
	}

	 static void initFencesGates()
	{
		// 5 fences
		birch_fence = new BlockFenceSimple("planks_birch");
 
		ModSamsContent.registerBlockHelper(birch_fence, "birch_fence"); 

		GameRegistry.addRecipe(new ItemStack(birch_fence,3), "   ", "lsl", "lsl", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_birch),
				's', Items.stick
				);
		
		jungle_fence = new BlockFenceSimple("planks_jungle");
 
		ModSamsContent.registerBlockHelper(jungle_fence, "jungle_fence"); 

		GameRegistry.addRecipe(new ItemStack(jungle_fence,3), "   ", "lsl", "lsl", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_jungle),
				's', Items.stick
				);
		
		spruce_fence = new BlockFenceSimple("planks_spruce");
 
		ModSamsContent.registerBlockHelper(spruce_fence, "spruce_fence"); 

		GameRegistry.addRecipe(new ItemStack(spruce_fence,3), "   ", "lsl", "lsl", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_spruce),
				's', Items.stick
				);
		
		big_oak_fence = new BlockFenceSimple("planks_big_oak"); 
		ModSamsContent.registerBlockHelper(big_oak_fence, "big_oak_fence"); 

		GameRegistry.addRecipe(new ItemStack(big_oak_fence,3), "   ", "lsl", "lsl", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_darkoak),
				's', Items.stick
				);

		acacia_fence = new BlockFenceSimple("planks_acacia"); 
		ModSamsContent.registerBlockHelper(acacia_fence, "acacia_fence"); 
	 

		GameRegistry.addRecipe(new ItemStack(acacia_fence,3), "   ", "lsl", "lsl", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_acacia),
				's', Items.stick
				);

 

		// we inherited from basic fencegate to override getIcon, which was set
		// to only plain planks
		acacia_fence_gate = new BlockFenceGateSimple(); 
		ModSamsContent.registerBlockHelper(acacia_fence_gate, "acacia_fence_gate"); 
		acacia_fence_gate.setBlockTextureName("planks_acacia");
		
		GameRegistry.addRecipe(new ItemStack(acacia_fence_gate,1), "   ", "sls", "sls", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_acacia),
				's', Items.stick
				);
		

		spruce_fence_gate = new BlockFenceGateSimple(); 
		ModSamsContent.registerBlockHelper(spruce_fence_gate, "spruce_fence_gate"); 

		spruce_fence_gate.setBlockTextureName("planks_spruce");
		GameRegistry.addRecipe(new ItemStack(spruce_fence_gate,1), "   ", "sls", "sls", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_spruce),
				's', Items.stick
				);
		

		birch_fence_gate = new BlockFenceGateSimple(); 
		ModSamsContent.registerBlockHelper(birch_fence_gate, "birch_fence_gate"); 
		birch_fence_gate.setBlockTextureName("planks_birch");
		
		GameRegistry.addRecipe(new ItemStack(birch_fence_gate,1), "   ", "sls", "sls", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_birch),
				's', Items.stick
				);

		jungle_fence_gate = new BlockFenceGateSimple(); 
		ModSamsContent.registerBlockHelper(jungle_fence_gate, "jungle_fence_gate"); 
		jungle_fence_gate.setBlockTextureName("planks_jungle");
		GameRegistry.addRecipe(new ItemStack(jungle_fence_gate,1), "   ", "sls", "sls", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_jungle),
				's', Items.stick
				);

		big_oak_fence_gate = new BlockFenceGateSimple(); 
		ModSamsContent.registerBlockHelper(big_oak_fence_gate, "big_oak_fence_gate");  
		big_oak_fence_gate.setBlockTextureName("planks_big_oak");
		
		GameRegistry.addRecipe(new ItemStack(big_oak_fence_gate,1), "   ", "sls", "sls", 
				'l', new ItemStack(Blocks.planks,1,Reference.planks_darkoak),
				's', Items.stick
				);
	}

	 static void initNewStones()
	{
		// resistance and hardness are the same as vanilla Blocks.stonestone

		// the standard block constructor is protected...so... // protected
		// Block(Material
		// so that means you can only set the material of Block if you extend
		// the class. so i did that

		// we had to make our own
		// regular stone is .setHardness(1.5F).setResistance(10.0F) but

		// http://minecraft.gamepedia.com/Andesite and so on

		BlockSimple diorite = new BlockSimple(Material.rock);
		diorite.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(diorite, "stone_diorite");

		BlockSimple andesite = new BlockSimple(Material.rock);
		andesite.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(andesite, "stone_andesite");

		BlockSimple granite = new BlockSimple(Material.rock);
		granite.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(granite, "stone_granite");

		BlockSimple diorite_smooth = new BlockSimple(Material.rock);
		diorite_smooth.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(diorite_smooth, "stone_diorite_smooth");

		BlockSimple andesite_smooth = new BlockSimple(Material.rock);
		andesite_smooth.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(andesite_smooth, "stone_andesite_smooth");

		BlockSimple granite_smooth = new BlockSimple(Material.rock);
		granite_smooth.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(granite_smooth, "stone_granite_smooth");

		GameRegistry.addRecipe(new ItemStack(diorite_smooth), "pp", "pp", 'p',
				diorite);//2quartz,2cobble in diagonal. quartz top right
		GameRegistry.addRecipe(new ItemStack(andesite_smooth), "pp", "pp", 'p',
				andesite);//1 dio + 1 cobble
		GameRegistry.addRecipe(new ItemStack(granite_smooth), "pp", "pp", 'p',
				granite);//1diorite+1qutz
		
		

		GameRegistry.addRecipe(new ItemStack(diorite), "cq", "qc", 
				'c',Blocks.cobblestone,
				'q',Items.quartz);//2quartz,2cobble in diagonal. quartz top right
		
		GameRegistry.addShapelessRecipe(new ItemStack(andesite), diorite,Blocks.cobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(granite), diorite,Items.quartz);
		
		
	}

	 static void initPrismarine()
	{
		// http://minecraft.gamepedia.com/Prismarine_Shard
		// http://minecraft.gamepedia.com/Prismarine_Crystals
		prismarine_crystals = new Item();
		prismarine_crystals.setCreativeTab(CreativeTabs.tabDecorations);
		ModSamsContent.registerItemHelper(prismarine_crystals, "prismarine_crystals");

		prismarine_shard = new Item();
		prismarine_crystals.setCreativeTab(CreativeTabs.tabDecorations);
		ModSamsContent.registerItemHelper(prismarine_shard, "prismarine_shard");

		BlockSimple prismarine_bricks = new BlockSimple(Material.rock);
		prismarine_bricks.setHardness(1.2F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(prismarine_bricks, "prismarine_bricks"); 
		
		
		BlockSimple prismarine_dark = new BlockSimple(Material.rock);
		prismarine_dark.setHardness(1.5F).setResistance(30.0F).setStepSound(Block.soundTypeStone);
		ModSamsContent.registerBlockHelper(prismarine_dark, "prismarine_dark"); 

		BlockSimple prismarine_rough = new BlockSimple(Material.rock);
		prismarine_rough.setHardness(1.5F).setResistance(30.0F);
		ModSamsContent.registerBlockHelper(prismarine_rough, "prismarine_rough");
		
		
		
		sea_lantern = new BlockSimple(Material.glass, prismarine_crystals); 
		sea_lantern.setHardness(0.3F).setResistance(1.5F).setLightLevel(1.0F);  
		ModSamsContent.registerBlockHelper(sea_lantern, "sea_lantern");

		// recipe time

		GameRegistry.addRecipe(new ItemStack(prismarine_rough), "pp", "pp",
				'p', prismarine_shard);

		GameRegistry.addRecipe(new ItemStack(sea_lantern), "psp", "sss", "psp",
				'p', prismarine_shard, 's', prismarine_crystals);

		GameRegistry.addRecipe(new ItemStack(prismarine_bricks), "ppp", "ppp",
				"ppp", 'p', prismarine_shard);
		GameRegistry.addRecipe(new ItemStack(prismarine_dark), "ppp", "pip",
				"ppp", 'p', prismarine_shard, 'i', new ItemStack(Items.dye, 1,
						Reference.dye_incsac));

		// no guardians exist yet. so for now just smelt lapis?

		GameRegistry.addSmelting(new ItemStack(Items.dye, 1,
				Reference.dye_lapis), new ItemStack(prismarine_shard, 2), 0);
		
		GameRegistry.addShapelessRecipe(new ItemStack(prismarine_crystals), prismarine_shard,Items.glowstone_dust);
	}

 

	/*http://minecraft.gamepedia.com/1.8



Mob head
Made creeper, skeleton and zombie heads available in survival
Creepers, skeletons, wither skeletons, and zombies drop their heads when killed by charged creepers. Wither skeletons continue to have heads as rare drops.
Note that a charged creeper explosions will not yield more than one mob head
Skulls worn on heads are now bigger so the 2nd skin layer no longer peaks through
Player and mob heads in inventories and held by mobs/players now display the actual head
Placed mob heads now show the 2nd skin layer



Tamed Ocelots and Tamed Wolves
Now display a death message if named with a name tag


Monster spawner
Can be right-clicked with a spawn egg in hand to change what the spawner produces



Button
Can now be placed on ceiling and on the ground

	 *
	 *
	 * 
	 *
	 *TODO ??SPONGE

	 * 
	 *  ??barrier
	 *  
	 *  ANVIL COSTS?
	 *  Costs reduced to balance out with the new enchanting system
Renaming items will now only cost 1 level
Repairing cost now increases exponentially (1, 2, 4, 8, etc.)
Repairing costs can no longer be kept down by renaming items
	 * 
	 * TODO BANNER 
	 * 
	 * TODO ARMOR STAND
	 *  
	 * 
	 * MAYBE
	 * New achievement Overpowered
Obtained by crafting an enchanted golden apple
Requires first obtaining Getting an Upgrade

gamemode Only can be acessed via /gamemode, either using spectator, sp, or 3
	 * 
	 * WONTDO Water Temples in Oceans
	 * 
	 * Items: Rabbit's Foot, Armor Stand Food: Raw Rabbit, Cooked Rabbit
	 * 
	 * Rabbit Stew, 
	 * 
	 *  Potions: Potion of Leaping
	 * Enchantment: Depth Strider (up to 3)
	 * 
	 * COMMAND /clone
	 * COMMAND /fill
	 * 
	 * Mobs: Endermites, Guardians, Elder Guardians, Rabbit
	 */	
}
