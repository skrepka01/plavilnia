package com.example.examplemod;

import com.example.examplemod.common.common_side.CommonProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Plavilnia.MODID, version = Plavilnia.VERSION)
public class Plavilnia
{
    @SidedProxy(
            clientSide = "com.example.examplemod.common.client_side.ClientProxy",
            serverSide = "com.example.examplemod.common.common_side.CommonProxy"
    )
    public static CommonProxy proxy;
    public static final String MODID = "plavilnia";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        System.out.println("Предварительная инициализация мода");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        System.out.println("Пост-инициализация мода");
    }
}
