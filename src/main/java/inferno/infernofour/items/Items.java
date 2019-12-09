package inferno.infernofour.items;

import inferno.infernofour.InfernoFour;
import inferno.infernofour.blocks.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Items {

    public static final ItemIngot steelIngot = new ItemIngot("steelIngot");
    public static final ItemNugget steelNugget = new ItemNugget("steelNugget");
    public static final ItemPlate steelPlate = new ItemPlate("steelPlate");
    public static final ItemBlock steelItemBlock = new ItemBlock(Blocks.steelBlock);
    public static final ItemBlock basicReshaperItemBlock = new ItemBlock(Blocks.basicReshaperBlock);

}
