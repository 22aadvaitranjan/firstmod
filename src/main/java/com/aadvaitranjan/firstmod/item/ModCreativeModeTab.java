package com.aadvaitranjan.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MYFIRSTAB = new CreativeModeTab("My_First_Tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(moditems.TITANIUM_INGOT.get());
        }
    };
}
