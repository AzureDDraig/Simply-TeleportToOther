
package net.ddraig.simplytto.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.ddraig.simplytto.item.TeleportCrystalItem;
import net.ddraig.simplytto.SimplyTeleportToOtherMod;

public class SimplyTeleportToOtherModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SimplyTeleportToOtherMod.MODID);
	public static final RegistryObject<Item> TELEPORT_CRYSTAL = REGISTRY.register("teleport_crystal", () -> new TeleportCrystalItem());
}
