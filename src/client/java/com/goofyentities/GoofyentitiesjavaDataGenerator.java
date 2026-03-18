package com.goofyentities;

import com.goofyentities.datagen.GoofyEnglishLangProvider;
import com.goofyentities.datagen.GoofyRecipeProvider;
import com.goofyentities.datagen.GoofyModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class GoofyentitiesjavaDataGenerator implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    pack.addProvider(GoofyEnglishLangProvider::new);
    pack.addProvider(GoofyModelProvider::new);
    pack.addProvider(GoofyRecipeProvider::new);
  }
}
