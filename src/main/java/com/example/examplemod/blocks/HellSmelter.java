package com.example.examplemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class HellSmelter extends Block {
    protected HellSmelter() {
        super(Material.iron);
        setBlockName("Hell's Smelter");
        setCreativeTab(CreativeTabs.tabBlock);

    }
    
}
