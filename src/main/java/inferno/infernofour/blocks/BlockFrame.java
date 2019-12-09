package inferno.infernofour.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockFrame extends Block {
    private String name;

    public BlockFrame(String name) {
        super(Material.IRON);
        this.name = name;
        this.setTranslationKey(name);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }
}
