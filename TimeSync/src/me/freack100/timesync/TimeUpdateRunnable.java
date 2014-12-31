/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.timesync;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;

public class TimeUpdateRunnable implements Runnable {

    private TimeConverter converter = new TimeConverter();

    @Override
    public void run() {
        List<World> worlds = Bukkit.getWorlds();
        for(World world : worlds){
            //Only update the world when there is a player inside
            if(world.getPlayers().size() > 0) {
                world.setTime(converter.time2Code(converter.time()));
            }
        }
        System.out.println("UPDATE: "+ converter.time());
    }

}
