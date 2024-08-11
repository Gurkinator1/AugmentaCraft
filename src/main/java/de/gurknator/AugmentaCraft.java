package de.gurknator;

import de.gurknator.blocks.ModBlocks;
import de.gurknator.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AugmentaCraft implements ModInitializer {
	public static final String MOD_ID = "augmentacraft";
    public static final Logger LOGGER = LoggerFactory.getLogger("augmentacraft");
	//world gen features
	public static final RegistryKey<PlacedFeature> CUSTOM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("augmentacraft","ore_custom"));
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing AugmentaCraft");
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CUSTOM_ORE_PLACED_KEY);

		ModItems.initialize();
		ModBlocks.initialize();
	}
}