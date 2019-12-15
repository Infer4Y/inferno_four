package inferno.infernofour.common.items;

import inferno.infernofour.common.InfernoFour;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCrudeGuideBook extends Item {
    private String name;

    public ItemCrudeGuideBook(String name) {
        this.name = name;
        this.setTranslationKey(name);
        this.setCreativeTab(InfernoFour.MATERIALS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        InfernoFour.openGuideBook();
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public void registerItemModel() {
        InfernoFour.registerItemRenderer(this, 0, name);
    }
}
