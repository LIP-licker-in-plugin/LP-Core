package com.darksoldier1404.dppc.api.inventory.events;

import com.darksoldier1404.dppc.api.inventory.DInventory;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftContainer;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftInventoryView;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Random;

@SuppressWarnings("all")
public class DInventoryOpenEvent extends InventoryOpenEvent {
    private final DInventory inventory;

    public DInventoryOpenEvent(Player p, DInventory inv) {
        super(new CraftInventoryView(((CraftPlayer) p).getHandle().getBukkitEntity(), inv, new CraftContainer(inv, ((CraftPlayer) p).getHandle(), new Random().nextInt(2100000000))));
        this.inventory = inv;
    }

    public DInventory getDInventory() {
        return inventory;
    }
}
