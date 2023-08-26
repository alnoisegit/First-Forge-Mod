package net.alnoise.firstmod.item;

import net.alnoise.firstmod.FirstMod;
import net.alnoise.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIRST_MOD = CREATIVE_MODE_TABS.register("first_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_QUARTZ.get()))
                    .title(Component.translatable("creativetab.first_mod"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.ROSE_QUARTZ.get());
                        output.accept(ModItems.RAW_ROSE_QUARTZ.get());
                        output.accept(ModItems.GEODE_DETECTOR.get());
                        output.accept(ModItems.STRAWBERRY.get());

                        output.accept(ModBlocks.ROSE_QUARTZ_BLOCK.get());
                        output.accept(ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get());
                        output.accept(ModBlocks.ROSE_QUARTZ_ORE.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
