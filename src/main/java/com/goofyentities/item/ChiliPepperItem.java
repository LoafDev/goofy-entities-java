package com.goofyentities.item;

import java.util.function.Consumer;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

public class ChiliPepperItem extends SimplePolymerItem {
	public static final String itemName = "chili_pepper";
	public static final FoodProperties itemFoodProperties = new FoodProperties.Builder()
		.alwaysEdible()
		.nutrition(2)
		.saturationModifier(2.0f)
		.build();
	public static final Item.Properties itemProperties = new Item.Properties().food(itemFoodProperties);

	public static void initialise() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
			.register((itemGroup) -> itemGroup.accept(ModItems.CHILI_PEPPER));

		CompostingChanceRegistry.INSTANCE.add(ModItems.CHILI_PEPPER, 0.67f);

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.CHILI_PEPPER, 67 * 20);
		});
	}

	public ChiliPepperItem(Properties properties) {
		super(properties);
	}

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
  	textConsumer.accept(Component.translatable("A normal chili pepper... I hope").withStyle(ChatFormatting.RED));
  }
}
