package com.modwiz.modwizspawn.commands;

import com.modwiz.modwizplugins.plugin.command.ModwizCommand;
import com.modwiz.modwizspawn.Preferences;
import com.modwiz.modwizspawn.SpawnLocation;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created with IntelliJ IDEA.
 * User: starbuck
 * Date: 11/30/12
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpawnCommand extends ModwizCommand {
    Plugin plugin = null;
    public SpawnCommand(Plugin plugin) {
        super("spawn");
        this.plugin = plugin;

    }
    @Override
    public boolean runCommand(CommandSender commandSender, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            SpawnLocation spawn = Preferences.loadSpawn(false);
            if (strings.length == 1) {
                spawn = Preferences.loadSpawn(true);
            }
            p.teleport(spawn.toLoc());
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
