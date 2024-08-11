package de.gurknator;

import de.gurknator.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class TagGenerator extends FabricTagProvider.BlockTagProvider {
    public TagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "mineable/pickaxe")))
                .setReplace(false)
                .add(ModBlocks.DEEPSLATE_TITAN_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "needs_diamond_tool")))
                .setReplace(false)
                .add(ModBlocks.DEEPSLATE_TITAN_ORE);

    }
}
