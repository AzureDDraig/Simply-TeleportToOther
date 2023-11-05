package net.ddraig.simplytto.procedures;

import net.minecraft.world.entity.Entity;

import net.ddraig.simplytto.network.SimplyTeleportToOtherModVariables;

public class TeleportCrystalMakeItemGlowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (0 == (entity.getCapability(SimplyTeleportToOtherModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyTeleportToOtherModVariables.PlayerVariables())).ttocooldown) {
			return true;
		}
		return false;
	}
}
