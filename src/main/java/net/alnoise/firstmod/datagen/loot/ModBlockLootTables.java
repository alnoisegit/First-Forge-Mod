package net.alnoise.firstmod.datagen.loot;

import net.alnoise.firstmod.block.ModBlocks;
import net.alnoise.firstmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ROSE_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_BUTTON.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_FENCE.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_WALL.get());
        this.dropSelf(ModBlocks.ROSE_QUARTZ_TRAPDOOR.get());

        this.add(ModBlocks.ROSE_QUARTZ_ORE.get(),
                block -> createOreDrop(ModBlocks.ROSE_QUARTZ_ORE.get(), ModItems.RAW_ROSE_QUARTZ.get()));

        this.dropSelf(ModBlocks.ROSE_QUARTZ_STAIRS.get());
        this.add(ModBlocks.ROSE_QUARTZ_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROSE_QUARTZ_SLAB.get()));

        this.add(ModBlocks.ROSE_QUARTZ_DOOR.get(),
                block -> createDoorTable(ModBlocks.ROSE_QUARTZ_DOOR.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
