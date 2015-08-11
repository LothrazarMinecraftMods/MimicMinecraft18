package com.lothrazar.mimic18.item;

import com.lothrazar.mimic18.MimicRegistry;
import com.lothrazar.mimic18.ModSamsContent;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSlabRedSandstone extends ItemBlock
{
    private final boolean field_150948_b;
    private final BlockSlab blockSingle;
    private final BlockSlab blockDouble;
   // private static final String __OBFID = "CL_00000071";

    public ItemSlabRedSandstone(Block block)
    {
        super(block);
        this.blockSingle = MimicRegistry.red_sandstone_slab;
        this.blockDouble = MimicRegistry.red_sandstone_dbl_slab;
        this.field_150948_b = false;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int p_77617_1_)
    {
        return Block.getBlockFromItem(this).getIcon(2, p_77617_1_);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int m)
    {
        return m;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack is)
    {
        return this.blockSingle.func_150002_b(is.getItemDamage());
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int m, float par1Float, float par2Float, float par3Float)
    {
        if (this.field_150948_b)
        {
            return super.onItemUse(is, player, world, x, y, z, m, par1Float, par2Float, par3Float);
        }
        else if (is.stackSize == 0)
        {
            return false;
        }
        else if (!player.canPlayerEdit(x, y, z, m, is))
        {
            return false;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            int i1 = world.getBlockMetadata(x, y, z);
            int j1 = i1 & 7;
            boolean flag = (i1 & 8) != 0;

            if ((m == 1 && !flag || m == 0 && flag) && block == this.blockSingle && j1 == is.getItemDamage())
            {
                if (world.checkNoEntityCollision(this.blockDouble.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.blockDouble, j1, 3))
                {
                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.blockDouble.stepSound.func_150496_b(), (this.blockDouble.stepSound.getVolume() + 1.0F) / 2.0F, this.blockDouble.stepSound.getPitch() * 0.8F);
                    --is.stackSize;
                }

                return true;
            }
            else
            {
                return this.func_150946_a(is, player, world, x, y, z, m) ? true : super.onItemUse(is, player, world, x, y, z, m, par1Float, par2Float, par3Float);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_150936_a(World world, int x, int y, int z, int f, EntityPlayer player, ItemStack itemStack)
    {
        int i1 = x;
        int j1 = y;
        int k1 = z;
        Block block = world.getBlock(x, y, z);
        int l1 = world.getBlockMetadata(x, y, z);
        int i2 = l1 & 7;
        boolean flag = (l1 & 8) != 0;

        if ((f == 1 && !flag || f == 0 && flag) && block == this.blockSingle && i2 == itemStack.getItemDamage())
        {
            return true;
        }
        else
        {
            if (f == 0)
            {
                --y;
            }

            if (f == 1)
            {
                ++y;
            }

            if (f == 2)
            {
                --z;
            }

            if (f == 3)
            {
                ++z;
            }

            if (f == 4)
            {
                --x;
            }

            if (f == 5)
            {
                ++x;
            }

            Block block1 = world.getBlock(x, y, z);
            int j2 = world.getBlockMetadata(x, y, z);
            i2 = j2 & 7;
            return block1 == this.blockSingle && i2 == itemStack.getItemDamage() ? true : super.func_150936_a(world, i1, j1, k1, f, player, itemStack);
        }
    }

    private boolean func_150946_a(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int f)
    {
        if (f == 0)
        {
            --y;
        }

        if (f == 1)
        {
            ++y;
        }

        if (f == 2)
        {
            --z;
        }

        if (f == 3)
        {
            ++z;
        }

        if (f == 4)
        {
            --x;
        }

        if (f == 5)
        {
            ++x;
        }

        Block block = world.getBlock(x, y, z);
        int i1 = world.getBlockMetadata(x, y, z);
        int j1 = i1 & 7;

        if (block == this.blockSingle && j1 == itemStack.getItemDamage())
        {
            if (world.checkNoEntityCollision(this.blockDouble.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.blockDouble, j1, 3))
            {
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.blockDouble.stepSound.func_150496_b(), (this.blockDouble.stepSound.getVolume() + 1.0F) / 2.0F, this.blockDouble.stepSound.getPitch() * 0.8F);
                --itemStack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}