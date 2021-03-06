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

package com.crowsofwar.avatar.client.gui;

import com.crowsofwar.avatar.common.bending.Ability;
import com.crowsofwar.avatar.common.bending.BendingStyles;
import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author CrowsOfWar
 */
public class AvatarUiTextures {

	public static final ResourceLocation skillsGui = new ResourceLocation("avatarmod",
			"textures/gui/skillmenu.png");
	public static final ResourceLocation getBending = new ResourceLocation("avatarmod",
			"textures/gui/getbending.png");
	public static final ResourceLocation shieldHealth = new ResourceLocation("avatarmod",
			"textures/gui/shield_health.png");
	public static final ResourceLocation STATUS_CONTROL_ICONS = new ResourceLocation("avatarmod",
			"textures/gui/status_controls.png");
	public static final ResourceLocation CHI_BAR = new ResourceLocation("avatarmod", "textures/gui/chi.png");
	public static final ResourceLocation ICE = new ResourceLocation("minecraft", "textures/blocks/ice.png");
	public static final ResourceLocation[] BLOCK_BREAK = getBlockBreakTextures();
	public static final ResourceLocation WHITE = new ResourceLocation("avatarmod", "textures/gui/white.png");
	static final ResourceLocation radialMenu = new ResourceLocation("avatarmod",
			"textures/radial/circle_segment.png");
	static final ResourceLocation icons = new ResourceLocation("avatarmod", "textures/gui/ability_icons.png");
	static final ResourceLocation blurredIcons = new ResourceLocation("avatarmod",
			"textures/gui/blurred_icons.png");
	private static final Map<Ability, ResourceLocation> abilityTextures = new HashMap<>();
	private static final Map<Ability, ResourceLocation> abilityCards = new HashMap<>();
	private static final Map<Ability, ResourceLocation> abilityCardsPlain = new HashMap<>();
	private static final Map<UUID, ResourceLocation> bendingBackgrounds = new HashMap<>();
	private static final Map<UUID, ResourceLocation> bendingIcons = new HashMap<>();
	private static final Map<UUID, Integer> bendingBackgroundWidth = new HashMap<>();

	private static <T> ResourceLocation getCachedImage(Map<T, ResourceLocation> map, T obj, String loc) {
		if (!map.containsKey(obj)) {
			ResourceLocation location = new ResourceLocation("avatarmod", loc);
			map.put(obj, location);
			return location;
		}
		return map.get(obj);
	}

	public static ResourceLocation getAbilityTexture(Ability ability) {
		return getCachedImage(abilityTextures, ability, "textures/radial/icon_" + ability.getName() + ".png");
	}

	public static ResourceLocation getCardTexture(Ability ability) {
		return getCachedImage(abilityCards, ability, "textures/gui/skillmenu/" + ability.getName() + ".png");
	}

	public static ResourceLocation getPlainCardTexture(Ability ability) {
		return getCachedImage(abilityCardsPlain, ability,
				"textures/gui/skillmenu/" + ability.getName() + "_plain.png");
	}

	public static ResourceLocation getBendingIconTexture(UUID bendingId) {
		String bendingName = BendingStyles.getName(bendingId);
		String location = "textures/gui/icon/" + bendingName + ".png";
		return getCachedImage(bendingIcons, bendingId, location);
	}

	public static ResourceLocation getBendingBackgroundTexture(UUID bendingId) {
		String bendingName = BendingStyles.getName(bendingId);
		String location = "textures/gui/background/" + bendingName + ".png";
		return getCachedImage(bendingBackgrounds, bendingId, location);
	}

	/**
	 * The {@link #getBendingBackgroundTexture(UUID) bending backgrounds} have different dimensions,
	 * so this returns the width in pixels of the specified background image.
	 */
	public static float getBendingBackgroundWidth(UUID bendingId) {

		if (bendingBackgroundWidth.containsKey(bendingId)) {
			return bendingBackgroundWidth.get(bendingId);
		}

		String bendingName = BendingStyles.getName(bendingId);
		InputStream instr = null;
		try {

			String path = "assets/avatarmod/textures/gui/background/";
			String file = path + bendingName + ".png";
			instr = ClassLoader.getSystemClassLoader().getResourceAsStream(file);

			BufferedImage image = ImageIO.read(instr);
			int width = image.getWidth();
			bendingBackgroundWidth.put(bendingId, width);
			return width;

		} catch (Exception ex) {

			throw new RuntimeException("Problem getting width of " + bendingName + " background image", ex);

		} finally {

			if (instr != null) {
				try {
					instr.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}

	/**
	 * The {@link #getBendingBackgroundTexture(UUID) bending backgrounds} have different dimensions,
	 * so this returns the height in pixels of the specified background image.
	 */
	public static float getBendingBackgroundHeight(UUID bendingId) {
		return getBendingBackgroundWidth(bendingId) * 9f / 16;
	}

	private static ResourceLocation[] getBlockBreakTextures() {
		ResourceLocation[] array = new ResourceLocation[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = new ResourceLocation("minecraft", "textures/blocks/destroy_stage_" + i + ".png");
		}
		return array;
	}

}
