package inferno.infernofour.common.tileentities;

import inferno.infernofour.common.blocks.Blocks;
import inferno.infernofour.common.utils.Frames;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityRefinedFrame extends TileEntity implements ITickable {
    private ItemStackHandler inventory = new ItemStackHandler(4);
    private Frames type;

    public TileEntityRefinedFrame(Frames type) {
        this.type = type;
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("inventory", inventory.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        super.readFromNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }

    private boolean basicCraft(){
        if (world.isRemote){ return true; }
        ItemStack[] stacks = new ItemStack[inventory.getSlots()];
        for (int i = 0; i < inventory.getSlots(); i++) {
            stacks[i] = inventory.getStackInSlot(i);
        }
        return true;
    }

    @Override
    public void update() {
        basicCraft();
    }
}
