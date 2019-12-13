package inferno.infernofour.items;

import inferno.infernofour.InfernoFour;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockItem extends ItemBlock {
    private String name;

    public ItemBlockItem(Block block, String name) {
        super(block);
        this.name = name;
    }

    public void registerItemModel() {
        InfernoFour.registerItemRenderer(this, 0, name);
    }
}
