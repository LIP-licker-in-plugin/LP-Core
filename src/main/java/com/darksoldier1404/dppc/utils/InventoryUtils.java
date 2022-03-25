package com.darksoldier1404.dppc.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class InventoryUtils {

    public static boolean mergeItem(Inventory inv, ItemStack item) {
        if(inv instanceof PlayerInventory) {
            Inventory vi = Bukkit.createInventory(null, 36);
            vi.setContents(inv.getStorageContents());
            if(vi.addItem(item).size() == 0) {
                inv.addItem(item);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
