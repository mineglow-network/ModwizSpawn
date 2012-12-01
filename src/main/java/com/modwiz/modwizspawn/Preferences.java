package com.modwiz.modwizspawn;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created with IntelliJ IDEA.
 * User: starbuck
 * Date: 11/30/12
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Preferences {
    private static Plugin plugin = null;

    public Preferences(Plugin plugin) {
        this.plugin = plugin;
        ConfigurationSerialization.registerClass(SpawnLocation.class);
    }

    public static void saveSpawn(SpawnLocation location, boolean isFirstSpawn) {
        FileConfiguration config = plugin.getConfig();

        if (isFirstSpawn) {
            config.set("firstSpawn", location);
        }   else {
            config.set("mainSpawn", location);
        }
        plugin.saveConfig();
    }

    public static SpawnLocation loadSpawn(boolean isFirstSpawn) {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        SpawnLocation spawnLoc = null;
        if (isFirstSpawn) {
            spawnLoc = (SpawnLocation) config.get("firstSpawn");

        } else {
            spawnLoc = (SpawnLocation) config.get("mainSpawn");
        }
        return spawnLoc;
    }

    public static boolean isFirst(Player player) {
        String playername = player.getName();
        FileConfiguration config = plugin.getConfig();
        boolean isFirst = false;
        if (config.isSet("playerFirstSpawn."+playername)) {
            isFirst = true;
        }
        return isFirst;
    }

    public static void setFirst(Player player) {
        String playername = player.getName();
        FileConfiguration config = plugin.getConfig();
        config.set("playerFirstSpawn." + playername, true);
        plugin.saveConfig();
    }


}
