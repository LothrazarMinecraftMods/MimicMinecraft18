package com.lothrazar.mimic18;

import java.util.Random;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList; 
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

//@Mod(modid = MissingTradeMod.MODID, version = MissingTradeMod.VERSION) //,guiFactory = "com.lothrazar.samspowerups.gui.ConfigGuiFactory"
public class VillageTrading  implements IVillageTradeHandler
{   
	final int BROWN = 0;
	final int WHITE = 1;
	final int PURPLE = 2;
	final int BLACK = 3;
	final int WHITEAPRON = 4;
	  
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) 
	{  	
		// this is all the minecrtaft 1.7.10 stuff
		
		//see the 1.8 here http://minecraft.gamepedia.com/Trading#Functionality
 
		//in this version : http://minecraft.gamepedia.com/Trading/Before_1.8
		
		//http://www.minecraftforge.net/forum/index.php?topic=16355.0

		// so, we add everything that is added anyway in 1.8 
		
		//first arge is what the villager wants, second stack is what the player will get
		switch(villager.getProfession())
		{
		case BROWN:
			//8-13 pumkins
			//15-19 potato
			//15-19 carrotos
			//7-12 full melons
			//TODO: how to randomize the range ??
			recipeList.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 8), new ItemStack(Items.emerald,1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Blocks.melon_block, 7), new ItemStack(Items.emerald,1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Blocks.potatoes, 15), new ItemStack(Items.emerald,1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Blocks.carrots, 15), new ItemStack(Items.emerald,1)));

			//string is in 18 for fletcher and fisherman.....
			
			break;
		case WHITE:
			
			break;
		case PURPLE:
			
			//zombie flesh 36-40
			recipeList.add(new MerchantRecipe(new ItemStack(Items.rotten_flesh, 36), new ItemStack(Items.emerald,1)));
			
			//ender pearls 2
			recipeList.add(new MerchantRecipe(new ItemStack(Items.ender_pearl, 16)

				, new ItemStack(Items.emerald,1)));
			break;
		case BLACK:
			
			break;
		case WHITEAPRON:
			
			///add chicken . they dont buy this in 17 but they do in 18

			recipeList.add(new MerchantRecipe(new ItemStack(Items.chicken, 14), new ItemStack(Items.emerald,1)));
			
			
			break;
		} 
	} 
}
