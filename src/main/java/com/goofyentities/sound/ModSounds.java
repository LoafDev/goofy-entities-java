package com.goofyentities.sound;

import com.goofyentities.Goofyentitiesjava;
import eu.pb4.polymer.core.api.other.PolymerSoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;

public class ModSounds {
  public static final PolymerSoundEvent KICKBACK = registerSound("kickback");
  public static final PolymerSoundEvent IRIS_OUT = registerSound("iris_out");

  public static void initialise() {
    Goofyentitiesjava.LOGGER.info("Registering sounds for " + Goofyentitiesjava.MOD_ID);
  }

  private static PolymerSoundEvent registerSound(String id) {
    Identifier identifier = Identifier.fromNamespaceAndPath(Goofyentitiesjava.MOD_ID, id);
    SoundEvent soundEvent =
        Registry.register(
            BuiltInRegistries.SOUND_EVENT,
            identifier,
            SoundEvent.createVariableRangeEvent(identifier));

    return PolymerSoundEvent.of(SoundEvents.ANVIL_LAND);
  }
}
