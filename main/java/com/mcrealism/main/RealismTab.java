package com.mcrealism.main;

import com.mcrealism.main.init.McRealismItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RealismTab extends CreativeTabs {

	public RealismTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return McRealismItems.bandage;
	}

}
