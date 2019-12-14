package inferno.infernofour.blocks;

import inferno.infernofour.InfernoFour;
import inferno.infernofour.utils.Metals;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Blocks {
    public static final BlockFrame basicFrameBlock = new BlockFrame("basic_frame_block");
    public static final BlockMetal steelBlock = new BlockMetal("steel_block", Metals.STEEL);
    public static final BlockMetal redSteelBlock = new BlockMetal("red_steel_block", Metals.REDSTEEL);
    public static final BlockReshaper basicReshaperBlock = new BlockReshaper("basic_reshaper_block");

}
