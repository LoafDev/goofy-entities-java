package com.goofyentities.datagen;

import com.goofyentities.Goofyentitiesjava;
import com.goofyentities.item.ChiliPepperItem;
import com.goofyentities.item.ExecutionerSwordItem;
import com.goofyentities.item.GoldenChiliPepperItem;
import com.goofyentities.item.SuperStarItem;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup.Provider;

public class GoofyEnglishLangProvider extends FabricLanguageProvider {
  static final String CHILI_PEPPER = createTranslationID("item", ChiliPepperItem.itemName);

  static final String GOLDEN_CHILI_PEPPER =
      createTranslationID("item", GoldenChiliPepperItem.itemName);

  static final String EXECUTIONER_SWORD =
      createTranslationID("item", ExecutionerSwordItem.itemName);

  static final String SUPER_STAR = createTranslationID("item", SuperStarItem.itemName);

  static final String KICKBACK = createTranslationID("sound", "kickback");
  static final String IRIS_OUT = createTranslationID("sound", "iris_out");

  static String createTranslationID(String registryType, String itemName) {
    return registryType + "." + Goofyentitiesjava.MOD_ID + "." + itemName;
  }

  public GoofyEnglishLangProvider(
      FabricDataOutput dataOutput, CompletableFuture<Provider> registryLookup) {
    super(dataOutput, "en_us", registryLookup);
  }

  @Override
  public void generateTranslations(Provider registryLookup, TranslationBuilder translationBuilder) {
    translationBuilder.add(CHILI_PEPPER, "Chili Pepper");
    translationBuilder.add(GOLDEN_CHILI_PEPPER, "Golden Chili Pepper");
    translationBuilder.add(EXECUTIONER_SWORD, "Executioner Sword");
    translationBuilder.add(SUPER_STAR, "Super Star");
    translationBuilder.add(KICKBACK, "Kickback");
    translationBuilder.add(IRIS_OUT, "Iris Out");
  }
}
