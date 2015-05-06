package com.mcrealism.main.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mcrealism.main.Main;
import com.mcrealism.main.items.Bandage;
import com.mcrealism.main.items.UtilityKnife;

public class McRealismItems {
	
	// Item variables
	public static Item bandage;
	public static Item cloth;
	public static Item powder;
	public static Item bowl;
	public static Item shavings;
	public static Item utility_knife;
	
	public static void init() {
		// Creates and Adds Details to Items
		bandage = new Bandage().setUnlocalizedName("bandage").setCreativeTab(Main.tabRealism).setMaxStackSize(1);
		cloth = new Item().setUnlocalizedName("cloth").setCreativeTab(Main.tabRealism);
		powder = new Item().setUnlocalizedName("powder").setCreativeTab(Main.tabRealism);
		bowl = new Item().setUnlocalizedName("bowl").setCreativeTab(Main.tabRealism);
		shavings = new Item().setUnlocalizedName("shavings").setCreativeTab(Main.tabRealism).setMaxStackSize(1);
		utility_knife = new UtilityKnife().setUnlocalizedName("utility_knife").setCreativeTab(Main.tabRealism).setMaxStackSize(1);
	}
	
	public static void register() {
		// Registers Items In Game
		GameRegistry.registerItem(bandage, bandage.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cloth, cloth.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(powder, powder.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bowl, bowl.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(shavings, shavings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(utility_knife, utility_knife.getUnlocalizedName().substring(5));
		
		// Added Item Recipes
		GameRegistry.addRecipe(new ItemStack(bandage),
				"   ",
				"   ",
				"CCC",
				'C', cloth
				);
		
		GameRegistry.addRecipe(new ItemStack(bowl),
				"   ",
				"I I",
				"III",
				'I', Items.iron_ingot);
		
		GameRegistry.addRecipe(new ItemStack(utility_knife),
				"I  ",
				" IC",
				" CI",
				'I', Items.iron_ingot,
				'C', cloth);
		
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
		registerRender(shavings);
		registerRender(bowl);
		registerRender(utility_knife);
	}
	
	public static void registerRender(Item item) {
		// Tells Forge where Resource Model is
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Main.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
