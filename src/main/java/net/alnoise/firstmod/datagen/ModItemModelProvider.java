package net.alnoise.firstmod.datagen;

import net.alnoise.firstmod.FirstMod;
import net.alnoise.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ROSE_QUARTZ);
        simpleItem(ModItems.RAW_ROSE_QUARTZ);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.GOLDEN_STRAWBERRY);
        simpleItem(ModItems.GEODE_DETECTOR);
        simpleItem(ModItems.HEMP_WICK);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}
