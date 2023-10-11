package com.example.examplemod.blocks;

import com.example.examplemod.Plavilnia;
import com.example.examplemod.blocks.tiles.HellSmelterContainer;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RegisterBlocks {

    public static HellSmelter hellSmelter = new HellSmelter();
    public static final Block
            COUNTER = new HellSmelterContainer("counter", Material.rock, 5.0F, 5.0F, Block.soundTypeStone).setCreativeTab(CreativeTabs.tabBlock);

    public static final Block[] BLOCKS = new Block[] {

            COUNTER
    };

    public static void register() {
        registerBlocks(BLOCKS);
    }

    private static void registerBlocks(Block... blocks) {

        for (int i = 0; i < blocks.length; i++) {

            GameRegistry.registerBlock(blocks[i], blocks[i].getUnlocalizedName());
        }
    }
}
