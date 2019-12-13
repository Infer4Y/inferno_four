package inferno.infernofour;

import inferno.infernofour.blocks.Blocks;
import inferno.infernofour.items.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = InfernoFour.MOD_ID,
        name = InfernoFour.MOD_NAME,
        version = InfernoFour.VERSION
)
public class InfernoFour {

    public static final String MOD_ID = "infernofour";
    public static final String MOD_NAME = "Inferno Four";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static InfernoFour INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) { }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) { }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) { }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(Items.steelItemBlock.setRegistryName(MOD_ID, "steel_block"));
            event.getRegistry().register(Items.basicReshaperItemBlock.setRegistryName(MOD_ID, "basic_reshaper_block"));
            event.getRegistry().register(Items.basicFrameItemBlock.setRegistryName(MOD_ID, "basic_frame_block"));
            event.getRegistry().register(Items.steelIngot.setRegistryName(MOD_ID, "steel_ingot"));
            event.getRegistry().register(Items.steelNugget.setRegistryName(MOD_ID, "steel_nugget"));
            event.getRegistry().register(Items.steelPlate.setRegistryName(MOD_ID, "steel_plate"));
             //event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
        }

        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
             event.getRegistry().register(Blocks.steelBlock.setRegistryName(MOD_ID, "steel_block"));
             event.getRegistry().register(Blocks.basicReshaperBlock.setRegistryName(MOD_ID, "basic_reshaper_block"));
             event.getRegistry().register(Blocks.basicFrameBlock.setRegistryName(MOD_ID, "basic_frame_block"));
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            Items.registerModels();
        }
    }

    public static void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MOD_ID+ ":" + id, "inventory"));
    }

}
