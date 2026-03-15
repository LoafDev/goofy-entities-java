package com.goofyentities.item;

import com.goofyentities.Goofyentitiesjava;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class EmeraldArmorMaterial {
  public static final int BASE_DURABILITY = 15;
  public static final ResourceKey<EquipmentAsset> EMERALD_ARMOR_MATERIAL_KEY =
      ResourceKey.create(
          EquipmentAssets.ROOT_ID,
          Identifier.fromNamespaceAndPath(Goofyentitiesjava.MOD_ID, "emerald"));
}
