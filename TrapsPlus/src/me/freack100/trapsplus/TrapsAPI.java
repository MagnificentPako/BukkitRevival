/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.trapsplus;

import me.freack100.trapsplus.traps.Traps;
import org.bukkit.Location;

public class TrapsAPI {

    private TrapsPlus plugin;

    public TrapsAPI(TrapsPlus plugin) {
        this.plugin = plugin;
    }

    public boolean isTrap(Location loc) {
        return this.plugin.getTraps().containsKey(loc);
    }

    public void addTrap(Location loc, Traps trap) {
        this.plugin.addTrap(loc, trap);
    }

}
