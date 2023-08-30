package net.alnoise.firstmod.datagen;

import net.alnoise.firstmod.FirstMod;
import net.alnoise.firstmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.RAW_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.ROSE_QUARTZ_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.ROSE_QUARTZ_STAIRS.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.ROSE_QUARTZ_SLAB.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        buttonBlock((ButtonBlock) ModBlocks.ROSE_QUARTZ_BUTTON.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.ROSE_QUARTZ_FENCE.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.ROSE_QUARTZ_FENCE_GATE.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.ROSE_QUARTZ_WALL.get(), blockTexture(ModBlocks.ROSE_QUARTZ_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.ROSE_QUARTZ_DOOR.get(), modLoc("block/rose_quartz_door_bottom"), modLoc("block/rose_quartz_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.ROSE_QUARTZ_TRAPDOOR.get(), modLoc("block/rose_quartz_trapdoor"), true, "cutout");

        blockItem(ModBlocks.ROSE_QUARTZ_SLAB);
        blockItem(ModBlocks.ROSE_QUARTZ_STAIRS);
        blockItem(ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE);
        blockItem(ModBlocks.ROSE_QUARTZ_FENCE_GATE);

        blockItem(ModBlocks.ROSE_QUARTZ_TRAPDOOR, "_bottom");

    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("firstmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("firstmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
