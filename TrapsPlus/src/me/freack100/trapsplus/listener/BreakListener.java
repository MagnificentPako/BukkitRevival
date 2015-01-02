/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.trapsplus.listener;

import me.freack100.trapsplus.TrapsPlus;
import me.freack100.trapsplus.traps.Traps;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {

    private TrapsPlus plugin;

    public BreakListener(TrapsPlus p){
        this.plugin = p;
    }

    @EventHandler
    public void on(BlockBreakEvent e){
        if(plugin.getTraps().containsKey(e.getBlock().getLocation())){
            Player p = e.getPlayer();
            Traps trap = plugin.getTraps().get(e.getBlock().getLocation());
            p.sendMessage("You broke a " + trap.getTrap().getName() + " Trap!");
            plugin.removeTrap(e.getBlock().getLocation());
        }
    }

}
