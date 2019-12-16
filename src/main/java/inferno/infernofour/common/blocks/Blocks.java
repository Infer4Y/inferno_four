package inferno.infernofour.common.blocks;

import inferno.infernofour.common.InfernoFour;
import inferno.infernofour.common.utils.Frames;
import inferno.infernofour.common.utils.Metals;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Blocks {
    public static final BlockFrame basicFrameBlock = new BlockFrame("basic_frame_block", Frames.BASIC);
    public static final BlockFrame refinedFrameBlock = new BlockFrame("refined_frame_block", Frames.REFINED);
    public static final BlockMetal steelBlock = new BlockMetal("steel_block", Metals.STEEL);
    public static final BlockMetal redSteelBlock = new BlockMetal("red_steel_block", Metals.REDSTEEL);
    public static final BlockReshaper basicReshaperBlock = new BlockReshaper("basic_reshaper_block");
    public static final BlockHeater heaterBlock = new BlockHeater("heater_block");

}
