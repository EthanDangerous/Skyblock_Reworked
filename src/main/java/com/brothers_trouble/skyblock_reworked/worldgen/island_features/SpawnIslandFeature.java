package com.brothers_trouble.skyblock_reworked.worldgen.island_features;

import com.brothers_trouble.skyblock_reworked.Skyblock_Reworked;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Optional;

public class SpawnIslandFeature extends Feature<NoneFeatureConfiguration> {

    private static final BlockPos TARGET_POS = new BlockPos(0, 64, 0);
    private static final ResourceLocation STRUCTURE_ID =
            ResourceLocation.fromNamespaceAndPath(Skyblock_Reworked.MODID, "spawn_island");


    public SpawnIslandFeature(Codec<NoneFeatureConfiguration> p_65701_) {
        super(p_65701_);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel level = featurePlaceContext.level();

        // this just makes sure its only spawning in the right spot
        if (!level.getChunk(TARGET_POS).getPos().equals(new net.minecraft.world.level.ChunkPos(TARGET_POS))) {
            return false;
        }

        StructureTemplateManager structureManager = ((ServerLevelAccessor) level).getLevel().getStructureManager();
        Optional<StructureTemplate> templateOpt = structureManager.get(STRUCTURE_ID);

        if (templateOpt.isEmpty()) {
            Skyblock_Reworked.LOGGER.error("Could not find spawn_island structure: {}", STRUCTURE_ID);
            return false;
        }

        StructureTemplate template = templateOpt.get();
        StructurePlaceSettings settings = new StructurePlaceSettings();

        template.placeInWorld(level, TARGET_POS, TARGET_POS, settings, featurePlaceContext.random(), 2);
        return true;
    }
}
