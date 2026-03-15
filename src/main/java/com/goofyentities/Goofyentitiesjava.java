package com.goofyentities;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goofyentities.item.ModItems;

public class Goofyentitiesjava implements ModInitializer {
	public static final String MOD_ID = "goofy-entities-java";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + " loading...");
		ModItems.initialise();
	}
}
