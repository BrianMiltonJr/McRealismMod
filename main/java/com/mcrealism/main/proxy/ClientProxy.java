package com.mcrealism.main.proxy;

import com.mcrealism.main.init.McRealismBlocks;
import com.mcrealism.main.init.McRealismItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders() {
		McRealismBlocks.registerRenders();
		McRealismItems.registerRenders();
	}
}
