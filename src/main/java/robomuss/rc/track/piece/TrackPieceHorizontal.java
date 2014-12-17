package robomuss.rc.track.piece;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import robomuss.rc.block.BlockTrackBase;
import robomuss.rc.block.te.TileEntityTrackBase;
import robomuss.rc.entity.EntityTrainDefault;
import robomuss.rc.track.style.TrackStyle;
import robomuss.rc.util.IInventoryRenderSettings;
import sun.org.mozilla.javascript.internal.ast.Block;

public class TrackPieceHorizontal extends TrackPiece implements IInventoryRenderSettings {
	public static final String partName = "horizontal";

	private float[] rotationOffsets = new float[] {180f, 0f, 0f, 0f};
	public Block block;

	public TrackPieceHorizontal(String unlocalized_name, int crafting_cost, int render_stage) {
		super(unlocalized_name, crafting_cost, render_stage);
	}

	public void addTileEntityToList(TileEntityTrackBase teTrack) {
		if (teTrack != null) {
			super.addTileEntityToList(this, teTrack);
		}
	}

//	@Override
//	public void renderItem(int render_stage, IItemRenderer.ItemRenderType render_type, TrackStyle style, BlockTrackBase blockTrack, World world, int x , int y , int z) {
//		IModelCustom model = style.getModel();
//
//		GL11.glTranslatef(getInventoryX(), getInventoryY(), getInventoryZ());
//		GL11.glScalef(0.625f, 0.625f, 0.625f);
//		if (render_type == IItemRenderer.ItemRenderType.EQUIPPED) {
//			GL11.glPushMatrix();
//			GL11.glScalef(2.4f, 2.4f, 2.4f);
//			GL11.glTranslatef(2.5f, -2.6f, 0);
//			this.render(render_stage, model);
//			GL11.glPopMatrix();
//		} else if (render_type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
//			GL11.glPushMatrix();
//			GL11.glScalef(2, 2, 2);
//			GL11.glRotatef(180, 0, 1, 0);
//			GL11.glTranslatef(1, -5.5f, 0);
//			this.render(render_stage, model);
//			GL11.glPopMatrix();
//		} else if (render_type == IItemRenderer.ItemRenderType.INVENTORY) {
//			GL11.glPushMatrix();
//			GL11.glScalef(1.55f, 1.55f, 1.55f);
//			this.render(render_stage, model);
//			GL11.glPopMatrix();
//		} else if (render_type == IItemRenderer.ItemRenderType.ENTITY) {
//			GL11.glPushMatrix();
//			GL11.glScalef(1.5f, 1.5f, 1.5f);
//			this.render(render_stage, model);
//			GL11.glPopMatrix();
//		}
//	}

	@Override
	public void renderTileEntity(int render_stage, TrackStyle style, TileEntityTrackBase teTrack, World world, BlockPos pos) {
//		rotate(teTrack, world, x, y, z);
//
//		IModelCustom model = style.getModel();
//
//		GL11.glPushMatrix();
//		if(style.name.equals("wooden_hybrid_topper")) {
//			//TODO: make other models and get rid of this
////			ResourceLocation textures = (new ResourceLocation("rc:textures/models/colour_" + teTrack.track.colour + ".png"));
////
////			Minecraft.getMinecraft().renderEngine.bindTexture(textures);
////
////			model.renderPart("topper1");
////			model.renderPart("topper2");
////
////			ResourceLocation textures2 = (new ResourceLocation("textures/blocks/planks_oak.png"));
////
////			Minecraft.getMinecraft().renderEngine.bindTexture(textures2);
////
////			model.renderPart("top1");
////			model.renderPart("top2");
////			model.renderPart("bottom1");
////			model.renderPart("bottom2");
//		} else {
//			model.renderPart(partName);
//		}
//		GL11.glPopMatrix();
	}
	
	@Override
	public void moveTrain(BlockTrackBase track, EntityTrainDefault entity, TileEntityTrackBase teTrack) {
		if (teTrack != null) {
			EnumFacing trackFacing = (EnumFacing) teTrack.getWorld().getBlockState(teTrack.getPos()).getValue(BlockTrackBase.FACING);
			EnumFacing entityFacing = entity.getHorizontalFacing();

			switch (trackFacing) {
				case NORTH: break;
				case SOUTH: break;
				case WEST:  break;
				case EAST:  break;
			}
		}
	}
	
	@Override
	public AxisAlignedBB getBlockBounds(IBlockAccess iba, BlockPos pos) {
		return AxisAlignedBB.fromBounds(0, 0, 0, 1, 0.4f, 1);
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
