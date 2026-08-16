package com.brothers_trouble.skyblock_reworked.mixin;

import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;

@Mixin(NoiseBasedChunkGenerator.class)
public abstract class WorldgenOverrideMixin {

    @Inject(method="fillFromNoise", at=@At("HEAD"), cancellable=true)
    private void fillFromNoise(Blender p_224313_, RandomState p_224314_, StructureManager p_224315_, ChunkAccess p_224316_, CallbackInfoReturnable<CompletableFuture<ChunkAccess>> cir){
        cir.setReturnValue(CompletableFuture.completedFuture(p_224316_));
        cir.cancel();
    }

    @Inject(method= "Lnet/minecraft/world/level/levelgen/NoiseBasedChunkGenerator;buildSurface(Lnet/minecraft/server/level/WorldGenRegion;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/levelgen/RandomState;Lnet/minecraft/world/level/chunk/ChunkAccess;)V", at=@At("HEAD"), cancellable=true)
    private void buildSurface(WorldGenRegion p_224232_, StructureManager p_224233_, RandomState p_224234_, ChunkAccess p_224235_, CallbackInfo ci){
        ci.cancel();
    }

    @Inject(method="applyCarvers", at=@At("HEAD"), cancellable=true)
    private void applyCarvers(WorldGenRegion p_224224_, long p_224225_, RandomState p_224226_, BiomeManager p_224227_, StructureManager p_224228_, ChunkAccess p_224229_, GenerationStep.Carving p_224230_, CallbackInfo ci){
        ci.cancel();
    }

    @Inject(method="spawnOriginalMobs", at=@At("HEAD"), cancellable=true)
    public void spawnOriginalMobs(WorldGenRegion p_64379_, CallbackInfo ci){
        ci.cancel();
    }

    @Inject(method="doFill", at=@At("HEAD"), cancellable=true)
    public void doFill(Blender blender, StructureManager structureManager, RandomState random, ChunkAccess chunk, int minCellY, int cellCountY, CallbackInfoReturnable<ChunkAccess> cir){
        cir.cancel();
    }


}

