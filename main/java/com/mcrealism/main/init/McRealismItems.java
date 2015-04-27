package com.mcrealism.main.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mcrealism.main.Main;

public class McRealismItems {
	
	// Item variables
	public static Item bandage;
	public static Item cloth;
	public static Item powder;
	
	public static void init() {
		// Adds Details to Items
		bandage = new Item().setUnlocalizedName("bandage").setCreativeTab(Main.tabRealism);
		cloth = new Item().setUnlocalizedName("cloth").setCreativeTab(Main.tabRealism);
		powder = new Item().setUnlocalizedName("powder").setCreativeTab(Main.tabRealism);
	}
	
	public static void register() {
		// Registers Items In Game
		GameRegistry.registerItem(bandage, bandage.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cloth, cloth.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(powder, powder.getUnlocalizedName().substring(5));
		
		// Added Item Recipes
		GameRegistry.addRecipe(new ItemStack(bandage),
				"   ",
				"   ",
				"CCC",
				'C', cloth
				);
		GameRegistry.addShapelessRecipe(new ItemStack(cloth, 2), Blocks.wool);
		GameRegistry.addShapelessRecipe(new ItemStack(cloth), Items.string, Items.string);
		GameRegistry.addShapelessRecipe(new ItemStack(powder), Items.sugar, Blocks.cobblestone, Items.apple);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.slime_ball, 2), powder, Items.water_bucket, Items.apple);
	}
	
	public static void registerRenders() {
		// Registers Render of Item in Game
		registerRender(bandage);
		registerRender(cloth);
		registerRender(powder);
	}
	
	public static void registerRender(Item item) {
		// Tells Forge where Resource Model is
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Main.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
