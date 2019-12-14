package inferno.infernofour.items;

import inferno.infernofour.InfernoFour;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ItemPlate extends Item {
    private String name;

    public ItemPlate(String name) {
        this.name = name;
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.MATERIALS);
    }

    public void registerItemModel() {
        InfernoFour.registerItemRenderer(this, 0, name);
    }
}
