package robomuss.rc.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modforgery.forgerylib.ChatColours;
import modforgery.forgerylib.GuiUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import robomuss.rc.block.container.ContainerTrackFabricator;
import robomuss.rc.block.te.TileEntityTrackFabricator;
import robomuss.rc.network.NetworkHandler;
import robomuss.rc.track.TrackHandler;

import java.awt.event.KeyEvent;
import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class GuiTrackFabricator extends GuiContainer {
	private TileEntityTrackFabricator te;
	private int current_track;
	private int amount = 1;
	private GuiTextField textField;

    private static final ResourceLocation trackFabricatorGuiTextures = new ResourceLocation("rc", "textures/gui/track_fabricator.png");
    
    public GuiTrackFabricator(InventoryPlayer inventoryPlayer, EntityPlayer player, TileEntityTrackFabricator te, World world, int x, int y, int z) {
        super(new ContainerTrackFabricator(inventoryPlayer, player, te, world, x, y, z));
        this.te = te;
    }

	public TileEntityTrackFabricator getTileEntity() {
		return this.te;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;

		buttonList.clear();
		
		buttonList.add(new GuiButton(0, k + 82, l + 20, 20, 20, "<"));
		buttonList.add(new GuiButton(1, k + 104, l + 20, 20, 20, ">"));
		buttonList.add(new GuiButton(2, k + 82, l + 48, 20, 20, "-"));
		buttonList.add(new GuiButton(3, k + 104, l + 48, 20, 20, "+"));
		buttonList.add(new GuiButton(4, k + 126, l + 20, 40, 20, "Craft"));
		
		textField = new GuiTextField(fontRendererObj, k + 127, l + 49, 38, 18);
		textField.setFocused(false);
		textField.setMaxStringLength(2);
		textField.setText("" + amount);
	}


    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString("Fabricating", 8, 6, ChatColours.DARK_GRAY);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 3, ChatColours.DARK_GRAY);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(trackFabricatorGuiTextures);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
	    GuiUtils.renderBlockIntoGui(TrackHandler.getTrackTypeFromID(current_track).type.block, centerX + 35, centerY + 28, 2f, this.fontRendererObj, this.mc);
    }
    
    @Override
	public void keyTyped(char c, int i) {
		super.keyTyped(c, i);
		if(Character.toString(c).matches("[0-9]") || c == (char) KeyEvent.VK_BACK_SPACE) {
			textField.textboxKeyTyped(c, i);
		}
	}
	
	@Override
	public void mouseClicked(int i, int j, int k) {
		super.mouseClicked(i, j, k);
		textField.mouseClicked(i, j, k);

		if(!textField.isFocused()) {
			if(Integer.parseInt(textField.getText()) == 0) {
				amount = 1;
				textField.setText("" + amount);
			} else if(Integer.parseInt(textField.getText()) > 64) {
				amount = 64;
				textField.setText("" + amount);
			} else {
				amount = Integer.parseInt(textField.getText());
			}
		}
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		super.drawScreen(x, y, f);
		textField.drawTextBox();
		
		int k = (this.width - this.xSize) / 2;
	    int l = (this.height - this.ySize) / 2;

		Rectangle box = new Rectangle(k + 26, l + 18, 52, 52);
		Rectangle mouse = new Rectangle(x, y, 1, 1);

		if(mouse.intersects(box)) {
			String name = TrackHandler.getTrackTypeFromID(current_track).type.block.getLocalizedName();
			int num = TrackHandler.getTrackTypeFromID(current_track).craftingCost * amount;
			String line2 = String.format("%d Iron Ingots (%d per track)", num, TrackHandler.getTrackTypeFromID(current_track).craftingCost);
			drawHoveringText(Arrays.asList(name, line2, "========================", "Try SHIFT-clicking the + & -"), x, y, fontRendererObj);
		}
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		int id = button.id;

		if(id == 0) {
			current_track = current_track == 0 ? TrackHandler.Types.values().length - 1 : current_track - 1;
		}

		if(id == 1) {
			current_track = current_track < TrackHandler.Types.values().length - 1 ? current_track + 1 : 0;
		}

		if(id == 2) {
			if(isShiftKeyDown()) {
				amount = 1;
			} else {
				amount += amount == 1 ? 0 : -1;
			}

			textField.setText("" + amount);
		}

		if(id == 3) {
			if(isShiftKeyDown()) {
				amount = 64;
			} else {
				amount += amount < 64 ? 1 : 0;
			}

			textField.setText("" + amount);
		}

		if(id == 4) {
			NetworkHandler.updateTrackFabricatorTE(te, current_track, amount);
		}
	}
}