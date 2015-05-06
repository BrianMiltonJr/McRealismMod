package com.mcrealism.main.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import com.mcrealism.main.init.McRealismItems;

public class UtilityKnife extends Item{
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        
		if (!worldIn.isRemote) {
            
			if (!playerIn.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

            return true;
        }
        else {
            return false;
        }
    }
	
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
        if (blockIn != Blocks.log) {
            return super.onBlockDestroyed(stack, worldIn, blockIn, pos, playerIn);
        }
        else
        {
            return true;
        }
    }
}
