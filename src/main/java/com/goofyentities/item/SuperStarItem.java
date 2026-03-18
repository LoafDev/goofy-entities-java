package com.goofyentities.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

public class SuperStarItem extends SimplePolymerItem {
  public static final String itemName = "super_star";
  public static final Item.Properties itemProperties = new Item.Properties().stacksTo(1);

  public SuperStarItem(Properties settings) {
    super(settings);
  }

  @Override
  public InteractionResult use(Level level, Player user, InteractionHand hand) {
    if (level.isClientSide()) {
      return InteractionResult.PASS;
    }

    level.playSound(null, user.blockPosition(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS);
    return InteractionResult.SUCCESS;
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
                "Legend has it that this star grants its power only for those who wishes to lead a"
                    + " quite life")
            .withStyle(ChatFormatting.GOLD));
  }
}
