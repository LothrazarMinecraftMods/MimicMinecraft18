package com.lothrazar.mimic18.block;

import com.lothrazar.mimic18.MimicRegistry;
import com.lothrazar.mimic18.ModSamsContent;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class BlockFenceSimple extends BlockFence
{
    public BlockFenceSimple(String name)
    {
        super(name, Material.wood); 
        this.setStepSound(Block.soundTypeWood);
        this.setHardness(2.0F).setResistance(5.0F);//same as vanilla fence
    }
    
    @Override
    public boolean canConnectFenceTo(IBlockAccess ib, int x, int y, int z)
    {
        Block block = ib.getBlock(x, y, z);
        return block != this && block != Blocks.fence && block != Blocks.fence_gate && 
        		block != MimicRegistry.acacia_fence && 
        		block != MimicRegistry.birch_fence && 
        		block != MimicRegistry.jungle_fence && 
        		block != MimicRegistry.spruce_fence && 
        		block != MimicRegistry.big_oak_fence && 
        		block != MimicRegistry.acacia_fence_gate && 
        		block != MimicRegistry.birch_fence_gate && 
        		block != MimicRegistry.jungle_fence_gate && 
        		block != MimicRegistry.spruce_fence_gate && 
        		block != MimicRegistry.big_oak_fence_gate 
        		? //if its NOT a fence or fence gate, do one extra check
        		(block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) 
        		: true;//it was for sure a fence or fgate, so we went true right away
    }
}
