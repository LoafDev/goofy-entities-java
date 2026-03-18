package com.goofyentities.item;

import com.goofyentities.Goofyentitiesjava;
import java.util.Optional;
import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
  public static final Item CHILI_PEPPER =
      register(ChiliPepperItem.itemName, ChiliPepperItem::new, ChiliPepperItem.itemProperties);

  public static final Item GOLDEN_CHILI_PEPPER =
      register(
          GoldenChiliPepperItem.itemName,
          GoldenChiliPepperItem::new,
          GoldenChiliPepperItem.itemProperties);

  public static final Item EXECUTIONER_SWORD =
      register(
          ExecutionerSwordItem.itemName,
          ExecutionerSwordItem::new,
          ExecutionerSwordItem.itemProperties);

  public static final Item EXECUTIONER_ARROW =
      register(
          ExecutionerArrowItem.itemName,
          ExecutionerArrowItem::new,
          ExecutionerArrowItem.itemProperties);

  public static final Item SUPER_STAR =
      register(SuperStarItem.itemName, SuperStarItem::new, SuperStarItem.itemProperties);

  public static void initialise() {
    Goofyentitiesjava.LOGGER.info("Registering {} items", Goofyentitiesjava.MOD_ID);

    itemInitialise(
        CHILI_PEPPER, CreativeModeTabs.FOOD_AND_DRINKS, Optional.of(0.67f), Optional.of(67 * 20));
    itemInitialise(
        GOLDEN_CHILI_PEPPER,
        CreativeModeTabs.FOOD_AND_DRINKS,
        Optional.of(0.67f),
        Optional.of(67 * 20));
    itemInitialise(EXECUTIONER_SWORD, CreativeModeTabs.COMBAT, Optional.empty(), Optional.empty());
    itemInitialise(
        SUPER_STAR, CreativeModeTabs.TOOLS_AND_UTILITIES, Optional.empty(), Optional.empty());
  }

  private static void itemInitialise(
      Item itemInstance,
      ResourceKey<CreativeModeTab> creativeModeTab,
      Optional<Float> composeVal,
      Optional<Integer> burnTick) {
    ItemGroupEvents.modifyEntriesEvent(creativeModeTab)
        .register((itemGroup) -> itemGroup.accept(itemInstance));

    if (composeVal.isPresent()) {
      CompostingChanceRegistry.INSTANCE.add(itemInstance, composeVal.get());
    }

    if (burnTick.isPresent()) {
      FuelRegistryEvents.BUILD.register(
          (builder, context) -> {
            builder.add(itemInstance, burnTick.get());
          });
    }
  }

  private static <T extends Item> T register(
      String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
    ResourceKey<Item> itemKey =
        ResourceKey.create(
            Registries.ITEM, Identifier.fromNamespaceAndPath(Goofyentitiesjava.MOD_ID, name));

    T item = itemFactory.apply(settings.setId(itemKey));

    Registry.register(BuiltInRegistries.ITEM, itemKey, item);

    return item;
  }
}
