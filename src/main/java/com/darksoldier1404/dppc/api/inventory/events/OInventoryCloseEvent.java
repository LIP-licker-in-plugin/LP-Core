package com.darksoldier1404.dppc.api.inventory.events;

import com.darksoldier1404.dppc.api.inventory.OInventory;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftContainer;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftInventoryView;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.Random;

@SuppressWarnings("all")
public class OInventoryCloseEvent extends InventoryCloseEvent {
    private final OInventory inventory;

    public OInventoryCloseEvent(Player p, OInventory inv) {
        super(new CraftInventoryView(((CraftPlayer) p).getHandle().getBukkitEntity(), inv.getInv(), new CraftContainer(inv.getInv(), ((CraftPlayer) p).getHandle(), new Random().nextInt(2100000000))));
        this.inventory = inv;
    }

    public OInventory getOInventory() {
        return inventory;
    }
}
