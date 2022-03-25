package com.darksoldier1404.dppc.utils;

import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("all")
public class ColorUtils {
    public static String applyColor(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
