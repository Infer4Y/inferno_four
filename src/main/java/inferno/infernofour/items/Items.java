package inferno.infernofour.items;

import inferno.infernofour.InfernoFour;
import inferno.infernofour.blocks.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Items {

    public static final ItemIngot steelIngot = new ItemIngot("steel_ingot");
    public static final ItemNugget steelNugget = new ItemNugget("steel_nugget");
    public static final ItemPlate steelPlate = new ItemPlate("steel_plate");

    public static final ItemBlockItem steelItemBlock = new ItemBlockItem(Blocks.steelBlock, "steel_block");
    public static final ItemBlockItem redSteelItemBlock = new ItemBlockItem(Blocks.redSteelBlock, "red_steel_block");
    public static final ItemBlockItem basicReshaperItemBlock = new ItemBlockItem(Blocks.basicReshaperBlock, "basic_reshaper_block");
    public static final ItemBlockItem basicFrameItemBlock = new ItemBlockItem(Blocks.basicFrameBlock, "basic_frame_block");

    public static void registerModels() {
        steelIngot.registerItemModel();
        steelNugget.registerItemModel();
        steelPlate.registerItemModel();

        steelItemBlock.registerItemModel();
        basicReshaperItemBlock.registerItemModel();
        basicFrameItemBlock.registerItemModel();
    }
}
