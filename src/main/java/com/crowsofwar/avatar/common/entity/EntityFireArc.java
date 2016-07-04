package com.crowsofwar.avatar.common.entity;

import com.crowsofwar.avatar.common.util.VectorUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFireArc extends Entity implements IPhysics {
	
	public static final Vec3 GRAVITY = Vec3.createVectorHelper(0, -9.81 / 20, 0);
	private static final int DATAWATCHER_ID = 3, DATAWATCHER_VELX = 4, DATAWATCHER_VELY = 5, DATAWATCHER_VELZ = 6,
			DATAWATCHER_GRAVITY = 7;
	
	private static int nextId = 1;
	private ControlPoint[] points;
	
	private Vec3 internalPos;
	private Vec3 internalVelocity;
	
	public EntityFireArc(World world) {
		super(world);
		setSize(0.2f, 0.2f);
		this.points = new ControlPoint[] {
			new ControlPoint(0, 0, 0),
			new ControlPoint(0, 0, 0),
			new ControlPoint(0, 0, 0)
		};
		this.internalPos = Vec3.createVectorHelper(0, 0, 0);
		this.internalVelocity = Vec3.createVectorHelper(0, 0, 0);
		if (!worldObj.isRemote) setId(nextId++);
	}
	
	@Override
	protected void entityInit() {
		dataWatcher.addObject(DATAWATCHER_ID, 0);
		dataWatcher.addObject(DATAWATCHER_VELX, 0f);
		dataWatcher.addObject(DATAWATCHER_VELY, 0f);
		dataWatcher.addObject(DATAWATCHER_VELZ, 0f);
		dataWatcher.addObject(DATAWATCHER_GRAVITY, (byte) 0);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (isGravityEnabled()) {
			addVelocity(GRAVITY);
		}
		Vec3 velocity = getVelocity();
		moveEntity(velocity.xCoord / 20, velocity.yCoord / 20, velocity.zCoord / 20);
		points[0].setPosition(posX, posY, posZ);
		if (isCollided) {
			setDead();
		}
		
		for (int i = 1; i < points.length; i++) {
			ControlPoint leader = points[i - 1];
			ControlPoint p = points[i];
			double dist = p.getDistance(leader);
			if (dist > 20) {
				p.setPosition(leader.getXPos(), leader.getYPos(), leader.getZPos());
			} else if (dist > 2) {
				Vec3 diff = VectorUtils.minus(leader.getPos(), p.getPos());
				diff.normalize();
				VectorUtils.mult(diff, 0.05*3);
				p.move(diff);
			}
		}
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		setDead();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		
	}
	
	@Override
	public void setPosition(double x, double y, double z) {
		super.setPosition(x, y, z);
		// Set position called in entity constructor
		if (points != null) points[0].setPosition(x, y, z);
	}
	
	public ControlPoint[] getControlPoints() {
		return points;
	}
	
	public ControlPoint getControlPoint(int index) {
		return points[index];
	}
	
	public int getId() {
		return dataWatcher.getWatchableObjectInt(DATAWATCHER_ID);
	}
	
	public void setId(int id) {
		dataWatcher.updateObject(DATAWATCHER_ID, id);
	}
	
	public static EntityFireArc findFromId(World world, int id) {
		for (Object obj : world.loadedEntityList) {
			if (obj instanceof EntityFireArc && ((EntityFireArc) obj).getId() == id) return (EntityFireArc) obj;
		}
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isInRangeToRenderDist(double d) {
		return true;
	}
	
	@Override
	public Vec3 getPosition() {
		internalPos.xCoord = posX;
		internalPos.yCoord = posY;
		internalPos.zCoord = posZ;
		return internalPos;
	}

	@Override
	public Vec3 getVelocity() {
		internalVelocity.xCoord = dataWatcher.getWatchableObjectFloat(DATAWATCHER_VELX);
		internalVelocity.yCoord = dataWatcher.getWatchableObjectFloat(DATAWATCHER_VELY);
		internalVelocity.zCoord = dataWatcher.getWatchableObjectFloat(DATAWATCHER_VELZ);
		return internalVelocity;
	}

	@Override
	public void setVelocity(Vec3 vel) {
		if (!worldObj.isRemote) {
			dataWatcher.updateObject(DATAWATCHER_VELX, (float) vel.xCoord);
			dataWatcher.updateObject(DATAWATCHER_VELY, (float) vel.yCoord);
			dataWatcher.updateObject(DATAWATCHER_VELZ, (float) vel.zCoord);
		}
	}
	
	@Override
	public void addVelocity(Vec3 vel) {
		setVelocity(VectorUtils.plus(getVelocity(), vel));
	}
	
	public boolean isGravityEnabled() {
		return dataWatcher.getWatchableObjectByte(DATAWATCHER_GRAVITY) == 1;
	}
	
	public void setGravityEnabled(boolean enabled) {
		dataWatcher.updateObject(DATAWATCHER_GRAVITY, (byte) (enabled ? 1 : 0));
	}
	
	public class ControlPoint {
		
		private Vec3 position;
		
		public ControlPoint(double x, double y, double z) {
			position = Vec3.createVectorHelper(x, y, z);
		}
		
		public void setPosition(double x, double y, double z) {
			position.xCoord = x;
			position.yCoord = y;
			position.zCoord = z;
		}
		
		public void setPosition(Vec3 pos) {
			setPosition(pos.xCoord, pos.yCoord, pos.zCoord);
		}
		
		public void move(double x, double y, double z) {
			position.xCoord += x;
			position.yCoord += y;
			position.zCoord += z;
		}
		
		public void move(Vec3 offset) {
			move(offset.xCoord, offset.yCoord, offset.zCoord);
		}
		
		public double getXPos() {
			return position.xCoord;
		}
		
		public double getYPos() {
			return position.yCoord;
		}
		
		public double getZPos() {
			return position.zCoord;
		}
		
		public Vec3 getPos() {
			return position;
		}
		
		public double getDistance(ControlPoint point) {
			return position.distanceTo(point.getPos());
		}
		
	}

}
