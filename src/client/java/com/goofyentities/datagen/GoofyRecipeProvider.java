package com.goofyentities.datagen;

import com.goofyentities.item.ModItems;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

public class GoofyRecipeProvider extends FabricRecipeProvider {

  public GoofyRecipeProvider(
      FabricDataOutput output, CompletableFuture<Provider> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  public String getName() {
    return "ModRecipeProvider";
  }

  @Override
  protected RecipeProvider createRecipeProvider(Provider registryLookup, RecipeOutput exporter) {
    return new RecipeProvider(registryLookup, exporter) {
      @Override
      public void buildRecipes() {
        // RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
        registries.lookupOrThrow(Registries.ITEM);

        shaped(RecipeCategory.FOOD, ModItems.GOLDEN_CHILI_PEPPER)
            .pattern("ggg")
            .pattern("gcg")
            .pattern("ggg")
            .define('g', Items.GOLD_NUGGET)
            .define('c', ModItems.CHILI_PEPPER)
            .group("food and drink")
            .unlockedBy(getHasName(ModItems.CHILI_PEPPER), has(ItemTags.GOLD_ORES))
            .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.SUPER_STAR)
            .pattern(" g ")
            .pattern("geg")
            .pattern(" g ")
            .define('g', Items.GOLD_INGOT)
            .define('e', Items.EMERALD)
            .group("tools")
            .unlockedBy(getHasName(Items.EMERALD), has(ItemTags.GOLD_ORES))
            .save(output);
      }
    };
  }
}
