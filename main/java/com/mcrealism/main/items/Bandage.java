package com.mcrealism.main.items;

import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Bandage extends Item{
		
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        
		if (!worldIn.isRemote)
        {
            playerIn.heal(4);

            if (!playerIn.capabilities.isCreativeMode)
            {
                --stack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
