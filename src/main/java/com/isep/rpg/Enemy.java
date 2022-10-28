package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public abstract class Enemy extends Combatant
{
    // Constructor
    public Enemy(String name, int hp, int baseDamage)
    {
        super(name, hp, baseDamage);
    }

    // Methods
    abstract void attack(Hero hero) throws ExecutionControl.NotImplementedException;
}
