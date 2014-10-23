package robomuss.rc.track.piece;

import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import robomuss.rc.block.BlockTrackBase;
import robomuss.rc.block.model.ModelRMCTopperCoaster;
//import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.block.te.TileEntityTrackBase;
import robomuss.rc.entity.EntityTrainDefault;
import robomuss.rc.track.style.TrackStyle;
import robomuss.rc.util.IInventoryRenderSettings;
import sun.org.mozilla.javascript.internal.ast.Block;

public class TrackPieceHorizontal extends TrackPiece implements IInventoryRenderSettings {
	private float[] rotationOffsets = new float[] {180f, 0f, 0f, 0f};
	public Block block;

	public TrackPieceHorizontal(String unlocalized_name, int crafting_cost) {
		super(unlocalized_name, crafting_cost);
	}

	@Override
	public void render(TrackStyle type, BlockTrackBase track, World world, int x ,int y, int z) {
        TileEntityTrackBase tileEntity = (TileEntityTrackBase) world.getTileEntity(x, y, z);
		if (tileEntity != null && tileEntity.direction != null) {
			rotationOffsets = track.track_type.getRotationOffsetsFromDirection(tileEntity.direction);
		} else if (tileEntity != null) {
            tileEntity.direction = ForgeDirection.SOUTH;
			rotationOffsets = track.track_type.getRotationOffsetsFromDirection(tileEntity.direction);
		}


//		track.track_type.rotate(track);
//		System.out.println(track.direction.toString());
		
		IModelCustom model = (IModelCustom) type.getStandardModel();

		GL11.glPushMatrix();
		GL11.glRotatef(rotationOffsets[0], rotationOffsets[1], rotationOffsets[2], rotationOffsets[3]);
		if(type.name.equals("wooden_hybrid_topper")) {
			ResourceLocation textures = (new ResourceLocation("rc:textures/models/colour_" + track.colour + ".png"));

			Minecraft.getMinecraft().renderEngine.bindTexture(textures);
			
			model.renderPart("topper1");
			model.renderPart("topper2");
			
			ResourceLocation textures2 = (new ResourceLocation("textures/blocks/planks_oak.png"));

			Minecraft.getMinecraft().renderEngine.bindTexture(textures2);
			
			model.renderPart("top1");
			model.renderPart("top2");
			model.renderPart("bottom1");
			model.renderPart("bottom2");
		} else {
			model.renderAll();
		}
		GL11.glPopMatrix();

//		track.track_type.unRotate(track);
	}
	
	@Override
	public void moveTrain(BlockTrackBase track, EntityTrainDefault entity, TileEntityTrackBase tileEntityTrackBase) {
//		if(track.direction == ForgeDirection.SOUTH || track.direction == ForgeDirection.NORTH) {
//			if(entity.direction.ordinal() - 2 == 0) {
//				entity.posZ += entity.speed;
//			}
//			if(entity.direction.ordinal() - 2 == 2) {
//				entity.posZ -= entity.speed;
//			}
//		}
//		if(track.direction == ForgeDirection.WEST || track.direction == ForgeDirection.EAST) {
//			if(entity.direction.ordinal() - 2 == 1) {
//				entity.posX += entity.speed;
//			}
//			if(entity.direction.ordinal() - 2 == 3) {
//				entity.posX -= entity.speed;
//			}
//		}
		switch (tileEntityTrackBase.direction) {
			case NORTH:
			case SOUTH:
				switch (entity.direction) {
					case NORTH: entity.posZ -= entity.speed; break;
					case SOUTH: entity.posZ += entity.speed; break;
				}
				break;
			case WEST:
			case EAST:
				switch (entity.direction) {
					case WEST: entity.posX += entity.speed; break;
					case EAST: entity.posX -= entity.speed; break;
				}
		}
	}
	
	@Override
	public AxisAlignedBB getBlockBounds(IBlockAccess iba, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(0, 0, 0, 1, 0.4F, 1);
	}

	//TODO: fix item rendering!!!
	@Override
	public float getInventoryX() {
		return 0;
	}

	@Override
	public float getInventoryY() {
		return -1f;
	}

	@Override
	public float getInventoryZ() {
		return 0;
	}

	@Override
	public float getInventoryScale() {
		return 1f;
	}

	@Override
	public float getInventoryRotation() {
		return 180f;
	}

	@Override
	public boolean useIcon() {
		return false;
	}
}
