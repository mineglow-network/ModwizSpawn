package com.modwiz.modwizspawn.commands;

import com.modwiz.modwizplugins.plugin.command.ModwizCommand;
import com.modwiz.modwizplugins.plugin.command.ModwizExecutor;
import com.modwiz.modwizspawn.ModwizSpawn;
import com.modwiz.modwizspawn.Preferences;
import com.modwiz.modwizspawn.SpawnLocation;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created with IntelliJ IDEA.
 * User: starbuck
 * Date: 11/30/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetSpawnCommand extends ModwizCommand {
    private Plugin plugin = null;
    public SetSpawnCommand(Plugin plugin) {
        super("setspawn");
        this.plugin = plugin;
    }

    @Override
    public boolean runCommand(CommandSender sender, String label, String[] args) {
        if (sender.hasPermission("modwiz.spawn.setspawn") || sender.isOp()) {
            if (sender instanceof Player && (args.length == 0)) {
                Player p = (Player) sender;
                Preferences.saveSpawn(new SpawnLocation(p.getLocation()),false);
                plugin.saveConfig();
                return true;
            } else if (sender instanceof Player && (args.length == 1)) {
                Player p = (Player) sender;
                if (args[0].equalsIgnoreCase("first")) {
                    Preferences.saveSpawn(new SpawnLocation(p.getLocation()), true);
                }

            }
        }
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
