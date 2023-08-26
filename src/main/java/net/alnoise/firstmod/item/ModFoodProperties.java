package net.alnoise.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(4).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 0.5f).build();

}
