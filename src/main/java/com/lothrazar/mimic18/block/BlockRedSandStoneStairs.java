package com.lothrazar.mimic18.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockRedSandStoneStairs extends BlockStairs
{ 
	public BlockRedSandStoneStairs(Block b, int o) 
	{
		super(b, o); 
		this.setLightOpacity(0);
	}  
}
