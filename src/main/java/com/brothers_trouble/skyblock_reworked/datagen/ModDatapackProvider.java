package com.brothers_trouble.skyblock_reworked.datagen;

import com.brothers_trouble.skyblock_reworked.worldgen.ModBiomeModifiers;
import com.brothers_trouble.skyblock_reworked.worldgen.ModConfiguredFeatures;
import com.brothers_trouble.skyblock_reworked.worldgen.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackProvider(net.minecraft.data.PackOutput output,
                               java.util.concurrent.CompletableFuture<net.minecraft.core.HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(com.brothers_trouble.skyblock_reworked.Skyblock_Reworked.MODID));
    }
}