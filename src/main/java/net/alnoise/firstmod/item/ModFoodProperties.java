package net.alnoise.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(4).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 0.5f).build();
    public static final FoodProperties GOLDEN_STRAWBERRY = new FoodProperties.Builder().nutrition(4).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200), 0.5f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 600), 1f).build();

    public static final FoodProperties SQUID_MEAL = new FoodProperties.Builder().nutrition(4).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1000, 500), 1f).build();

}
