package inferno.infernofour.common.items;

import inferno.infernofour.common.InfernoFour;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGrindingBowl extends Item {
    private String name;

    public ItemGrindingBowl(String name) {
        this.name = name;
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.MATERIALS);
        this.setContainerItem(this);
        this.setMaxStackSize(1);
        this.setMaxDamage(256);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack f = itemStack.copy();
        f.setItemDamage(itemStack.getItemDamage()-1);
        return f;
    }



    public void registerItemModel() {
        InfernoFour.registerItemRenderer(this, 0, name);
    }
}
