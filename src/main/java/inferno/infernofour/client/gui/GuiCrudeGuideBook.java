package inferno.infernofour.client.gui;

import inferno.infernofour.common.InfernoFour;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiCrudeGuideBook extends GuiScreen
{
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 4;
    private static ResourceLocation[] bookPageTextures =
            new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;

    public GuiCrudeGuideBook() {
        bookPageTextures[0] = new ResourceLocation(
                InfernoFour.MOD_ID+":textures/gui/book_cover.png");
        bookPageTextures[1] = new ResourceLocation(
                InfernoFour.MOD_ID+":textures/gui/book_page.png");
        bookPageTextures[2] = new ResourceLocation(
                InfernoFour.MOD_ID+":textures/gui/book_page.png");
        stringPageText[0] = TextFormatting.GOLD.getColorIndex()+"\n\n\n\n\n\n\nStarting Guidebook\n\nBy : inferno4you";
        stringPageText[1] = "Welcome to Inferno Four.\nThis mod will have many different ways to do things, but this guide will show you how to get a hang of tha basics.";
        stringPageText[2]="Block Steel\nUsed to craft ingots,...\nWhen flint and steel are used on it it will become hot.\nYou can cool Heated Steel with ice and or water buckets.";
        stringPageText[3]="";
    }

    @Override
    public void initGui() {
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight,
                98, 20, I18n.format("gui.done"));
        buttonDone.packedFGColour = 0xFF00FF;

        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1,
                offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2,
                offsetFromScreenLeft + 38, 156, false));
    }

    @Override
    public void updateScreen() {
        buttonDone.visible = (currPage == bookTotalPages - 1);
        buttonNextPage.visible = (currPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currPage > 0;
    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float partialTicks) {
        if (currPage == 0) {
            mc.getTextureManager().bindTexture(bookPageTextures[0]);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        } else {
            mc.getTextureManager().bindTexture(bookPageTextures[1]);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth,
                bookImageHeight);
        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator",
                new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
        widthOfString = fontRenderer.getStringWidth(stringPageIndicator);
        if (!(currPage == 0)) {
            fontRenderer.drawString(stringPageIndicator,
                    offsetFromScreenLeft - widthOfString + bookImageWidth - 44,
                    18, 0);
            fontRenderer.drawSplitString(stringPageText[currPage],
                    offsetFromScreenLeft + 36, 34, 116, 0);
        } else {
            fontRenderer.FONT_HEIGHT = 20;
            fontRenderer.drawSplitString(stringPageText[currPage],
                    offsetFromScreenLeft + 36, 34, 116, 1);
        }

        super.drawScreen(parWidth, parHeight, partialTicks);

    }

    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY,
                                  int parLastButtonClicked, long parTimeSinceMouseClick) {

    }

    @Override
    protected void actionPerformed(GuiButton parButton)
    {
        if (parButton == buttonDone) {
            mc.displayGuiScreen((GuiScreen)null);
        } else if (parButton == buttonNextPage) {
            if (currPage < bookTotalPages - 1) {
                ++currPage;
            }
        } else if (parButton == buttonPreviousPage) {
            if (currPage > 0) {
                --currPage;
            }
        }
    }

    @Override
    public void onGuiClosed() { }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY,
                              boolean parIsNextButton) {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }

        @Override
        public void drawButton(Minecraft mc, int parY, int parX, float partialTicks) {
            if (visible) {
                boolean isButtonPressed = (parX >= x
                        && parY >= y
                        && parX < x + width
                        && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed) {
                    textureX += 23;
                }

                if (!isNextButton) {
                    textureY += 13;
                }

                drawTexturedModalRect(x, y,
                        textureX, textureY,
                        23, 13);
            }
        }
    }
}
