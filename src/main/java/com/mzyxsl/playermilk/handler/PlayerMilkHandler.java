package com.mzyxsl.playermilk.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerMilkHandler {
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        // 检查是否右键点击了玩家
        if (event.getTarget() instanceof EntityPlayer) {
            EntityPlayer interactingPlayer = event.getEntityPlayer();
            ItemStack heldItem = interactingPlayer.getHeldItem(event.getHand());

            // 检查手中物品是否是空桶
            if (heldItem.getItem() == Items.BUCKET && heldItem.getCount() == 1) {
                // 取消原有事件
                event.setCanceled(true);

                ItemStack milkBucket = new ItemStack(Items.MILK_BUCKET);

                // 检测当前玩家游戏模式
                if(!interactingPlayer.isCreative()) {
                    // 消耗一个空桶
                    heldItem.shrink(1);
                }

                // 给玩家牛奶桶
                if (heldItem.isEmpty()) {
                    interactingPlayer.setHeldItem(event.getHand(), milkBucket);
                } else {
                    if (!interactingPlayer.inventory.addItemStackToInventory(milkBucket)) {
                        interactingPlayer.dropItem(milkBucket, false);
                    }
                }

                interactingPlayer.world.playSound(null, interactingPlayer.posX, interactingPlayer.posY, interactingPlayer.posZ,
                        net.minecraft.init.SoundEvents.ENTITY_COW_MILK,
                        net.minecraft.util.SoundCategory.PLAYERS,
                        1.0F, 1.0F);
            }
        }
    }
}