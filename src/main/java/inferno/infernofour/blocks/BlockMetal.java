package inferno.infernofour.blocks;

import inferno.infernofour.InfernoFour;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMetal extends Block {
    private String name;

    public BlockMetal(String name) {
        super(Material.IRON);
        this.name = name;
        this.setTranslationKey(name);
    }
}
