package com.brothers_trouble.skyblock_reworked.worldgen;

import com.brothers_trouble.skyblock_reworked.Skyblock_Reworked;
import com.brothers_trouble.skyblock_reworked.worldgen.island_features.SpawnIslandFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ModConfiguredFeatures {
    // this is effectively the shape of the feature

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPAWN_ISLAND_KEY = registerKey("spawn_island");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, SPAWN_ISLAND_KEY,
                ModFeatures.SPAWN_ISLAND_FEATURE.get(),
                NoneFeatureConfiguration.INSTANCE);

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Skyblock_Reworked.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
