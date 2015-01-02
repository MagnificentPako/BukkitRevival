/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.trapsplus.traps;

public enum Traps {

    POISON(new PoisonTrap()),
    BLINDNESS(new BlindnessTrap()),
    JUMP(new JumpTrap()),
    HEAL(new HealTrap()),
    REGENERATION(new RegenerationTrap()),
    STRENGTH(new StrengthTrap()),
    SLOW(new SlowTrap());

    private Trap clazz;

    Traps(Trap clazz){
        this.clazz = clazz;
    }

    public Trap getTrap(){
        return clazz;
    }

}
