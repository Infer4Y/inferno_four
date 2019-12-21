package inferno.infernofour.common.blocks;

import inferno.infernofour.common.InfernoFour;
import inferno.infernofour.common.utils.Metals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;
import java.util.Set;

public class BlockMetal extends Block {
    private static Set<Block> heated;
    private static Set<Block> chilled;
    private String name;
    private Metals type;

    public BlockMetal(String name, Metals type) {
        super(Material.IRON);
        this.name = name;
        this.type = type;
        this.setTickRandomly(true);
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.BUILDING_BLOCKS);
    }

    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollision(worldIn, pos, state, entityIn);
        if (type == Metals.REDSTEEL){
            entityIn.setFire(3);
        }
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        if (type == Metals.REDSTEEL){
            return true;
        }
        return super.isFireSource(world, pos, side);
    }

    @Override
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
        super.randomTick(worldIn, pos, state, random);

        switch (type) {
            case STEEL:
                if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.redSteelBlock){
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                    worldIn.setBlockState(pos.down(), Blocks.steelBlock.getDefaultState());
                } else if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.redSteelBlock){
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                    worldIn.setBlockState(pos.up(), Blocks.steelBlock.getDefaultState());
                } else if (worldIn.getBlockState(pos.east()).getBlock() == Blocks.redSteelBlock){
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                    worldIn.setBlockState(pos.east(), Blocks.steelBlock.getDefaultState());
                } else if (worldIn.getBlockState(pos.west()).getBlock() == Blocks.redSteelBlock){
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                    worldIn.setBlockState(pos.west(), Blocks.steelBlock.getDefaultState());
                } else if (worldIn.getBlockState(pos.north()).getBlock() == Blocks.redSteelBlock){
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                    worldIn.setBlockState(pos.north(), Blocks.steelBlock.getDefaultState());
                } else if (worldIn.getBlockState(pos.south()).getBlock() == Blocks.redSteelBlock){
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                    worldIn.setBlockState(pos.south(), Blocks.steelBlock.getDefaultState());
                }
                if ((   heated.contains(worldIn.getBlockState(pos.down()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.up()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.west()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.east()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.north()).getBlock())||
                        heated.contains(worldIn.getBlockState(pos.south()).getBlock()) )) {
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                }
                break;
            case REDSTEEL:
                if ((  heated.contains(worldIn.getBlockState(pos.down()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.up()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.west()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.east()).getBlock()) ||
                        heated.contains(worldIn.getBlockState(pos.north()).getBlock())||
                        heated.contains(worldIn.getBlockState(pos.south()).getBlock()) )) {
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                }
                if (chilled.contains(worldIn.getBlockState(pos.down(1)).getBlock()) ||
                    chilled.contains(worldIn.getBlockState(pos.up(1)).getBlock()) ||
                    chilled.contains(worldIn.getBlockState(pos.west(1)).getBlock()) ||
                    chilled.contains(worldIn.getBlockState(pos.east(1)).getBlock()) ||
                    chilled.contains(worldIn.getBlockState(pos.north(1)).getBlock()) ||
                    chilled.contains(worldIn.getBlockState(pos.south(1)).getBlock()) ){
                    worldIn.setBlockState(pos, Blocks.steelBlock.getDefaultState());
                }
                break;
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {return true;}
        switch (type) {
            case STEEL:
                if (playerIn.getHeldItem(hand).getItem() == net.minecraft.init.Items.FLINT_AND_STEEL) {
                    playerIn.stopActiveHand();
                    worldIn.setBlockState(pos, Blocks.redSteelBlock.getDefaultState());
                }
                break;
            case REDSTEEL:
                if (playerIn.getHeldItem(hand).isEmpty()){
                    playerIn.setFire(2);
                }
                if (Item.getItemFromBlock(net.minecraft.init.Blocks.ICE).equals(playerIn.getHeldItem(hand).getItem()) ||
                    Item.getItemFromBlock(net.minecraft.init.Blocks.PACKED_ICE).equals(playerIn.getHeldItem(hand).getItem())) {
                    if (!(playerIn.isCreative())) {
                        playerIn.getHeldItem(hand).shrink(1);
                    }
                    worldIn.setBlockState(pos, Blocks.steelBlock.getDefaultState());
                } else if (net.minecraft.init.Items.WATER_BUCKET.equals(playerIn.getHeldItem(hand).getItem())) {
                    if (!(playerIn.isCreative())) {
                        playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                    }
                    worldIn.setBlockState(pos, Blocks.steelBlock.getDefaultState());
                }

                break;
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public net.minecraft.item.Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (type == Metals.REDSTEEL && !(fortune > 0)){
            return net.minecraft.item.Item.getItemFromBlock(Blocks.steelBlock);
        }
        return super.getItemDropped(state, rand, fortune);
    }

    public static void setHeated(Set<Block> x) {
        heated = x;
    }

    public static void setChilled(Set<Block> x) {
        chilled = x;
    }
}
