package inferno.infernofour.common.blocks;

import inferno.infernofour.common.InfernoFour;
import inferno.infernofour.common.tileentities.TileEntityHeater;
import inferno.infernofour.common.tileentities.TileEntityPresser;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class BlockPresser extends Block {
    private String name;

    public BlockPresser(String name){
        super(Material.IRON);
        this.name = name;
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.BUILDING_BLOCKS);
    }

    public TileEntityPresser getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TileEntityPresser)world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            TileEntityPresser tile = getTileEntity(worldIn, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);
            if (!playerIn.isSneaking()) {
                if (playerIn.getHeldItem(hand).isEmpty()) {
                    playerIn.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                } else {
                    playerIn.setHeldItem(hand, itemHandler.insertItem(0, playerIn.getHeldItem(hand), false));
                }
                tile.markDirty();
            } else {
                ItemStack stack = itemHandler.getStackInSlot(0);
                if (!stack.isEmpty()) {
                    String localized = stack.getTranslationKey() + ".name";
                    playerIn.sendStatusMessage(new TextComponentString(stack.getCount() + "x " + localized),false);
                } else {
                    playerIn.sendStatusMessage(new TextComponentString("Empty"),false);
                }
            }
        }
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityPresser();
    }
}
