package net.ddraig.simplytto.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.ddraig.simplytto.network.SimplyTeleportToOtherModVariables;

public class TeleportCrystalRightclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String self = "";
		if (false == itemstack.getOrCreateTag().getBoolean("activated")) {
			itemstack.getOrCreateTag().putBoolean("activated", true);
			itemstack.getOrCreateTag().putString("other", (entity.getDisplayName().getString()));
		} else if (!("null").equals(itemstack.getOrCreateTag().getString("other")) && true == itemstack.getOrCreateTag().getBoolean("activated")) {
			if (0 == (entity.getCapability(SimplyTeleportToOtherModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyTeleportToOtherModVariables.PlayerVariables())).ttocooldown) {
				self = entity.getDisplayName().getString();
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tp" + " " + self + " " + itemstack.getOrCreateTag().getString("other")));
				{
					double _setval = 600;
					entity.getCapability(SimplyTeleportToOtherModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ttocooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
