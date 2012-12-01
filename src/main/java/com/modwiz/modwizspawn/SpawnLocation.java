package com.modwiz.modwizspawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: starbuck
 * Date: 11/30/12
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpawnLocation implements ConfigurationSerializable {
    public double x, y, z;
    public float pitch, yaw;
    public String world;

    public SpawnLocation(Location loc) {
        x = loc.getX();
        y = loc.getY();
        z = loc.getZ();

        pitch = loc.getPitch();
        yaw = loc.getYaw();
        world = loc.getWorld().getName();
    }

    public SpawnLocation(double x, double y, double z, float pitch, float yaw, World world) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.pitch = pitch;
        this.yaw = yaw;
        this.world = world.getName();
    }

    public Location toLoc() {
        Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        return loc;
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("x", x);
        data.put("y", y);
        data.put("z", z);
        data.put("pitch", pitch);
        data.put("yaw", yaw);
        data.put("world", world);
        return data;
    }

    public static SpawnLocation valueOf(Map<String,Object> data) {
        double x,y,z;
        float yaw, pitch;
        String world;
        World realWorld;
        x = (Double) data.get("x");
        y = (Double) data.get("y");
        z = (Double) data.get("z");
        yaw = new Float((Double) data.get("yaw"));
        pitch = new Float((Double) data.get("pitch"));
        world = (String) data.get("world");
        realWorld = Bukkit.getWorld(world);
        SpawnLocation spawnLoc = new SpawnLocation(x, y, z, pitch, yaw, realWorld);
        return spawnLoc;
    }
}
