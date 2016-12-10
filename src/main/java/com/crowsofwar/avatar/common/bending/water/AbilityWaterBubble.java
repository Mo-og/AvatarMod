/* 
  This file is part of AvatarMod.
    
  AvatarMod is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.
  
  AvatarMod is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.
  
  You should have received a copy of the GNU General Public License
  along with AvatarMod. If not, see <http://www.gnu.org/licenses/>.
*/

package com.crowsofwar.avatar.common.bending.water;

import com.crowsofwar.avatar.common.bending.AbilityContext;
import com.crowsofwar.avatar.common.bending.BendingAbility;
import com.crowsofwar.avatar.common.bending.BendingType;
import com.crowsofwar.avatar.common.bending.StatusControl;
import com.crowsofwar.avatar.common.data.AvatarPlayerData;
import com.crowsofwar.avatar.common.entity.EntityWaterBubble;
import com.crowsofwar.avatar.common.entity.data.WaterBubbleBehavior;
import com.crowsofwar.gorecore.util.Vector;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * 
 * 
 * @author CrowsOfWar
 */
public class AbilityWaterBubble extends BendingAbility {
	
	public AbilityWaterBubble() {
		super(BendingType.WATERBENDING, "water_bubble");
		requireRaytrace(-1, false);
	}
	
	@Override
	public void execute(AbilityContext ctx) {
		EntityPlayer player = ctx.getPlayerEntity();
		AvatarPlayerData data = ctx.getData();
		World world = ctx.getWorld();
		
		if (ctx.isLookingAtBlock()) {
			IBlockState lookingAtBlock = world.getBlockState(ctx.getClientLookBlock().toBlockPos());
			if (lookingAtBlock.getBlock() == Blocks.WATER) {
				System.out.println("Water bubble");
				Vector pos = ctx.getLookPos();
				EntityWaterBubble bubble = new EntityWaterBubble(world);
				bubble.setPosition(pos.x(), pos.y(), pos.z());
				bubble.setBehavior(new WaterBubbleBehavior.PlayerControlled(bubble));
				bubble.setOwner(player);
				world.spawnEntityInWorld(bubble);
				data.addStatusControl(StatusControl.THROW_BUBBLE);
				data.sync();
			}
		}
	}
	
	@Override
	public int getIconIndex() {
		return 12;
	}
	
}
