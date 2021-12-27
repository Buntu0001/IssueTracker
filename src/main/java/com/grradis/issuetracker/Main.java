package com.grradis.issuetracker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    public File pluginFolder = new File(String.valueOf(getDataFolder()));

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(Util.translate("&aIssueTracker 플러그인이 활성화 되었습니다."));
        Bukkit.getLogger().info(Util.translate("&a플러그인 폴더를 확인합니다..."));
        initFolder();
        Util.plugin = this;
    }

    @Override
    public void onDisable() {

    }

    public void initFolder() {
        if (!pluginFolder.exists()) {
            Bukkit.getLogger().info(Util.translate("&c플러그인 폴더가 없습니다."));
            Bukkit.getLogger().info(Util.translate("&c플러그인 폴더를 만듭니다..."));
            pluginFolder.mkdir();
        }
    }
}
