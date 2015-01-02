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
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class ClickListener implements Listener {

    private TrapsPlus plugin;

    public ClickListener(TrapsPlus p){
        this.plugin = p;
    }

    @EventHandler
    public void on(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Block block = e.getClickedBlock();
            Player p = e.getPlayer();
            if(block.getType() == Material.OBSIDIAN){
                if(plugin.getTraps().containsKey(block.getLocation())) return;
                Material mat = p.getItemInHand().getType();
                switch(mat){
                    case SPIDER_EYE:{
                        sendMessage(p,Traps.POISON);
                        plugin.addTrap(block.getLocation(),Traps.POISON);
                        decreaseItem(p,e);
                        return;
                    }
                    case STRING:{
                        sendMessage(p,Traps.SLOW);
                        plugin.addTrap(block.getLocation(),Traps.SLOW);
                        decreaseItem(p,e);
                        return;
                    }
                    case SLIME_BALL:{
                        sendMessage(p,Traps.BLINDNESS);
                        plugin.addTrap(block.getLocation(),Traps.BLINDNESS);
                        decreaseItem(p,e);
                        return;
                    }
                    case FEATHER:{
                        sendMessage(p,Traps.JUMP);
                        plugin.addTrap(block.getLocation(),Traps.JUMP);
                        decreaseItem(p,e);
                        return;
                    }
                    case GOLDEN_APPLE:{
                        sendMessage(p,Traps.REGENERATION);
                        plugin.addTrap(block.getLocation(),Traps.REGENERATION);
                        decreaseItem(p,e);
                        return;
                    }
                    case DIAMOND:{
                        sendMessage(p,Traps.HEAL);
                        plugin.addTrap(block.getLocation(),Traps.HEAL);
                        decreaseItem(p,e);
                        return;
                    }
                    case IRON_SWORD:{
                        sendMessage(p,Traps.STRENGTH);
                        plugin.addTrap(block.getLocation(),Traps.STRENGTH);
                        decreaseItem(p,e);
                        return;
                    }
                }
            }
        }
    }

    private void sendMessage(Player p,Traps trap){
        p.sendMessage("You created a " + trap.getTrap().getName() + " trap!");
    }

    private void decreaseItem(Player p,PlayerInteractEvent e){
        e.setCancelled(true);
        ItemStack item = p.getItemInHand().clone();
        item.setAmount(item.getAmount()-1);
        p.setItemInHand(item);
    }

}
