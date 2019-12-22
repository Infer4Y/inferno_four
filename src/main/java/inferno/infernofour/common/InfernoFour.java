package inferno.infernofour.common;

import inferno.infernofour.client.gui.GuiCrudeGuideBook;
import inferno.infernofour.common.blocks.Blocks;
import inferno.infernofour.common.creativetabs.TabBuildingBlock;
import inferno.infernofour.common.creativetabs.TabMaterials;
import inferno.infernofour.common.items.Items;
import inferno.infernofour.common.tileentities.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

    public static final TabBuildingBlock BUILDING_BLOCKS = new TabBuildingBlock("if_building_blocks");
    public static final TabMaterials MATERIALS = new TabMaterials("if_materials");

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) { }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addSmelting(Items.steelDust, new ItemStack(Items.steelIngot,1), 0.5f);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) { }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(Items.steelItemBlock.setRegistryName(MOD_ID, "steel_block"));
            event.getRegistry().register(Items.redSteelItemBlock.setRegistryName(MOD_ID, "red_steel_block"));
            event.getRegistry().register(Items.basicReshaperItemBlock.setRegistryName(MOD_ID, "basic_reshaper_block"));
            event.getRegistry().register(Items.heaterItemBlock.setRegistryName(MOD_ID, "heater_block"));
            event.getRegistry().register(Items.basicFrameItemBlock.setRegistryName(MOD_ID, "basic_frame_block"));
            event.getRegistry().register(Items.presserItemBlock.setRegistryName(MOD_ID, "presser_block"));
            event.getRegistry().register(Items.refinedFrameItemBlock.setRegistryName(MOD_ID, "refined_frame_block"));
            event.getRegistry().register(Items.steelIngot.setRegistryName(MOD_ID, "steel_ingot"));
            event.getRegistry().register(Items.steelDust.setRegistryName(MOD_ID, "steel_dust"));
            event.getRegistry().register(Items.steelNugget.setRegistryName(MOD_ID, "steel_nugget"));
            event.getRegistry().register(Items.steelPlate.setRegistryName(MOD_ID, "steel_plate"));
            event.getRegistry().register(Items.crudeGuideBook.setRegistryName(MOD_ID, "crude_guide_book"));
            event.getRegistry().register(Items.grindingBowl.setRegistryName(MOD_ID, "grinding_bowl"));
        }

        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
             event.getRegistry().register(Blocks.steelBlock.setRegistryName(MOD_ID, "steel_block"));
             event.getRegistry().register(Blocks.redSteelBlock.setRegistryName(MOD_ID, "red_steel_block"));
             event.getRegistry().register(Blocks.basicReshaperBlock.setRegistryName(MOD_ID, "basic_reshaper_block"));
             event.getRegistry().register(Blocks.basicFrameBlock.setRegistryName(MOD_ID, "basic_frame_block"));
             event.getRegistry().register(Blocks.refinedFrameBlock.setRegistryName(MOD_ID, "refined_frame_block"));
             event.getRegistry().register(Blocks.heaterBlock.setRegistryName(MOD_ID, "heater_block"));
             event.getRegistry().register(Blocks.presserBlock.setRegistryName(MOD_ID, "presser_block"));

             GameRegistry.registerTileEntity(TileEntityFrame.class, Blocks.basicFrameBlock.getRegistryName().toString());
             GameRegistry.registerTileEntity(TileEntityRefinedFrame.class, Blocks.refinedFrameBlock.getRegistryName().toString());
             GameRegistry.registerTileEntity(TileEntityReshaper.class, Blocks.basicReshaperBlock.getRegistryName().toString());
             GameRegistry.registerTileEntity(TileEntityHeater.class, Blocks.heaterBlock.getRegistryName().toString());
             GameRegistry.registerTileEntity(TileEntityPresser.class, Blocks.presserBlock.getRegistryName().toString());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            Items.registerModels();
        }
    }

    public static void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MOD_ID+ ":" + id, "inventory"));
    }

    @SideOnly(Side.CLIENT)
    public static void openGuideBook(){
        Minecraft.getMinecraft().displayGuiScreen(new GuiCrudeGuideBook());
    }

}
