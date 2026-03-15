package com.goofyentities.item;

import com.goofyentities.Goofyentitiesjava;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {
  public static final Item CHILI_PEPPER =
      register(ChiliPepperItem.itemName, ChiliPepperItem::new, ChiliPepperItem.itemProperties);

  public static final Item GOLDEN_CHILI_PEPPER =
      register(
          GoldenChiliPepperItem.itemName,
          GoldenChiliPepperItem::new,
          GoldenChiliPepperItem.itemProperties);

  public static void initialise() {
    ChiliPepperItem.initialise();
    GoldenChiliPepperItem.initialise();
  }

  public static <T extends Item> T register(
      String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
    ResourceKey<Item> itemKey =
        ResourceKey.create(
            Registries.ITEM, Identifier.fromNamespaceAndPath(Goofyentitiesjava.MOD_ID, name));

    T item = itemFactory.apply(settings.setId(itemKey));

    Registry.register(BuiltInRegistries.ITEM, itemKey, item);

    return item;
  }
}
