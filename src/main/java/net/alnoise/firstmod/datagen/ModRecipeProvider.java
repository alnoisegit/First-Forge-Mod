package net.alnoise.firstmod.datagen;

import net.alnoise.firstmod.FirstMod;
import net.alnoise.firstmod.block.ModBlocks;
import net.alnoise.firstmod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final List<ItemLike> ROSE_QUARTZ_SMELTABLES = List.of(ModItems.RAW_ROSE_QUARTZ.get(), ModBlocks.ROSE_QUARTZ_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ROSE_QUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ROSE_QUARTZ.get())
                        .build()))
                .save(pWriter, new ResourceLocation(FirstMod.MOD_ID, "rose_quartz_block_from_rose_quartz"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEODE_DETECTOR.get())
                .pattern("  A")
                .pattern(" AB")
                .pattern("AC ")
                .define('A', Items.STICK)
                .define('B', Items.STRING)
                .define('C', ModItems.ROSE_QUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ROSE_QUARTZ.get())
                        .build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SQUID_MEAL.get())
                .pattern("AB ")
                .pattern("   ")
                .pattern("   ")
                .define('A', Items.INK_SAC)
                .define('B', Items.SUGAR)
                .unlockedBy("has_ink_sac", inventoryTrigger(ItemPredicate.Builder.item().of(Items.INK_SAC)
                        .build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_QUARTZ_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_rose_quartz_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                        .build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_QUARTZ_STAIRS.get())
                .pattern("  A")
                .pattern(" AA")
                .pattern("AAA")
                .define('A', ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_rose_quartz_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                        .build()))
                .save(pWriter);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSE_QUARTZ.get(), 9)
                .requires(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                .unlockedBy("has_rose_quartz_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ROSE_QUARTZ_BLOCK.get())
                        .build()))
                .save(pWriter);


        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ROSE_QUARTZ.get(), RecipeCategory.MISC, ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get(),
                "firstmod:raw_rose_quartz", "rose_quartz", "firstmod:raw_rose_quartz_block", "rose_quartz");

        //slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_QUARTZ_SLAB.get(), Ingredient.of(ModBlocks.ROSE_QUARTZ_BLOCK.get()));

        oreSmelting(pWriter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ.get(), 0.25f, 200, "rose_quartz");
        oreBlasting(pWriter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ.get(), 0.3f, 100, "rose_quartz");

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
