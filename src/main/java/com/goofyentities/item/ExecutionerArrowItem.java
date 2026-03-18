package com.goofyentities.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

public class ExecutionerArrowItem extends SimplePolymerItem implements ProjectileItem {
  public static final String itemName = "executioner_arrow";
  public static final Item.Properties itemProperties = new Item.Properties();

  public ExecutionerArrowItem(Properties settings) {
    super(settings);
  }

  public AbstractArrow createArrow(
      Level level, ItemStack itemStack, LivingEntity livingEntity, @Nullable ItemStack itemStack2) {
    return new Arrow(level, livingEntity, itemStack.copyWithCount(1), itemStack2);
  }

  public Projectile asProjectile(
      Level level, Position position, ItemStack itemStack, Direction direction) {
    Arrow arrow =
        new Arrow(
            level,
            position.x(),
            position.y(),
            position.z(),
            itemStack.copyWithCount(1),
            (ItemStack) null);
    arrow.pickup = AbstractArrow.Pickup.ALLOWED;
    return arrow;
  }

  @Override
  public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
    return Items.ARROW;
  }
}
