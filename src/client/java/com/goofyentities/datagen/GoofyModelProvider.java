package com.goofyentities.datagen;

import com.goofyentities.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class GoofyModelProvider extends FabricModelProvider {

  public GoofyModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {}

  @Override
  public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    itemModelGenerator.generateFlatItem(ModItems.CHILI_PEPPER, ModelTemplates.FLAT_ITEM);
    itemModelGenerator.generateFlatItem(ModItems.GOLDEN_CHILI_PEPPER, ModelTemplates.FLAT_ITEM);
    itemModelGenerator.generateFlatItem(ModItems.SUPER_STAR, ModelTemplates.FLAT_ITEM);
    itemModelGenerator.generateFlatItem(
        ModItems.EXECUTIONER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
  }
}
