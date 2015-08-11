package com.lothrazar.mimic18.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSandStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockRedSandStone extends BlockSandStone
{ 
    public BlockRedSandStone()
    {
        super(); 
        this.setLightOpacity(0);
    }

    @SideOnly(Side.CLIENT)
    private IIcon iconsFourSides;
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));

    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    { 
        this.iconsFourSides = p_149651_1_.registerIcon(this.getTextureName());//four sides are either carved/normal/smooth
   

        //top bottom same for all of them, regardless of carved,smooth,whatever
        this.iconTop = p_149651_1_.registerIcon("samspowerups:" + "red_sandstone" + "_top");
        this.iconBottom = p_149651_1_.registerIcon("samspowerups:" + "red_sandstone" + "_bottom");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    { 
        if (side == 0)
        {
            return this.iconBottom;
        }
        else if(side == 1)
        { 
            return this.iconTop;
        } 
        else
        {
            return this.iconsFourSides;
        }
    }
}
