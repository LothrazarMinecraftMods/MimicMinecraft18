package com.lothrazar.mimic18.block;

import java.util.List;
import java.util.Random;

import com.lothrazar.mimic18.MimicRegistry;
import com.lothrazar.mimic18.ModSamsContent;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRedSandStoneSlab  extends BlockSlab
{ 
    private IIcon icon; 
	public BlockRedSandStoneSlab(boolean b) 
	{ 
		super(b, Blocks.sandstone.getMaterial()); 
		this.setLightOpacity(0);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    { 
		list.add(new ItemStack(item, 1, 0)); 
    }

	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return MimicRegistry.red_sandstone.getBlockTextureFromSide(side) ;
    }

	@Override
	public Item getItemDropped(int i, Random rand, int m)
    {
        return Item.getItemFromBlock(this);
    }
 
    @Override
    protected ItemStack createStackedBlock(int meta)
    {
        return new ItemStack(Item.getItemFromBlock(this), 2, 0);
    }

    @Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World worldObj, int x, int y, int z)
    {
		return Item.getItemFromBlock(this); // so creative mode pick block works
    }
    
	@Override
	public String func_150002_b(int par1)   //getFullSlabName
	{ 
		  return super.getUnlocalizedName(); 
	}
}
