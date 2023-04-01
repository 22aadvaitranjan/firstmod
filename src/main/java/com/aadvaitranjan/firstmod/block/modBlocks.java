package com.aadvaitranjan.firstmod.block;

import com.aadvaitranjan.firstmod.FirstMod;
import com.aadvaitranjan.firstmod.item.ModCreativeModeTab;
import com.aadvaitranjan.firstmod.item.moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f)), CreativeModeTab.TAB_MATERIALS);
    public static final RegistryObject<Block> ORE_TITANIUM = registerBlock("ore_titanium",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f)));
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn );
        return toReturn;
    }
    private static <T extends Block>void  registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        moditems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn );
        return toReturn;
    }
    private static <T extends Block>void  registerBlockItem(String name, RegistryObject<T> block) {
        moditems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.MYFIRSTAB)));
    }

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
