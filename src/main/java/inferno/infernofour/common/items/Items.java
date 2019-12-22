package inferno.infernofour.common.items;

import inferno.infernofour.common.InfernoFour;
import inferno.infernofour.common.blocks.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Items {

    public static final ItemIngot steelIngot = new ItemIngot("steel_ingot");
    public static final ItemDust steelDust = new ItemDust("steel_dust");
    public static final ItemNugget steelNugget = new ItemNugget("steel_nugget");
    public static final ItemPlate steelPlate = new ItemPlate("steel_plate");
    public static final ItemCrudeGuideBook crudeGuideBook = new ItemCrudeGuideBook("crude_guide_book");

    public static final ItemGrindingBowl grindingBowl = new ItemGrindingBowl("grinding_bowl");

    public static final ItemBlockItem steelItemBlock = new ItemBlockItem(Blocks.steelBlock, "steel_block");
    public static final ItemBlockItem redSteelItemBlock = new ItemBlockItem(Blocks.redSteelBlock, "red_steel_block");
    public static final ItemBlockItem basicReshaperItemBlock = new ItemBlockItem(Blocks.basicReshaperBlock, "basic_reshaper_block");
    public static final ItemBlockItem basicFrameItemBlock = new ItemBlockItem(Blocks.basicFrameBlock, "basic_frame_block");
    public static final ItemBlockItem refinedFrameItemBlock = new ItemBlockItem(Blocks.refinedFrameBlock, "refined_frame_block");
    public static final ItemBlockItem heaterItemBlock = new ItemBlockItem(Blocks.heaterBlock, "heater_block");
    public static final ItemBlockItem presserItemBlock = new ItemBlockItem(Blocks.presserBlock, "presser_block");

    public static void registerModels() {
        steelIngot.registerItemModel();
        steelDust.registerItemModel();
        steelNugget.registerItemModel();
        steelPlate.registerItemModel();
        crudeGuideBook.registerItemModel();
        grindingBowl.registerItemModel();

        steelItemBlock.registerItemModel();
        redSteelItemBlock.registerItemModel();
        basicReshaperItemBlock.registerItemModel();
        basicFrameItemBlock.registerItemModel();
        refinedFrameItemBlock.registerItemModel();
        heaterItemBlock.registerItemModel();
        presserItemBlock.registerItemModel();
    }
}
