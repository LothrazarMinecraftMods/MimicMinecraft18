package com.lothrazar.mimic18.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoorSimple extends BlockDoor
{
	public BlockDoorSimple()
	{
		super(Material.wood);
		//same hardness as vanilla basic door
		this.setHardness(3.0F).setStepSound(soundTypeWood);
	}
	 
    @SideOnly(Side.CLIENT)
    private IIcon[] iconsUpper;
 
    @SideOnly(Side.CLIENT)
    private IIcon[] iconsLower;
     
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.iconsUpper = new IIcon[2];
        this.iconsLower = new IIcon[2];
        //"samspowerups:" +
        this.iconsUpper[0] = p_149651_1_.registerIcon( this.textureName + "_upper");
        this.iconsLower[0] = p_149651_1_.registerIcon( this.textureName + "_lower");
        //this.field_150017_a[0] = p_149651_1_.registerIcon(this.getTextureName() + "_upper");
       // this.field_150016_b[0] = p_149651_1_.registerIcon(this.getTextureName() + "_lower");
        this.iconsUpper[1] = new IconFlipped(this.iconsUpper[0], true, false);
        this.iconsLower[1] = new IconFlipped(this.iconsLower[0], true, false);
    }
	
	private Item dropped;
	
	public void setItemDropped(Item itemDoor)
	{
		dropped = itemDoor;
	}
	 
	@Override
	public Item getItemDropped(int par1, Random rand, int par2)
    {
		return dropped;//override this so they dont drop the oak door
	} 

	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World worldObj, int x, int y, int z)
    {
		return dropped; // so creative mode pick block works
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.iconsLower[0];
    }

	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ != 1 && p_149673_5_ != 0)
        {
            int i1 = this.func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && p_149673_5_ == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && p_149673_5_ == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && p_149673_5_ == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && p_149673_5_ == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && p_149673_5_ == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && p_149673_5_ == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && p_149673_5_ == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && p_149673_5_ == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return flag2 ? this.iconsUpper[flag1?1:0] : this.iconsLower[flag1?1:0];
        }
        else
        {
            return this.iconsLower[0];
        }
    }

	
	
	/*
	//todo; override ignore material and just do the real thing
	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return (p_149650_1_ & 8) != 0 ? null : (this.blockMaterial == Material.iron ? Items.iron_door : Items.wooden_door);
    }
    
     @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return this.blockMaterial == Material.iron ? Items.iron_door : Items.wooden_door;
    }
    */
	
}
