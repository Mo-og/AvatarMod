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

import com.crowsofwar.avatar.common.bending.StatusControl;
import com.crowsofwar.avatar.common.data.AbilityData;
import com.crowsofwar.avatar.common.data.AbilityData.AbilityTreePath;
import com.crowsofwar.avatar.common.data.Bender;
import com.crowsofwar.avatar.common.data.BendingData;
import com.crowsofwar.avatar.common.data.TickHandler;
import com.crowsofwar.avatar.common.data.ctx.BendingContext;
import com.crowsofwar.avatar.common.particle.NetworkParticleSpawner;
import com.crowsofwar.avatar.common.particle.ParticleSpawner;
import com.crowsofwar.gorecore.util.Vector;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.crowsofwar.avatar.common.bending.StatusControl.SKATING_JUMP;
import static com.crowsofwar.avatar.common.bending.StatusControl.SKATING_START;
import static com.crowsofwar.avatar.common.config.ConfigSkills.SKILLS_CONFIG;
import static com.crowsofwar.avatar.common.config.ConfigStats.STATS_CONFIG;
import static com.crowsofwar.gorecore.util.Vector.toRectangular;
import static java.lang.Math.toRadians;
import static net.minecraft.init.Blocks.WATER;

/**
 * @author CrowsOfWar
 */
public class WaterSkateHandler extends TickHandler {

	private final ParticleSpawner particles;

	public WaterSkateHandler() {
		particles = new NetworkParticleSpawner();
	}

	@Override
	public boolean tick(BendingContext ctx) {
		EntityLivingBase entity = ctx.getBenderEntity();
		World world = ctx.getWorld();
		BendingData data = ctx.getData();

		// The tick handler may be active while the player hasn't started
		// skating yet. To see if they have started skating, check if has they
		// have SKATING_JUMP StatusControl.

		if (!data.hasStatusControl(SKATING_JUMP)) {
			tryStartSkating(data, entity);
		}

		if (data.hasStatusControl(SKATING_JUMP) && skate(data, entity, ctx.getBender())) {
			data.removeStatusControl(StatusControl.SKATING_JUMP);
			data.getMiscData().setCanUseAbilities(true);
			return true;
		} else {
			return false;
		}

	}

	private void tryStartSkating(BendingData data, EntityLivingBase player) {

		if (!player.world.isRemote && data.hasStatusControl(SKATING_START)) {
			if (shouldSkate(player, data.getAbilityData("water_skate"))) {
				data.removeStatusControl(SKATING_START);
				data.addStatusControl(SKATING_JUMP);
			}

		}

	}

	/**
	 * Moves the player and returns whether to stop skating.
	 */
	private boolean skate(BendingData data, EntityLivingBase player, Bender bender) {

		AbilityData abilityData = data.getAbilityData("water_skate");
		double powerRating = bender.calcPowerRating(Waterbending.ID);

		World world = player.world;
		int yPos = getSurfacePos(player);

		if (!player.world.isRemote && !shouldSkate(player, abilityData)) {
			return true;
		} else {

			float requiredChi = STATS_CONFIG.chiWaterSkateSecond / 20f;
			requiredChi -= powerRating / 100 * 0.25f;
			if (bender.consumeChi(requiredChi)) {

				double targetSpeed = abilityData.getLevel() >= 2 ? 1.2 : 0.8;
				targetSpeed += powerRating / 400f;

				if (player.moveForward != 0) {
					if (player.moveForward < 0) {
						targetSpeed /= 2;
					} else {
						targetSpeed *= 1.3;
					}
				}

				player.setPosition(player.posX, yPos + .2, player.posZ);
				Vector currentVelocity = new Vector(player.motionX, player.motionY, player.motionZ);
				Vector targetVelocity = toRectangular(toRadians(player.rotationYaw), 0).times(targetSpeed);

				double targetWeight = 0.1;
				currentVelocity = currentVelocity.times(1 - targetWeight);
				targetVelocity = targetVelocity.times(targetWeight);

				double targetSpeedWeight = 0.2;
				double speed = currentVelocity.magnitude() * (1 - targetSpeedWeight)
						+ targetSpeed * targetSpeedWeight;

				Vector newVelocity = currentVelocity.plus(targetVelocity).normalize().times(speed);

				Vector playerMovement = toRectangular(toRadians(player.rotationYaw - 90),
						toRadians(player.rotationPitch)).times(player.moveStrafing * 0.02);

				newVelocity = newVelocity.plus(playerMovement);

				player.motionX = newVelocity.x();
				player.motionY = 0;
				player.motionZ = newVelocity.z();

				if (player.ticksExisted % 5 == 0) {
					world.playSound(null, player.getPosition(), SoundEvents.ENTITY_PLAYER_SPLASH,
							SoundCategory.PLAYERS, 0.4f, 2f);
					particles.spawnParticles(world, EnumParticleTypes.WATER_SPLASH, 2, 4,
							Vector.getEntityPos(player).plus(0, .4, 0), new Vector(.2, 1, .2));
				}

				if (player.ticksExisted % 10 == 0) {
					abilityData.addXp(SKILLS_CONFIG.waterSkateOneSecond / 2);
				}
				data.getMiscData().setCanUseAbilities(abilityData.getLevel() >= 1);

			}

			if (player.ticksExisted % 10 == 0) {
				abilityData.addXp(SKILLS_CONFIG.waterSkateOneSecond / 2);
			}

		}
		return false;

	}

	/**
	 * Determine if the player is in the ideal conditions to water-skate.
	 */
	private boolean shouldSkate(EntityLivingBase player, AbilityData data) {
		IBlockState below = player.world.getBlockState(new BlockPos(player.getPosition()).down());
		int surface = getSurfacePos(player);

		boolean allowWaterfallSkating = data.isMasterPath(AbilityTreePath.FIRST);
		boolean inWaterBlock = below.getBlock() == Blocks.WATER
				&& (below.getValue(BlockLiquid.LEVEL) == 0 || allowWaterfallSkating);

		return !player.isSneaking() && (player.isInWater() || inWaterBlock) && surface != -1
				&& surface - player.posY <= 3;

	}

	/**
	 * Checks that the player is within 3 blocks of the surface. Returns the y
	 * position at the surface. If the player is out of the water, returns the
	 * player's ypos. If the player is too deep, returns -1.
	 */
	private int getSurfacePos(EntityLivingBase player) {

		World world = player.world;
		if (!player.isInWater()) return (int) player.posY;

		Block in = world.getBlockState(player.getPosition()).getBlock();

		int increased = 1;
		while (in == WATER && increased <= 3) {
			increased++;
			in = world.getBlockState(player.getPosition().up(increased)).getBlock();
		}

		return (int) player.posY + increased;

	}

}
