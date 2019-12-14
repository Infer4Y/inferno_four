package inferno.infernofour.blocks;

import inferno.infernofour.InfernoFour;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockReshaper extends Block {
    private String name;

    public BlockReshaper(String name){
        super(Material.IRON);
        this.name = name;
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.BUILDING_BLOCKS);
    }
}
