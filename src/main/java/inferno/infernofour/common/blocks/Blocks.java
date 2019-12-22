package inferno.infernofour.common.blocks;

import inferno.infernofour.common.InfernoFour;
import inferno.infernofour.common.utils.Frames;
import inferno.infernofour.common.utils.Metals;
import net.minecraft.block.Block;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;
import java.util.Set;

@GameRegistry.ObjectHolder(InfernoFour.MOD_ID)
public class Blocks {
    public static final BlockFrame basicFrameBlock = new BlockFrame("basic_frame_block", Frames.BASIC);
    public static final BlockFrame refinedFrameBlock = new BlockFrame("refined_frame_block", Frames.REFINED);
    public static final BlockMetal steelBlock = new BlockMetal("steel_block", Metals.STEEL);
    public static final BlockMetal redSteelBlock = new BlockMetal("red_steel_block", Metals.REDSTEEL);
    public static final BlockReshaper basicReshaperBlock = new BlockReshaper("basic_reshaper_block");
    public static final BlockHeater heaterBlock = new BlockHeater("heater_block");
    public static final BlockPresser presserBlock = new BlockPresser("presser_block");

    static {
        Set<Block> heated = new HashSet<>();
        heated.add(redSteelBlock);
        heated.add(net.minecraft.init.Blocks.LAVA);
        heated.add(net.minecraft.init.Blocks.FLOWING_LAVA);
        heated.add(net.minecraft.init.Blocks.MAGMA);
        heated.add(net.minecraft.init.Blocks.FIRE);
        heated.add(net.minecraft.init.Blocks.LIT_FURNACE);

        Set<Block> chilled = new HashSet<>();
        heated.add(net.minecraft.init.Blocks.WATER);
        heated.add(net.minecraft.init.Blocks.FLOWING_WATER);
        heated.add(net.minecraft.init.Blocks.ICE);
        heated.add(net.minecraft.init.Blocks.PACKED_ICE);
        heated.add(net.minecraft.init.Blocks.FROSTED_ICE);

        BlockMetal.setHeated(heated);
        BlockMetal.setChilled(chilled);

    }

}
