package com.modwiz.modwizspawn;

import com.modwiz.modwizplugins.plugin.ModwizPlugin;
import com.modwiz.modwizspawn.commands.SetSpawnCommand;
import com.modwiz.modwizspawn.commands.SpawnCommand;
import com.modwiz.modwizspawn.listeners.PlayerListener;
import org.bukkit.Location;

/**
 * Created with IntelliJ IDEA.
 * User: starbuck
 * Date: 11/30/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModwizSpawn extends ModwizPlugin{
    public Preferences spawn = new Preferences(this);


    @Override
    public void enable() {

        commandHandler.registerCommand(new SetSpawnCommand(this));
        commandHandler.registerCommand(new SpawnCommand(this));
        getPM().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void disable() {
    }


}
