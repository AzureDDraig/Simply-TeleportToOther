package net.ddraig.simplytto.procedures;

import net.minecraft.world.item.ItemStack;

public class TeleportCrystalItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("activated", false);
		itemstack.getOrCreateTag().putString("other", "null");
	}
}
