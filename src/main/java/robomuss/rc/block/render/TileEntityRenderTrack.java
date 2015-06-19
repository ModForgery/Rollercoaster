package robomuss.rc.block.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import robomuss.rc.block.model.ModelCorkscrewCoaster;
import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.rollercoaster.RollercoasterType;
import robomuss.rc.track.TrackHandler;
import robomuss.rc.track.TrackType;
import robomuss.rc.util.ColourUtil;


public class TileEntityRenderTrack extends TileEntitySpecialRenderer {
	
	public static TileEntityRenderTrack instance = new TileEntityRenderTrack();
	private RollercoasterType type;
	
	
	private ResourceLocation textures = ColourUtil.textures.get(0);
	private ResourceLocation textures2 = (new ResourceLocation("rc:textures/models/catwalk2.png"));
	public static int count;
	
	int animation;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		type = ((TileEntityTrack) te).type;
		if(type == null) {
			type = TrackHandler.types.get(0);
		}
		int colour = ((TileEntityTrack) te).colour;
		
		if(colour == ColourUtil.colours.length - 1) {
			colour = count % (ColourUtil.colours.length - 1);
		}
		
		if(!textures.getResourcePath().contains("colour_" + colour)) {
			textures = ColourUtil.textures.get(colour);
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		
		Block block = te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord);
		TrackType track_type = TrackHandler.findTrackTypeFull(block.getUnlocalizedName());
		if(track_type != null) {
			if(track_type.special_render_stages == 0) {
				GL11.glPushMatrix();
				GL11.glTranslatef(track_type.getX(x, (TileEntityTrack) te), track_type.getY(y, (TileEntityTrack) te), track_type.getZ(z, (TileEntityTrack) te));
				GL11.glPushMatrix();
				if(track_type.inverted) {
					GL11.glRotatef(180, 1, 0, 0);
				}
				track_type.render(type, (TileEntityTrack) te);
				//ModelBase model = track_type.render(type, (TileEntityTrack) te);
				/*ModelBase model = new ModelCorkscrewCoaster();
				
				if(model instanceof ModelCorkscrewCoaster) {
					ModelCorkscrewCoaster mcc = (ModelCorkscrewCoaster) model;
					
					if(((TileEntityTrack) te).hasCatwalk && track_type == TrackHandler.tracks.get(0)) {
						Minecraft.getMinecraft().renderEngine.bindTexture(textures2);
						
						mcc.Catwalk1.render(0.0625F);
						mcc.Catwalk2.render(0.0625F);
					}
				}*/
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
			
			for(int i = 0; i < track_type.special_render_stages; i++) { 
				GL11.glPushMatrix();
				GL11.glTranslatef(track_type.getSpecialX(i, x, (TileEntityTrack) te), track_type.getSpecialY(i, y, (TileEntityTrack) te), track_type.getSpecialZ(i, z, (TileEntityTrack) te));
				GL11.glPushMatrix();
				if(track_type.inverted) {
					GL11.glRotatef(180, 1, 0, 0);
				}
				track_type.renderSpecial(i, type, (TileEntityTrack) te);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
			
			if(((TileEntityTrack) te).extra != null && ((TileEntityTrack) te).extra.allowedTrackTypes.contains(track_type)) {
				Minecraft.getMinecraft().renderEngine.bindTexture(((TileEntityTrack) te).extra.texture);
				
				GL11.glPushMatrix();
				GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F,(float) z + 0.5F);
				GL11.glPushMatrix();
				TrackType.rotate((TileEntityTrack) te);
				((TileEntityTrack) te).extra.render(track_type);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
				
				for(int i = 0; i < ((TileEntityTrack) te).extra.special_render_stages; i++) {
					GL11.glPushMatrix();
					GL11.glTranslatef(((TileEntityTrack) te).extra.getSpecialX(i, x, (TileEntityTrack) te), ((TileEntityTrack) te).extra.getSpecialY(i, y, (TileEntityTrack) te), ((TileEntityTrack) te).extra.getSpecialZ(i, z, (TileEntityTrack) te));
					GL11.glPushMatrix();
					TrackType.rotate((TileEntityTrack) te);
					((TileEntityTrack) te).extra.renderSpecial(i, track_type, (TileEntityTrack) te);
					GL11.glPopMatrix();
					GL11.glPopMatrix();
				}
			}
		}
	}
}
