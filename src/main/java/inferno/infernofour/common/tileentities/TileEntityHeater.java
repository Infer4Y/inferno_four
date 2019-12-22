package inferno.infernofour.common.tileentities;

import inferno.infernofour.common.blocks.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
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

public class TileEntityHeater extends TileEntity implements ITickable {
    private ItemStackHandler inventory = new ItemStackHandler(1);

    public TileEntityHeater() {}

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
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) inventory : super.getCapability(capability, facing);
    }

    private boolean basicCraft(){
        if (world.isRemote){ return false; }

        if (inventory.getStackInSlot(0).getItem() == Item.getItemFromBlock(Blocks.steelBlock)){
            inventory.getStackInSlot(0).shrink(1);
            if ((inventory.getStackInSlot(0).getCount() > 1)) {
                world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), inventory.getStackInSlot(0).copy()));
                inventory.getStackInSlot(0).shrink(64);
            }
            world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Item.getItemFromBlock(Blocks.redSteelBlock),1)));
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if (world.getBlockState(pos.down(1)).getBlock() == Blocks.redSteelBlock){
            if (basicCraft()) { world.setBlockState(pos.down(1), Blocks.steelBlock.getDefaultState()); }
        }
    }
}
