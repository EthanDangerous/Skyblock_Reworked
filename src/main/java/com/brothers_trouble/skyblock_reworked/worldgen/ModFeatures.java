package com.brothers_trouble.skyblock_reworked.worldgen;

import com.brothers_trouble.skyblock_reworked.Skyblock_Reworked;
import com.brothers_trouble.skyblock_reworked.worldgen.island_features.SpawnIslandFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, Skyblock_Reworked.MODID);

    public static final DeferredHolder<Feature<?>, SpawnIslandFeature> SPAWN_ISLAND_FEATURE =
            FEATURES.register("spawn_island_feature", () -> new SpawnIslandFeature(NoneFeatureConfiguration.CODEC));
}