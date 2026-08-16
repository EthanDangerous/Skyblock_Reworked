package com.brothers_trouble.skyblock_reworked.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;

@Mixin(MinecraftServer.class)
public abstract class SkyblockWorldTypeMixin {

    @Inject(method="fillFromNoise", at=@At("HEAD"), cancellable=true)
    private void fillFromNoise(Blender p_224313_, RandomState p_224314_, StructureManager p_224315_, ChunkAccess p_224316_, CallbackInfoReturnable<CompletableFuture<ChunkAccess>> cir){
        cir.setReturnValue(CompletableFuture.completedFuture(p_224316_));
        cir.cancel();
    }

}
