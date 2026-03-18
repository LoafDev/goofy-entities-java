package com.goofyentities.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import xyz.nucleoid.packettweaker.PacketContext;

public class ExecutionerSwordItem extends SimplePolymerItem {
  public static final String itemName = "executioner_sword";
  public static final Item.Properties itemProperties = new Item.Properties();

  public ExecutionerSwordItem(Properties properties) {
    super(properties);
  }

  @Override
  public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
    return Items.BAKED_POTATO;
  }

  @Override
  public void appendHoverText(
      ItemStack stack,
      TooltipContext context,
      TooltipDisplay displayComponent,
      Consumer<Component> textConsumer,
      TooltipFlag type) {
    textConsumer.accept(
        Component.translatable(
                "The legendary sword that can kills anyone who touches it without exception")
            .withStyle(ChatFormatting.DARK_PURPLE));
  }
}
