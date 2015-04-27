package com.mcrealism.main;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.mcrealism.main.init.McRealismBlocks;
import com.mcrealism.main.init.McRealismItems;
import com.mcrealism.main.proxy.CommonProxy;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.MODNAME)
public class Main {
	
	public static final String MODID = "mcrealism";
	public static final String MODNAME = "McRealism";
	public static final String VERSION = "0.0.1";
	public static final String CLIENT_PROXY_CLASS = "com.mcrealism.main.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.mcrealism.main.proxy.CommonProxy";
	
	@SidedProxy(clientSide = Main.CLIENT_PROXY_CLASS, serverSide = Main.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final RealismTab tabRealism = new RealismTab("tabRealism");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		McRealismBlocks.init();
		McRealismBlocks.register();
		McRealismItems.init();
		McRealismItems.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
}
