package com.aadvaitranjan.firstmod.item;

import com.aadvaitranjan.firstmod.FirstMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,FirstMod.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MYFIRSTAB)));
    public static final RegistryObject<Item> TITANIUM_NUGGIT = ITEMS.register("titanium_nuggit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MYFIRSTAB)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MYFIRSTAB)));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MYFIRSTAB)
                    .food(new FoodProperties.Builder().nutrition(100).saturationMod(0.2f).build())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static class ITEMS {
    }
}
