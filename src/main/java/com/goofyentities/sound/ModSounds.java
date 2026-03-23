package com.goofyentities.sound;

import com.goofyentities.Goofyentitiesjava;
import eu.pb4.polymer.core.api.other.PolymerSoundEvent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
  public static final SoundEvent KICKBACK = registerSound("kickback");
  public static final SoundEvent IRIS_OUT = registerSound("iris_out");

  public static void initialise() {
    Goofyentitiesjava.LOGGER.info("Registering sounds for " + Goofyentitiesjava.MOD_ID);
  }

  private static SoundEvent registerSound(String id) {
    Identifier identifier = Identifier.fromNamespaceAndPath(Goofyentitiesjava.MOD_ID, id);
    SoundEvent obj = SoundEvent.createVariableRangeEvent(identifier);
    PolymerSoundEvent.registerOverlay(obj);

    return Registry.register(BuiltInRegistries.SOUND_EVENT, obj.location(), obj);
  }
}
