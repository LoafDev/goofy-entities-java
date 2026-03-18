package com.goofyentities;

import com.goofyentities.component.ModComponents;
import com.goofyentities.item.ModItems;
import com.goofyentities.sound.ModSounds;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Goofyentitiesjava implements ModInitializer {
  public static final String MOD_ID = "goofy-entities-java";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info(MOD_ID + " loading...");

    boolean loadResourcePack = PolymerResourcePackUtils.addModAssets(MOD_ID);
    PolymerResourcePackUtils.markAsRequired();

    LOGGER.info("Load resource pack status: " + (loadResourcePack ? "Success" : "Failed"));
    ModItems.initialise();
    ModComponents.initialise();
    ModSounds.initialise();
  }
}
