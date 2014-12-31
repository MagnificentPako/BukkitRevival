/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.timesync;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TimeSync extends JavaPlugin {

    private int taskId;

    @Override
    public void onEnable(){
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this,new TimeUpdateRunnable(),20L,60*20L);
    }

    @Override
    public void onDisable(){
        Bukkit.getScheduler().cancelTask(taskId);
    }

}
