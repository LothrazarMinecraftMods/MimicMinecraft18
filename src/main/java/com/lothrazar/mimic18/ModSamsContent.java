package com.lothrazar.mimic18;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;  

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
 
/**
 * 
 * @author Sam Bassett (@lothrazar)
 * imported from my old repo Feb 3rd 2015, the last time before I updated that old mod to 1.8
 * https://github.com/PrinceOfAmber/SamsPowerups/commit/00a32f4a16739c307cf3c6149d2417dfff7ea3f3
 * 
 * current repo:
 *
 */

//TODO: fix // ,guiFactory = "com.lothrazar.samspowerups.gui.ConfigGuiFactory"
@Mod(modid = ModSamsContent.MODID, version = ModSamsContent.VERSION	, canBeDeactivated = false, name = ModSamsContent.NAME, useMetadata = true) 
public class ModSamsContent
{
	@Instance(value = ModSamsContent.MODID)
	public static ModSamsContent instance;
	public static Logger logger;
	public final static String MODID = "mimic18";
	public static String TEXTURE_LOCATION = "samspowerups:";
	public static final String VERSION = "1";
	public static final String NAME = "Sam's Content";

	public static Configuration config;
	public static ConfigFile settings;
	
	public static CreativeTabs tabMimic = new CreativeTabs("tabMimic") 
	{
		@Override
		public Item getTabIconItem() {
			return MimicRegistry.prismarine_crystals;
		}
	};
	//TODO: try asm out http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/1571568-tutorial-1-6-2-changing-vanilla-without-editing

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event)
	{ 
		logger = event.getModLog();
		
		config = new Configuration(event.getSuggestedConfigurationFile());
 
		settings = new ConfigFile();
 
		MinecraftForge.EVENT_BUS.register(instance);
		FMLCommonHandler.instance().bus().register(instance);
 	 
	}
 
	@EventHandler
	public void onInit(FMLInitializationEvent event)
	{     
 
  		if(ModSamsContent.settings.moreFutureTrades)
  		{
	  		VillageTrading v = new VillageTrading();
			VillagerRegistry.instance().registerVillageTradeHandler(1, v);
			VillagerRegistry.instance().registerVillageTradeHandler(2, v);
  		}
  		 
   		if(ModSamsContent.settings.recipes) 
   		{
   			MimicRegistry.initRecipes();  
   		} 
		
		if(ModSamsContent.settings.decorativeBlocks)
		{
			MimicRegistry.initNewStones();
			 
			MimicRegistry.initPrismarine();
	
			MimicRegistry.initBirchDoor();
			 
			MimicRegistry.initSpruceDoor();
			 
			MimicRegistry.initJungleDoor();
			
			MimicRegistry.initAcaciaDoor();
	        
			MimicRegistry.initDarkoakDoor();
			
			MimicRegistry.initFencesGates();
	
			MimicRegistry.initIronTrapdoor();
	
			MimicRegistry.initRedSandstone();
		}

		if(ModSamsContent.settings.mutton) { MimicRegistry.initMutton(); }
		
		if(ModSamsContent.settings.incompSlime) { MimicRegistry.initSlimeBlock(); }
 

		//SaplingStickAxe();
		
		//SmoothstoneRequired();
		
		//MobSpawnExtras();
		//mushroom???
		//blocks
		//rotate damage value 1 by 1
		
 
		//recipe shortcuts:
		
		//dye wool by 8 blocks instead of 1
		
		
		//easier redstone repeater recipe, to use sticks nad redstone instead of torches
		 //https://i.imgur.com/UqthR4k.png
		
		//minecart stuffs: use five iron plus chest for it, instead of making the  cart first
		//etc for other minecarts too
		
	}


	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event)
	{
		if (event.entityLiving instanceof EntitySheep
				&& MimicRegistry.mutton_cooked != null
				&& MimicRegistry.mutton_raw != null)
		{ 
			// 50/50 drop 1-2 
			// TODO. more with looting 
 
			int drops = 1 + event.entity.worldObj.rand.nextInt(2);// this gets num in range [0,1]

			if (event.entityLiving.isBurning())
				event.entityLiving.dropItem(MimicRegistry.mutton_cooked, drops);
			else
				event.entityLiving.dropItem(MimicRegistry.mutton_raw, drops);
		}
	}

	 public static void registerBlockHelper(Block s, String name)
	 {
		 s.setBlockName(name).setBlockTextureName(TEXTURE_LOCATION + name).setCreativeTab(tabMimic);
		 GameRegistry.registerBlock(s, name);
		 
		 
	 }
	 public static void registerItemHelper(Item s, String name)
	 {
		 s.setUnlocalizedName(name).setTextureName(TEXTURE_LOCATION + name).setCreativeTab(tabMimic);
		 GameRegistry.registerItem(s, name);
	 }
	 
}
