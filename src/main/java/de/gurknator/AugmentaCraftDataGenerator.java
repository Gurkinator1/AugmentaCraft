package de.gurknator;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AugmentaCraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(TagGenerator::new);
	}
}
