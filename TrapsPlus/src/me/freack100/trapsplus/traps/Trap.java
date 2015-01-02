/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.trapsplus.traps;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public abstract class Trap {

    int duration = 20*1;
    int amplifier = 1;
    boolean ambient = true;

    private String name;

    public Trap(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final void initConfig(FileConfiguration config){
        String key = this.name.toLowerCase();
        config.addDefault(key+".duration", 2);
        config.addDefault(key+".amplifier", 1);
        config.addDefault(key+".ambient", true);

        duration = config.getInt(key+".duration");
        amplifier = config.getInt(key+".amplifier");
        ambient = config.getBoolean(key+".ambient");
    };

    public abstract void trigger(Player player);

}
