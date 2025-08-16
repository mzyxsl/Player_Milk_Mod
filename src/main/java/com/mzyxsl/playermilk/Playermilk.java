package com.mzyxsl.playermilk;

import com.mzyxsl.playermilk.handler.PlayerMilkHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Playermilk implements ModInitializer {
    public static final String MOD_ID = "playermilkmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // 注册玩家实体交互事件
        UseEntityCallback.EVENT.register(new PlayerMilkHandler());
        LOGGER.info("Player Milk Mod initialized! Right-click players with iron bucket to get milk");
    }
}