package com.example.examplemod.blocks.tiles;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class HellSmelterContainer extends BlockTileEntity<TileEntityHell>{
    public HellSmelterContainer(String name, Material material, float hardness, float resistanse, SoundType soundType) {
        super(name, material, hardness, resistanse, soundType);

        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public boolean onBlockActivated(World world, int xPos, int yPos, int zPos, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {

            TileEntityHell tileEntity = this.getTileEntity(world, xPos, yPos, zPos);

            tileEntity.handleInputStack(player,player.getHeldItem());
        }

        return true;
    }

    @Override
    public Class<TileEntityHell> getTileEntityClass() {

        return TileEntityHell.class;
    }

    @Override
    public TileEntityHell createTileEntity(World world, int meta) {

        return new TileEntityHell();
    }
}
