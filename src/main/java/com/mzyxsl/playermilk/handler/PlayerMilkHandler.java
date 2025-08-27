package com.mzyxsl.playermilk.handler;

import com.mzyxsl.playermilk.PlayerMilk;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = PlayerMilk.MODID)
public class PlayerMilkHandler {

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {

        // 检查是否右键点击了玩家
        if (event.getTarget() instanceof Player) {
            Player interactingPlayer = event.getEntity();
            ItemStack heldItem = interactingPlayer.getItemInHand(event.getHand());

            // 检查手中物品是否是空桶
            if (heldItem.getItem() == Items.BUCKET && heldItem.getCount() == 1) {
                // 取消原有事件
                event.setCanceled(true);
                // 检查目标玩家是否在创造模式
                if(!interactingPlayer.isCreative()) {
                    // 消耗一个空桶
                    heldItem.shrink(1);
                }

                // 创建牛奶桶
                ItemStack milkBucket = new ItemStack(Items.MILK_BUCKET);

                // 尝试添加到背包，如果失败则掉落在地上
                if (!interactingPlayer.getInventory().add(milkBucket)) {
                    interactingPlayer.drop(milkBucket, false); // 掉落物品
                }


                // 播放声音效果
                event.getLevel().playSound(
                        null,
                        interactingPlayer.getX(),
                        interactingPlayer.getY(),
                        interactingPlayer.getZ(),
                        SoundEvents.COW_MILK,
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                );
            }
        }
    }
}