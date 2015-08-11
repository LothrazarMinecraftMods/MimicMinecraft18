package com.lothrazar.mimic18;

public class ConfigFile
{
 
	//to go between main and sub levels nested in the json style cfg file
	private static String LevelSep = ".";
	public boolean decorativeBlocks;
	public boolean mutton;
	public boolean recipes;
	public boolean moreFutureTrades;
	public boolean incompSlime;
	public ConfigFile()
	{
		String category;
		

		/*********************************************************************************************/
		category = "bountiful_update";
    
		moreFutureTrades = ModSamsContent.config.getBoolean("moreFutureTrades",category, true,
    			"Adds in villager trades that would be added in 1.8."
    		);
		
		// decoration blocks: Stone types; red sandstone ; prismarine; wooden doors;  wooden fences and gates; Iron trapdoor
		decorativeBlocks = ModSamsContent.config.getBoolean("decorativeBlocks",category, true,
    			"Adds decorative blocks from 1.8: wooden doors, wooden fences and gates, iron trapdoor,  red sandstone, new stone types (do not generate naturally but they are craftable), prismarine (without ocean temples, so instead we smelt lapis)"
    		);
		
		// partially working slime block (craftable, bouncy, does not interact with pistons the same way)
		incompSlime = ModSamsContent.config.getBoolean("slimeBlock",category, true,
    			"Adds the 1.8 Slime block.  It is craftable, and it bounces entites that land on it, but it does not interact with pistons the same way"
    		);
		
		//MUTTON
		mutton = ModSamsContent.config.getBoolean("mutton",category, true,
    			"Mutton from sheep"
    		);
		
		//RECIPES
		recipes = ModSamsContent.config.getBoolean("recipes",category, true,
    			"Adds the 1.8 recipes such as crafting mossy cobblestone, cracked stone brick, coarse dirt (which isn't texutred yet but it wont get grass)"
    		);
		

		
    
		if(ModSamsContent.config.hasChanged()){ ModSamsContent.config.save(); }
	}
}
