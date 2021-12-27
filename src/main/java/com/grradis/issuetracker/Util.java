package com.grradis.issuetracker;

import org.bukkit.ChatColor;

public class Util {
    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static Main plugin;
}
