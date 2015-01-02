/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.trapsplus.traps;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindnessTrap extends Trap {

    public BlindnessTrap() {
        super("Blindness");
    }

    @Override
    public void initConfig(FileConfiguration config) {
        config.addDefault("blindness.duration", 2);
        config.addDefault("blindness.amplifier", 1);
        config.addDefault("blindness.ambient", true);

        duration = config.getInt("blindness.duration");
        amplifier = config.getInt("blindness.amplifier");
        ambient = config.getBoolean("blindness.ambient");
    }

    @Override
    public void trigger(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration*20, amplifier, ambient));
    }
}
