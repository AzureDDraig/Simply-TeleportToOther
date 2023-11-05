package net.ddraig.simplytto.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.ddraig.simplytto.network.SimplyTeleportToOtherModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CooldownTTOProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (1 <= (entity.getCapability(SimplyTeleportToOtherModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyTeleportToOtherModVariables.PlayerVariables())).ttocooldown) {
			{
				double _setval = (entity.getCapability(SimplyTeleportToOtherModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyTeleportToOtherModVariables.PlayerVariables())).ttocooldown - 1;
				entity.getCapability(SimplyTeleportToOtherModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ttocooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
