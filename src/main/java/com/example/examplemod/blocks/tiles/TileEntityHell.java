package com.example.examplemod.blocks.tiles;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityHell extends TileEntity {
    private ItemStack stack;
    private String INV_TAG = "Inventory";

    @Override
    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);

        if(stack != null)
        {
            NBTTagCompound invTag = new NBTTagCompound();
            stack.writeToNBT(invTag);
            p_145841_1_.setTag(INV_TAG, invTag);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);

        if (p_145839_1_.hasKey(INV_TAG, Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound inventoryTag = p_145839_1_.getCompoundTag(INV_TAG);
            stack = ItemStack.loadItemStackFromNBT(inventoryTag);
        }
    }

    @Override
    public void updateEntity() {
        if (!worldObj.isRemote && hasStack() && worldObj.getTotalWorldTime() % 100 == 0) {
            if (stack.getItem() == Item.getItemFromBlock(Blocks.coal_ore)) {
                worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord + 1, zCoord, new ItemStack(Items.coal)));
                stack = null;
                markDirty();
            }
            else if (stack.getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
                worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord + 1, zCoord, new ItemStack(Items.iron_ingot)));
                stack = null;
                markDirty();
            }
        }
    }
    public void handleInputStack(EntityPlayer player, ItemStack stack) {
        if (hasStack()) {
            if (!player.inventory.addItemStackToInventory(this.stack)) {
                player.dropPlayerItemWithRandomChoice(this.stack, false);
            } else {
                player.inventoryContainer.detectAndSendChanges();
            }
            this.stack = null;
        }
        else if (stack != null) {
            ItemStack copy = stack.copy();
            copy.stackSize = 1;
            this.stack = copy;
            --stack.stackSize;
        }
        markDirty();
    }

    private boolean hasStack() {
        return stack != null;
    }
}
