package com.mcrealism.main.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mcrealism.main.Main;
import com.mcrealism.main.blocks.CampFire;

public class McRealismBlocks {
	
	// Creating Variable Type for Blocks.
	public static Block camp_fire;
	public static Block camp_fire_cook;
	
	public static void init() {
		// Adds unlocalized Name plus material to Block
		camp_fire = new CampFire().setUnlocalizedName("camp_fire").setCreativeTab(Main.tabRealism);
		camp_fire_cook = new CampFire().setUnlocalizedName("camp_fire_cook").setCreativeTab(Main.tabRealism);
	}
	
	public static void register() {
		// Registers Block
		GameRegistry.registerBlock(camp_fire, camp_fire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(camp_fire_cook, camp_fire_cook.getUnlocalizedName().substring(5));
		
		// Recipes for Blocks
		GameRegistry.addRecipe(new ItemStack(camp_fire), 
				"   ",
				"WWW",
				"SSS",
				'S', Blocks.stone,
				'W', Blocks.log);
	}
	
	public static void registerRenders() {
		// Register Render in Game
		registerRender(camp_fire);
		registerRender(camp_fire_cook);
	}
	
	public static void registerRender(Block block) {
		// Tells where the Mode Resource is
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Main.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
	}
}
