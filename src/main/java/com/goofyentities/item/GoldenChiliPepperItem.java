package com.goofyentities.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import xyz.nucleoid.packettweaker.PacketContext;

public class GoldenChiliPepperItem extends SimplePolymerItem {
  public static final String itemName = "golden_chili_pepper";

  static final FoodProperties itemFoodProperties =
      new FoodProperties.Builder().alwaysEdible().nutrition(4).saturationModifier(3.5f).build();

  public static final Item.Properties itemProperties =
      new Item.Properties().food(itemFoodProperties);

  public GoldenChiliPepperItem(Properties properties) {
    super(properties);
  }

  @Override
  public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
    return Items.APPLE;
  }

  @Override
  public void appendHoverText(
      ItemStack stack,
      TooltipContext context,
      TooltipDisplay displayComponent,
      Consumer<Component> textConsumer,
      TooltipFlag type) {
    textConsumer.accept(
        Component.translatable("Red hot chili pepper... now shining with gold!")
            .withStyle(ChatFormatting.GOLD));
  }
}
