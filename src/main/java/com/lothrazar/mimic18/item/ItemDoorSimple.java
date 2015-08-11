package com.lothrazar.mimic18.item;

import net.minecraft.item.ItemDoor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDoorSimple extends ItemDoor
{
	public Block doorBlock; 
	public ItemDoorSimple(Block block)
	{
		super(Material.wood); 
		this.doorBlock = block;
		this.maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabRedstone);//.setTextureName(texture);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(this.iconString);//removed "samspowerups:" +
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par7 != 1)
		{
			return false;
		}
		else
		{
			++par5;
			Block block = this.doorBlock;

			if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) 
					&& par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
			{
				if (!block.canPlaceBlockAt(par3World, par4, par5, par6))
				{
					return false;
				}
				else
				{
					int i1 = MathHelper.floor_double((double) ((par2EntityPlayer.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					ItemDoor.placeDoorBlock(par3World, par4, par5, par6, i1, block);
					--par1ItemStack.stackSize;
					return true;
				}
			}
			else
			{
				return false;
			}
		}
	}
}
