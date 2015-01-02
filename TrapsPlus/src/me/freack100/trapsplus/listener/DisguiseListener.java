/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.trapsplus.listener;

import me.freack100.trapsplus.TrapsPlus;
import me.freack100.trapsplus.traps.Traps;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DisguiseListener implements Listener {

    private TrapsPlus plugin;

    public DisguiseListener(TrapsPlus p){
        this.plugin = p;
    }

    @EventHandler
    public void on(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(plugin.getTraps().containsKey(e.getClickedBlock().getLocation())){
                //Don't do that! It's a Trap!
                Player p = e.getPlayer();
                Material mat = p.getItemInHand().getType();
                if(mat.isBlock() && mat.isSolid()){
                    e.getClickedBlock().setType(mat);
                    p.sendMessage("You disguised a Trap!");
                    p.getItemInHand().setAmount(p.getItemInHand().getAmount()-1);
                    e.setCancelled(true);
                    //TODO: Get the bug of the "hidden" block fixed.
                }
            }
        }
    }

}
