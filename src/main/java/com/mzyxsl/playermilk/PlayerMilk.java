package com.mzyxsl.playermilk;

import com.mzyxsl.playermilk.handler.PlayerMilkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PlayerMilk.MODID, name = PlayerMilk.NAME, version = PlayerMilk.VERSION)
public class PlayerMilk
{
    public static final String MODID = "playermilk";
    public static final String NAME = "Player Milk";
    public static final String VERSION = "1.0";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new PlayerMilkHandler());
    }
}
