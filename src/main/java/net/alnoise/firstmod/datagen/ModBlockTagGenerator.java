package net.alnoise.firstmod.datagen;

import net.alnoise.firstmod.FirstMod;
import net.alnoise.firstmod.block.ModBlocks;
import net.alnoise.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(Blocks.AMETHYST_BLOCK).add(Blocks.CALCITE).add(Blocks.SMOOTH_BASALT);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .add(ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get())
                .add(ModBlocks.ROSE_QUARTZ_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .add(ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get())
                .add(ModBlocks.ROSE_QUARTZ_ORE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
