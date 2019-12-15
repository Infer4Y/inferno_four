package inferno.infernofour.common.items;

import inferno.infernofour.common.InfernoFour;
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
