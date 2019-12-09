package inferno.infernofour.items;

import inferno.infernofour.InfernoFour;
import net.minecraft.item.Item;

public class ItemNugget extends Item {
    private String name;

    public ItemNugget(String name) {
        this.name = name;
        this.setTranslationKey(name);
    }
    public void registerItemModel() {
        InfernoFour.registerItemRenderer(this, 0, name);
    }
}
