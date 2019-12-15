package inferno.infernofour.common.items;

import inferno.infernofour.common.InfernoFour;
import net.minecraft.item.Item;

public class ItemNugget extends Item {
    private String name;

    public ItemNugget(String name) {
        this.name = name;
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.MATERIALS);
    }
    public void registerItemModel() {
        InfernoFour.registerItemRenderer(this, 0, name);
    }
}
