package com.lothrazar.mimic18.block;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;

public class BlockIronTrapdoor extends BlockTrapDoor
{
	public BlockIronTrapdoor()
	{
		super(Material.iron);
 
		this.disableStats();
		this.setHardness(3.0F).setStepSound(soundTypeMetal);
	}
}
