package com.mcrealism.main.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mcrealism.main.Main;
import com.mcrealism.main.blocks.CampFire;

public class McRealismBlocks {
	
	public static Block camp_fire;
	
	public static void init() {
		camp_fire = new CampFire(Material.wood).setUnlocalizedName("camp_fire");
	}
	
	public static void register() {
		GameRegistry.registerBlock(camp_fire, camp_fire.getUnlocalizedName().substring(5));
		
		GameRegistry.addRecipe(new ItemStack(camp_fire), 
				"CCC",
				"CCC",
				"CCC",
				'C', Blocks.cobblestone);
	}
	
	public static void registerRenders() {
		registerRender(camp_fire);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Main.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
	}
}
