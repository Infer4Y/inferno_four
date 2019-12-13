package inferno.infernofour.blocks;

import inferno.infernofour.InfernoFour;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Blocks {
    public static final BlockFrame basicFrameBlock = new BlockFrame("basic_frame_block");
    public static final BlockMetal steelBlock = new BlockMetal("steel_block");
    public static final BlockMetal basicReshaperBlock = new BlockMetal("basic_reshaper_block");

}
