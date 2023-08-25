package net.alnoise.firstmod.item;

import net.alnoise.firstmod.FirstMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ROSE_QUARTZ = ITEMS.register("raw_rose_quartz",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
