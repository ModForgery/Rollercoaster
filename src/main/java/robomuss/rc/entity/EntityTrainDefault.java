package robomuss.rc.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import robomuss.rc.block.BlockTrack;
import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.network.NetworkHandler;
import robomuss.rc.tracks.TrackHandler;
import robomuss.rc.tracks.TrackType;

public class EntityTrainDefault extends EntityTrain
{
    private static final String __OBFID = "CL_00001677";

    public EntityTrainDefault(World p_i1722_1_)
    {
        super(p_i1722_1_);
    }

    public EntityTrainDefault(World p_i1723_1_, double p_i1723_2_, double p_i1723_4_, double p_i1723_6_)
    {
        super(p_i1723_1_, p_i1723_2_, p_i1723_4_, p_i1723_6_);
    }

    /**
     * First layer of player interaction
     */
    public boolean interactFirst(EntityPlayer player)
    {
    	//TODO
        //if(net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, p_130002_1_))) return true;
        if (!this.worldObj.isRemote) {
        	if(player.isSneaking()) {
        		System.out.println("Sneaking!");
        		this.setDead();
        	}
        	else {
        		player.mountEntity(this);
        	}
        }
        return true;
    }

    public int getMinecartType()
    {
        return 0;
    }
    
    boolean firstTick = false;
    boolean selfPowered = true;
    boolean onSlope = false;
    int count = 0;
    
    @Override
    public void onUpdate() {
    	TileEntity tileentity = null;
    	if(onSlope) {
    		tileentity = worldObj.getTileEntity((int) posX - 1, (int) posY + 1, (int) posZ + 1);
    	}
    	else {
    		tileentity = worldObj.getTileEntity((int) posX - 1, (int) posY, (int) posZ);
    	}
    	if(!firstTick) {
    		rotateOnPlace(tileentity);
	    	firstTick = true;
    	}
    	if(firstTick) {
    		//if(worldObj.isRemote) {
		    	if(selfPowered) {
		    		if((tileentity != null & tileentity instanceof TileEntityTrack) /*|| onSlope*/) {
		    			TileEntityTrack te = (TileEntityTrack) tileentity;
				    	if(getTrackTypeFromTE(tileentity) == TrackHandler.findTrackType("horizontal")) {
				    		if(te.direction == 0) {
				    			this.posZ += 0.1f;
				    		}
				    		if(te.direction == 2) {
				    			this.posZ -= 0.1f;
				    		}
				    	}
				    	if(getTrackTypeFromTE(tileentity) == TrackHandler.findTrackType("slope_up")) {
				    		if(te.direction == 0) {
				    			this.posZ += 1f;
				    			
				    		}
				    		if(te.direction == 2) {
				    			this.posZ -= 1f;
				    		}
				    		this.rotationPitch = 45f;
				    		this.posY += 1f;
				    		//onSlope = true;
				    	}
				    	if(getTrackTypeFromTE(tileentity) == TrackHandler.findTrackType("slope")) {
				    		this.posY += 1f;
				    		this.posZ += 1f;

				    	}
				    	if(getTrackTypeFromTE(tileentity) == TrackHandler.findTrackType("slope_down")) {
				    		this.posY += 1f;
				    		this.posZ += 3f;
				    		this.rotationPitch = 0f;
				    	}
				    	/*if(onSlope) {
				    		this.posY += 0.1f;
				    		this.posZ += 0.1f;
				    		count++;
				    		if(count >= 10) {
				    			count = 0;
				    			onSlope = false;
				    		}
				    	}*/
		    		}
		    		else {
		    			System.out.println("OOhhh?");
		    		}
		    	}
	    	//}
    	}
    }
    
    private TrackType getTrackTypeFromTE(TileEntity tileentity) {
    	TileEntityTrack te = (TileEntityTrack) tileentity;
    	BlockTrack block = (BlockTrack) te.getBlockType();
		return block.track_type;
	}
    
    private void rotateOnPlace(TileEntity tileentity) {
    	if(tileentity != null & tileentity instanceof TileEntityTrack) {
    		TileEntityTrack te = (TileEntityTrack) tileentity;
	    	if(getTrackTypeFromTE(tileentity) == TrackHandler.findTrackType("horizontal")) {
	    		if(te.direction == 0) {
	    			this.rotationYaw = 90f;
	    		}
	    		else if(te.direction == 1) {
	    			this.rotationYaw = 0f;
	    		}
	    		else if(te.direction == 2) {
	    			this.rotationYaw = 270f;
	    		}
	    		else if(te.direction == 3) {
	    			this.rotationYaw = 180f;
	    		}
	    	}
    	}
	}

	@Override
    public AxisAlignedBB getBoundingBox() {
    	return AxisAlignedBB.getBoundingBox(-1, -1, -1, 3, 3, 3);
    }
}