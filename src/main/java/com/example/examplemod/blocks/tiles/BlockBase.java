package com.example.examplemod.blocks.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    protected BlockBase(String name, Material material, float hardness,float resistanse,SoundType soundType) {
        super(material);

        this.setBlockName(name);
        this.setHardness(hardness);
        this.setResistance(resistanse);
        this.setStepSound(soundType);
    }
}
