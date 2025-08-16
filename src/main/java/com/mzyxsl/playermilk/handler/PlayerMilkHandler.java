package com.mzyxsl.playermilk.handler;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PlayerMilkHandler implements UseEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        // 获取玩家手中的物品
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.BUCKET) && entity instanceof PlayerEntity targetPlayer) {

            // 防止玩家对自己使用
            if (player == targetPlayer) {
                return ActionResult.PASS;
            }

            // 创建牛奶桶
            ItemStack milkBucket = new ItemStack(Items.MILK_BUCKET);

            // 处理物品交换
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1); // 消耗铁桶
            }

            // 给予牛奶桶
            if (stack.isEmpty()) {
                player.setStackInHand(hand, milkBucket);
            } else if (!player.getInventory().insertStack(milkBucket)) {
                // 如果背包已满，则掉落物品
                player.dropItem(milkBucket, false);
            }

            // 播放音效
            world.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.ENTITY_COW_MILK,
                    SoundCategory.PLAYERS,
                    1.0F,
                    1.0F
            );
        }

        return ActionResult.PASS;
    }
}