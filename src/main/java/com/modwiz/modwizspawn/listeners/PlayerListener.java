package com.modwiz.modwizspawn.listeners;

import com.modwiz.modwizspawn.Preferences;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created with IntelliJ IDEA.
 * User: starbuck
 * Date: 11/30/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerListener implements Listener {
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (!event.isBedSpawn() && Preferences.isFirst(event.getPlayer())) {
            event.setRespawnLocation(Preferences.loadSpawn(false).toLoc());
        }  else if (!event.isBedSpawn() && (Preferences.isFirst(event.getPlayer())!=true)) {
            event.setRespawnLocation(Preferences.loadSpawn(true).toLoc());
            Preferences.setFirst(event.getPlayer());
        }



    }
}
