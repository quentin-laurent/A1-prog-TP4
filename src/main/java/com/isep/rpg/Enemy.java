package com.isep.rpg;

public abstract class Enemy extends Combatant
{
    // Constructor
    public Enemy(String name)
    {
        super(name);
    }

    // Methods
    abstract void attack(Hero hero);
}
